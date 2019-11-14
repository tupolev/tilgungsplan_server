package de.sparkasse.tilgungsplan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.List;

public class Tilgungsplan {
    private TilgungsplanAnfrage anfrage;
    private Double monatsRate;
    private Double restSchuld;
    private List<Tilgung> tilgungen;

    public Tilgungsplan(TilgungsplanAnfrage tilgungsplanAnfrage) {
        this.anfrage = tilgungsplanAnfrage;
        this.tilgungen = new ArrayList<Tilgung>();
    }

    public TilgungsplanAnfrage getAnfrage() {
        return this.anfrage;
    }

    public void addTilgung(Tilgung tilgung) {
        this.tilgungen.add(tilgung);
    }

    public List<Tilgung> getTilgungen() {
        return this.tilgungen;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    public Double getMonatsRate() {
        return monatsRate;
    }

    public void setMonatsRate(Double monatsRate) {
        this.monatsRate = monatsRate;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    public Double getRestSchuld() {
        return restSchuld;
    }

    public void setRestSchuld(Double restSchuld) {
        this.restSchuld = restSchuld;
    }
}
