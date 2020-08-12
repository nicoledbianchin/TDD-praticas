package test.lance.domain;

import main.com.thoughtworks.lance.domain.Lance;
import main.com.thoughtworks.lance.domain.Leilao;
import main.com.thoughtworks.lance.domain.Usuario;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeilaoTeste {

    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new Leilao("Playstation 3");
        assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("trixie"), 3000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(3000, leilao.getLances().get(0).getValor(), 0.0001);
    }

    @Test
    public void deveReceberVariosLances() {
        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(new Usuario("trixie"), 3000));
        leilao.propoe(new Lance(new Usuario("katya"), 2000));
        leilao.propoe(new Lance(new Usuario("jinkx"), 4000));

        assertEquals(3, leilao.getLances().size());
        assertEquals(3000, leilao.getLances().get(0).getValor(), 0.00001);
        assertEquals(2000, leilao.getLances().get(1).getValor(), 0.00001);
        assertEquals(4000, leilao.getLances().get(2).getValor(), 0.00001);
    }

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
        Leilao leilao = new Leilao("Playstation 3");
        Usuario trixie = new Usuario("trixie");

        leilao.propoe(new Lance(trixie, 3000));
        leilao.propoe(new Lance(trixie, 2000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(3000, leilao.getLances().get(0).getValor(), 0.00001);
    }

    @Test
    public void naoDeveAceitarMaisDe5LancesDoMesmoUsuario() {
        Leilao leilao = new Leilao("Playstation 3");
        Usuario trixie = new Usuario("trixie");
        Usuario katya = new Usuario("katya");

        leilao.propoe(new Lance(trixie, 150));
        leilao.propoe(new Lance(katya, 200));
        leilao.propoe(new Lance(trixie, 250));
        leilao.propoe(new Lance(katya, 300));
        leilao.propoe(new Lance(trixie, 350));
        leilao.propoe(new Lance(katya, 400));
        leilao.propoe(new Lance(trixie, 450));
        leilao.propoe(new Lance(katya, 500));
        leilao.propoe(new Lance(trixie, 550));
        leilao.propoe(new Lance(katya, 600));

        leilao.propoe(new Lance(trixie, 650));
        leilao.propoe(new Lance(katya, 700));

        assertEquals(10, leilao.getLances().size());
        assertEquals(600, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);

    }

}
