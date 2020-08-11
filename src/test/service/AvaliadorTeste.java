package test.service;

import main.com.thoughtworks.lance.domain.Lance;
import main.com.thoughtworks.lance.domain.Leilao;
import main.com.thoughtworks.lance.domain.Usuario;
import main.com.thoughtworks.lance.service.Avaliador;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AvaliadorTeste {

    @Test
    public void deveEntenderLancesEmOrdemDescrescente() {
        Usuario trixie = new Usuario("Trixie");
        Usuario katya = new Usuario("Katya");
        Usuario jinkx = new Usuario("Jinkx");

        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(trixie, 250.0));
        leilao.propoe(new Lance(katya, 300.0));
        leilao.propoe(new Lance(jinkx, 400.0));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;


        assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.000001);
        assertEquals(menorEsperado, avaliador.getMenorLance(), 0.000001);
    }

    @Test
    public void deveCalcularMedia() {
        Usuario trixie = new Usuario("Trixie");
        Usuario katya = new Usuario("Katya");
        Usuario jinkx = new Usuario("Jinkx");

        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(trixie, 250.0));
        leilao.propoe(new Lance(katya, 300.0));
        leilao.propoe(new Lance(jinkx, 400.0));

        Avaliador avaliador = new Avaliador();
        avaliador.calculaMedia(leilao.getLances());
        double mediaAtual = avaliador.getMedia();

        double mediaEsperada = 316.666666666666;

        assertEquals(mediaEsperada, mediaAtual, 0.00001);
    }

    @Test
    public void deveRetornarZer0() {
        Usuario trixie = new Usuario("Trixie");

        Leilao leilao = new Leilao("Televisão");

        Avaliador avaliador = new Avaliador();
        avaliador.calculaMedia(leilao.getLances());
        double media = avaliador.getMedia();

        assertEquals(0, media, 0.0001);
    }

    @Test
    public void deveEntenderLeilaoComUmLance() {
        Usuario trixie = new Usuario("Trixie");

        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(trixie, 1000.0));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        assertEquals(1000.0, avaliador.getMaiorLance(), 0.00001);
        assertEquals(1000.0, avaliador.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario trixie = new Usuario("Trixie");
        Usuario katya = new Usuario("Katya");

        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(trixie, 100.0));
        leilao.propoe(new Lance(katya, 200.0));
        leilao.propoe(new Lance(trixie, 300.0));
        leilao.propoe(new Lance(katya, 400.0));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        List<Lance> maiores = avaliador.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveEncontrarLancesEmOrdemAleatoria() {
        Usuario trixie = new Usuario("Trixie");
        Usuario katya = new Usuario("Katya");

        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(trixie, 200.0));
        leilao.propoe(new Lance(katya, 450.0));
        leilao.propoe(new Lance(trixie, 120.0));
        leilao.propoe(new Lance(katya, 700.0));
        leilao.propoe(new Lance(trixie, 630.0));
        leilao.propoe(new Lance(katya, 230.0));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        assertEquals(700, avaliador.getMaiorLance(), 0.00001);
        assertEquals(120, avaliador.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarLancesEmOrdemDecrescente() {
        Usuario trixie = new Usuario("Trixie");
        Usuario katya = new Usuario("Katya");

        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(trixie, 400.0));
        leilao.propoe(new Lance(katya, 300.0));
        leilao.propoe(new Lance(trixie, 200.0));
        leilao.propoe(new Lance(katya, 100.0));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        assertEquals(400, avaliador.getMaiorLance(), 0.00001);
        assertEquals(100, avaliador.getMenorLance(), 0.00001);
    }
}
