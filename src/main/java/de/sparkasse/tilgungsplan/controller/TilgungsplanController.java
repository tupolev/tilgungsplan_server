package de.sparkasse.tilgungsplan.controller;

import de.sparkasse.tilgungsplan.model.TilgungsplanBerechner;
import de.sparkasse.tilgungsplan.pojo.Tilgungsplan;
import de.sparkasse.tilgungsplan.pojo.TilgungsplanAnfrage;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@CrossOrigin()
@RestController
public class TilgungsplanController {
    @RequestMapping(method= RequestMethod.GET, path = "/berechnen")
    public Tilgungsplan berechnen(
            @RequestParam(value="darlehensbetrag", defaultValue="0") @NotNull @Valid Double darlehensbetrag,
            @RequestParam(value="sollzinssatz", defaultValue="0")  @NotNull @Valid Double sollzinssatz,
            @RequestParam(value="tilgung", defaultValue="0")  @NotNull @Valid Double tilgung,
            @RequestParam(value="zinsbindungsdauer")  @Nullable @Min(1) @Max(30) Integer zinsbindungsdauer
    ) {
        TilgungsplanAnfrage tilgungsplanAnfrage = new TilgungsplanAnfrage(darlehensbetrag, sollzinssatz, tilgung, zinsbindungsdauer);
        Tilgungsplan tilgungsplan = new Tilgungsplan(tilgungsplanAnfrage);
        TilgungsplanBerechner berechner = new TilgungsplanBerechner(tilgungsplan);

        return berechner.berechnen().getTilgungsplan();
    }
}
