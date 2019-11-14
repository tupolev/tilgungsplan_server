package de.sparkasse.tilgungsplan.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Tilgung {
    private LocalDate datum;
    private Integer monat;
    private Double jahrTilgungProzent;
    private Double jahrZinsProzent;
    private Double betragsWert;
    private Double zinsWert;
    private Double restBetrag;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    public Integer getMonat() {
        return monat;
    }

    public void setMonat(Integer monat) {
        this.monat = monat;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    public Double getJahrTilgungProzent() {
        return jahrTilgungProzent;
    }

    public void setJahrTilgungProzent(Double jahrTilgungProzent) {
        this.jahrTilgungProzent = jahrTilgungProzent;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    public Double getJahrZinsProzent() {
        return jahrZinsProzent;
    }

    public void setJahrZinsProzent(Double jahrZinsProzent) {
        this.jahrZinsProzent = jahrZinsProzent;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    public Double getBetragsWert() {
        return betragsWert;
    }

    public void setBetragsWert(Double betragsWert) {
        this.betragsWert = betragsWert;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    public Double getZinsWert() {
        return zinsWert;
    }

    public void setZinsWert(Double zinsWert) {
        this.zinsWert = zinsWert;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    public Double getRestBetrag() {
        return restBetrag;
    }

    public void setRestBetrag(Double restBetrag) {
        this.restBetrag = restBetrag;
    }
}
