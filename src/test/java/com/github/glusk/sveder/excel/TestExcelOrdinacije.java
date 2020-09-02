package com.github.glusk.sveder.excel;

import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.junit.Test;

public final class TestExcelOrdinacije {
    @Test
    public void izpiseVseOrdinacije() throws Exception {
        StringBuilder testFileLines = new StringBuilder();
        new ExcelOrdinacije(
            this.getClass().getResource("Zob_12_18.xls")
        )
        .ordinacije()
        .stream()
        .forEach(
            o -> testFileLines.append(
                String.format(
                    "%5d %s %5d %s\r\n",
                    o.izvajalec().intValue(),
                    o.dejavnost(),
                    o.zdravnik().sifra().intValue(),
                    new DecimalFormat(
                        "#.##",
                        new DecimalFormatSymbols(
                            new Locale("sl")
                        )
                    ).format(
                        o.doseganjePovprecja().doubleValue()
                    )
                )
            )
        );
        File tmp = File.createTempFile("tmp", ".txt");
        tmp.deleteOnExit();
        try (
            BufferedWriter out =
                new BufferedWriter(
                    new FileWriter(
                        tmp,
                        StandardCharsets.UTF_8
                    )
                )
        ) {
            out.write(testFileLines.toString());
        }
        assertArrayEquals(
            "Datoteki se ne ujemata!",
            Files.readAllBytes(tmp.toPath()),
            Files.readAllBytes(
                Paths.get(
                    this.getClass()
                        .getResource("seznamOrdinacij.txt")
                        .toURI()
                )
            )
        );
    }
}
