package leilao.test.domain;

import leilao.main.domain.Lance;
import leilao.main.domain.Leilao;
import leilao.main.domain.Usuario;
import org.junit.Test;

import static leilao.test.matchers.LeilaoMatcher.temUmLance;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LeilaoTeste {

    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new Leilao("Playstation 3");
        assertEquals(0, leilao.getLances().size());

        Lance lance = new Lance(new Usuario("trixie"), 3000);
        leilao.propoe(lance);

        assertThat(leilao.getLances().size(), equalTo(1));
        assertThat(leilao, temUmLance(lance));
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

    @Test
    public void deveDobrarLanceDoUsuarioComApenasUmLance() {
        Leilao leilao = new Leilao("playstation 3");
        Usuario trixie = new Usuario("trixie");
        Usuario katya = new Usuario("katya");

        leilao.propoe(new Lance(trixie, 200));
        leilao.propoe(new Lance(katya, 600));
        leilao.dobraLance(trixie);

        assertEquals(400, leilao.getLances().get(2).getValor(), 0.00001);
    }

    @Test
    public void naoDeveProporNovoLance() {
        Leilao leilao = new Leilao("playstation 3");
        Usuario trixie = new Usuario("trixie");

        leilao.dobraLance(trixie);

        assertEquals(0, leilao.getLances().size());
    }

}
