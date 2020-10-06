package com.github.glusk.sveder.excel;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

public final class TestKljucOrdinacije {
    @Test
    public void potrdiUjemanjeVrsticePoKljucu() throws IOException {
        assertTrue(
            new KljucOrdinacije(
                () -> "12345",
                () -> "404101",
                () -> "1234"
            ).test(
                WorkbookFactory.create(
                    this.getClass()
                        .getResource("ZOBEK_UrnCD.xlsx")
                        .openStream()
                ).getSheet("UrnikiIZV")
                 .getRow(1)
            )
        );
    }
}
