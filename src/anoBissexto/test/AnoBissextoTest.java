package anoBissexto.test;

import anoBissexto.main.AnoBissexto;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AnoBissextoTest {
    @Test
    public void deveRetornarAnoBissexto() {
        AnoBissexto anoBissexto = new AnoBissexto();

        assertEquals(true, anoBissexto.eBissexto(2016));
        assertEquals(true, anoBissexto.eBissexto(2012));
    }

    @Test
    public void naoDeveRetornarAnoBissexto() {
        AnoBissexto anoBissexto = new AnoBissexto();

        assertEquals(false, anoBissexto.eBissexto(2015));
        assertEquals(false, anoBissexto.eBissexto(2011));
    }
}
