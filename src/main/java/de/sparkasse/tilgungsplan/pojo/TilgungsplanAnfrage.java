package de.sparkasse.tilgungsplan.pojo;

public class TilgungsplanAnfrage {
    private final Double darlehensbetrag;
    private final Double sollzinssatz;
    private final Double jahrTilgungProzent;
    private final Integer zinsbindungsdauer;

    public TilgungsplanAnfrage(Double darlehensbetrag, Double sollzinssatz, Double jahrTilgungProzent, Integer zinsbindungsdauer) {
        this.darlehensbetrag = darlehensbetrag;
        this.sollzinssatz = sollzinssatz;
        this.jahrTilgungProzent = jahrTilgungProzent;
        this.zinsbindungsdauer = zinsbindungsdauer;
    }

    public Double getDarlehensbetrag() {
        return darlehensbetrag;
    }

    public Double getSollzinssatz() {
        return sollzinssatz;
    }

    public Double getJahrTilgungProzent() {
        return jahrTilgungProzent;
    }

    public Integer getZinsbindungsdauer() {
        return zinsbindungsdauer;
    }
}
