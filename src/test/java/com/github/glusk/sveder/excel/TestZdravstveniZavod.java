package com.github.glusk.sveder.excel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import com.github.glusk.sveder.net.SvederUrl;

import org.junit.jupiter.api.Test;

public final class TestZdravstveniZavod {
    @Test
    public void najdeZdravnikaVPreglednici() throws IOException {
        assertEquals(
            7809,
            new NumericnaCelica(
                new ZdravstveniZavod(
                    new SvederUrl.UrlOvoj(
                        this.getClass()
                            .getResource("ZOB_ZAVOD_D_IN_G_KOPER_UrnCD.xlsx")
                            .toString()
                    )
                )
                .preglednica()
                .getSheet("NosilciTimaIZV")
                .getRow(1),
                0
            ).intValue()
        );
    }
    @Test
    public void vrnePreglednicoZavodaZgrajenegaIzZzzsStevilke() {
        assertDoesNotThrow(() ->
            new ZdravstveniZavod(6189896).preglednica()
        );
    }
    @Test
    public void vrzeIzjemoCeJeNaURLjuPregledniceWordovDokument() {
        assertThrows(IOException.class, () ->
            new ZdravstveniZavod(
                new SvederUrl.UrlOvoj(
                    this.getClass()
                        .getResource("PrazenWordovDokument.docx")
                        .toString()
                )
            )
            .preglednica()
        );
    }
}
