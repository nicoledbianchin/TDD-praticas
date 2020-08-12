package test.lance.service;

import main.com.thoughtworks.lance.domain.Lance;
import main.com.thoughtworks.lance.domain.Usuario;
import main.com.thoughtworks.lance.service.FiltroDeLances;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FiltroDeLancesTeste {

    @Test
    public void deveSelecionarLancesEntre1000E3000() {
        Usuario trixie = new Usuario("Trixie");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(trixie,2000),
                new Lance(trixie,1000),
                new Lance(trixie,3000),
                new Lance(trixie, 800)));

        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesEntre500E700() {
        Usuario trixie = new Usuario("Trixie");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(trixie,600),
                new Lance(trixie,500),
                new Lance(trixie,700),
                new Lance(trixie, 800)));

        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesMaioresDe5000() {
        Usuario trixie = new Usuario("Trixie");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(trixie,200),
                new Lance(trixie,100),
                new Lance(trixie,800),
                new Lance(trixie, 6000)));

        assertEquals(1, resultado.size());
        assertEquals(6000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveEliminarLancesMenoresDe500() {
        Usuario trixie = new Usuario("Trixie");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(trixie,200),
                new Lance(trixie,100),
                new Lance(trixie,120),
                new Lance(trixie, 499)));

        assertEquals(0, resultado.size());
    }

    @Test
    public void deveeLIMINARLancesEntre700E1000() {
        Usuario trixie = new Usuario("Trixie");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(trixie,800),
                new Lance(trixie,900),
                new Lance(trixie,701),
                new Lance(trixie, 740)));

        assertEquals(0, resultado.size());
    }

    @Test
    public void deveeLIMINARLancesEntre3000E5000() {
        Usuario trixie = new Usuario("Trixie");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(trixie,3100),
                new Lance(trixie,4000),
                new Lance(trixie,4500),
                new Lance(trixie, 3001)));

        assertEquals(0, resultado.size());
    }

}
