package com.github.glusk.sveder.orodja;

import java.util.List;

/** Ujemanja vzorca v nekem nizu, datoteki... */
public interface Ujemanja {
    /**
     * Vrne vsa najdena ujemanja.
     *
     * @return seznam ujemanj
     */
    List<String> ujemanja();
}
