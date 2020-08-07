package test.service;

import main.com.thoughtworks.lance.domain.Lance;
import main.com.thoughtworks.lance.domain.Leilao;
import main.com.thoughtworks.lance.domain.Usuario;
import main.com.thoughtworks.lance.service.Avaliador;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        Assert.assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.000001);
        Assert.assertEquals(menorEsperado, avaliador.getMenorLance(), 0.000001);
    }

    @Test
    public void deveCalcularMedia() {
        Usuario trixie = new Usuario("Trixie");
        Usuario katya = new Usuario("Katya");
        Usuario jinkx = new Usuario("Jinkx");

        Leilao leilao = new Leilao("Playstation 3");

        Lance lanceTrixie = new Lance(trixie, 250.0);
        leilao.propoe(lanceTrixie);
        Lance lanceKatya = new Lance(katya, 300.0);
        leilao.propoe(lanceKatya);
        Lance lanceJinkx = new Lance(jinkx, 400.0);
        leilao.propoe(lanceJinkx);

        List<Double> lances = new ArrayList<>();
        lances.add(lanceTrixie.getValor());
        lances.add(lanceKatya.getValor());
        lances.add(lanceJinkx.getValor());

        Avaliador avaliador = new Avaliador();
        avaliador.calculaMedia(lances);
        double mediaAtual = avaliador.getMedia();

        double mediaEsperada = 316.666666666666;

        Assert.assertEquals(mediaEsperada, mediaAtual, 0.00001);
    }
}
