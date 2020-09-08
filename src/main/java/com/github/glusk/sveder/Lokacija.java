package com.github.glusk.sveder;

import java.io.IOException;

import org.json.JSONObject;

/** Lokacija zdravstvene ordinacije. */
public interface Lokacija extends SvederTip {
    /**
     * Vrne šifro te lokacije.
     *
     * @return 6-mestna šifra lokacije
     */
    Number sifra();
    @Override
    default JSONObject json() throws IOException {
        return new JSONObject()
            .put("id_lokacija", sifra().intValue());
    }
}