package leilao.test.service;

import leilao.main.domain.Lance;
import leilao.main.domain.Leilao;
import leilao.main.domain.Usuario;
import leilao.main.service.Avaliador;

import leilao.test.builder.CriadorDeLeilao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AvaliadorTeste {

    private Avaliador avaliador;
    private Usuario trixie;
    private Usuario katya;
    private Usuario jinkx;

    @Before
    public void setup() {
        this.avaliador = new Avaliador();
        this.trixie = new Usuario("Trixie");
        this.katya = new Usuario("Katya");
        this.jinkx =  new Usuario("Jinkx");
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveAvaliarLeilaoSemNenhumLanceDado() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .constroi();

        avaliador.avalia(leilao);
    }

    @Test
    public void deveEntenderLancesEmOrdemDescrescente() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .lance(trixie, 250.0)
                .lance(katya, 300.0)
                .lance(jinkx, 400.0)
                .constroi();

        avaliador.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;

        assertThat(avaliador.getMaiorLance(), equalTo(maiorEsperado));
        assertThat(avaliador.getMenorLance(), equalTo(menorEsperado));
    }

    @Test
    public void deveCalcularMedia() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .lance(trixie, 250.0)
                .lance(katya, 300.0)
                .lance(jinkx, 400.0)
                .constroi();

        avaliador.calculaMedia(leilao.getLances());
        double mediaAtual = avaliador.getMedia();

        double mediaEsperada = 316.6666666666667;

        assertThat(mediaAtual, equalTo(mediaEsperada));
    }

    @Test
    public void deveRetornarZer0() {
        Leilao leilao = new CriadorDeLeilao().para("Televisão")
                .constroi();

        avaliador.calculaMedia(leilao.getLances());
        double media = avaliador.getMedia();

        assertThat(media, equalTo(0.0));
    }

    @Test
    public void deveEntenderLeilaoComUmLance() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .lance(trixie, 1000.0)
                .constroi();

        avaliador.avalia(leilao);

        assertThat(avaliador.getMaiorLance(), equalTo(1000.0));
        assertThat(avaliador.getMenorLance(), equalTo(1000.0));
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .lance(trixie, 100.0)
                .lance(katya, 200.0)
                .lance(trixie, 300.0)
                .lance(katya, 400.0)
                .constroi();


        avaliador.avalia(leilao);

        List<Lance> maiores = avaliador.getTresMaiores();

        assertThat(maiores.size(), equalTo(3));
        assertThat(maiores.get(0).getValor(), equalTo(400.0));
        assertThat(maiores.get(1).getValor(), equalTo(300.0));
        assertThat(maiores.get(2).getValor(), equalTo(200.0));
    }

    @Test
    public void deveEncontrarLancesEmOrdemAleatoria() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .lance(trixie, 200.0)
                .lance(katya, 450.0)
                .lance(trixie, 120.0)
                .lance(katya, 700.0)
                .lance(trixie, 630.0)
                .lance(katya, 230.0)
                .constroi();

        avaliador.avalia(leilao);

        assertThat(avaliador.getMaiorLance(), equalTo(700.0));
        assertThat(avaliador.getMenorLance(), equalTo(120.0));
    }

    @Test
    public void deveEncontrarLancesEmOrdemDecrescente() {
        Leilao leilao = new  CriadorDeLeilao().para("Playstation 3")
                .lance(trixie, 400.0)
                .lance(katya, 300.0)
                .lance(trixie, 200.0)
                .lance(katya, 100.0)
                .constroi();

        avaliador.avalia(leilao);

        assertThat(avaliador.getMaiorLance(), equalTo(400.0));
        assertThat(avaliador.getMenorLance(), equalTo(100.0));
    }

    @Test
    public void deveEncontrarTresMaioresEmCincoLances() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .lance(trixie, 400.0)
                .lance(katya, 300.0)
                .lance(trixie, 200.0)
                .lance(katya, 100.0)
                .lance(trixie, 700.0)
                .constroi();

        avaliador.avalia(leilao);

        List<Lance> maiores = avaliador.getTresMaiores();

        assertThat(maiores.size(), equalTo(3));
        assertThat(maiores.get(0).getValor(), equalTo(700.0));
        assertThat(maiores.get(1).getValor(), equalTo(400.0));
        assertThat(maiores.get(2).getValor(), equalTo(300.0));
    }

    @Test
    public void deveEncontrarDoisMaioresEmDoisLances() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .lance(trixie, 400.0)
                .lance(katya, 300.0)
                .constroi();

        avaliador.avalia(leilao);

        List<Lance> maiores = avaliador.getTresMaiores();

        assertThat(maiores.size(), equalTo(2));
        assertThat(maiores.get(0).getValor(), equalTo(400.0));
        assertThat(maiores.get(1).getValor(), equalTo(300.0));
    }

     @Test(expected = RuntimeException.class)
    public void deveEncontrarlistaVazia() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
                .constroi();

         avaliador.avalia(leilao);

        List<Lance> maiores = avaliador.getTresMaiores();

        assertThat(maiores.size(), equalTo(0));
    }
}
