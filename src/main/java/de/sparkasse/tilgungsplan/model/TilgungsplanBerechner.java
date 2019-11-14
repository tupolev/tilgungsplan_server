package de.sparkasse.tilgungsplan.model;


import de.sparkasse.tilgungsplan.pojo.Tilgung;
import de.sparkasse.tilgungsplan.pojo.Tilgungsplan;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TilgungsplanBerechner {
    private Tilgungsplan tilgungsplan;

    public TilgungsplanBerechner(Tilgungsplan tilgungsplan) {
        this.tilgungsplan = tilgungsplan;
    }

    public TilgungsplanBerechner berechnen() {
        //0 - is this a limited time fixed interest calculation?
        Integer zinsbindungsdauer = this.getTilgungsplan().getAnfrage().getZinsbindungsdauer();

        //1- calculate number of quotes
        Double monatTilgungWert = this.getMonatTilgungWert();
        Double monatZinsWert = this.getMonatZinsWert();
        this.tilgungsplan.setMonatsRate(monatTilgungWert +  monatZinsWert);

        //2 - If limited time fixed interest calculation, num quotes is specified years * 12
        Integer numTilgungen = (zinsbindungsdauer != null) && (zinsbindungsdauer > 0)
                ? zinsbindungsdauer * 12
                : this.getTilgungenCountAusMonatTilgungWert(monatTilgungWert);

        Double restBetrag = this.tilgungsplan.getAnfrage().getDarlehensbetrag();
        //3- iterate thorugh number of quotes to create quote data objects and add them to the plan
        for (int numMonat = 1; numMonat <= numTilgungen; numMonat++) {
            Tilgung tilgung = new Tilgung();
            LocalDate datum = LocalDateTime.now().plusMonths(numMonat).toLocalDate().withDayOfMonth(1);
            tilgung.setDatum(datum);
            tilgung.setMonat(numMonat);
            tilgung.setJahrTilgungProzent(this.tilgungsplan.getAnfrage().getJahrTilgungProzent());
            tilgung.setJahrZinsProzent(this.tilgungsplan.getAnfrage().getSollzinssatz());
            if (restBetrag > monatTilgungWert) {
                restBetrag -= monatTilgungWert;
                tilgung.setBetragsWert(monatTilgungWert);
                tilgung.setRestBetrag(restBetrag);
                this.tilgungsplan.setRestSchuld(restBetrag);
            } else {
                //4- last quote is the whole rest
                tilgung.setBetragsWert(restBetrag);
                tilgung.setRestBetrag(0.0);
                this.tilgungsplan.setRestSchuld(0.0);
            }
            //5- interests are computed with yearly index and local monthly quote
            tilgung.setZinsWert(monatZinsWert);

            //6- quote is added to plan
            this.tilgungsplan.addTilgung(tilgung);
        }

        return this;
    }

    private Double getMonatZinsWert() {
        return ((this.tilgungsplan.getAnfrage().getDarlehensbetrag() * this.tilgungsplan.getAnfrage().getSollzinssatz()) / 100) / 12;
    }

    private Double getMonatTilgungWert() {
        Double darlehensbetrag = this.tilgungsplan.getAnfrage().getDarlehensbetrag();
        Double jahrTilgungProzent = this.tilgungsplan.getAnfrage().getJahrTilgungProzent();
        Double jahrTilgungWert = (darlehensbetrag * jahrTilgungProzent) / 100;

        return jahrTilgungWert / 12;
    }

    private Integer getTilgungenCountAusMonatTilgungWert(Double monatTilgungWert) {
        return (int) Math.ceil(this.tilgungsplan.getAnfrage().getDarlehensbetrag() / monatTilgungWert);
    }

    public Tilgungsplan getTilgungsplan() {
        return this.tilgungsplan;
    }
}
