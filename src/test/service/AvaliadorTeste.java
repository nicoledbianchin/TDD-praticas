package test.service;

import main.com.thoughtworks.lance.domain.Lance;
import main.com.thoughtworks.lance.domain.Leilao;
import main.com.thoughtworks.lance.domain.Usuario;
import main.com.thoughtworks.lance.service.Avaliador;

import org.junit.Assert;
import org.junit.Test;

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
}
