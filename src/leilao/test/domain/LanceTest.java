package leilao.test.domain;

import leilao.main.domain.Lance;
import leilao.main.domain.Usuario;
import org.junit.Before;
import org.junit.Test;

public class LanceTest {

    private Usuario trixie;

    @Before
    public void setup() {
        this.trixie = new Usuario("trixie");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveJogarExcecaoComLanceDeValorIgualAZero() {
        Lance lance = new Lance(trixie, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveJogarExcecaoComLanceDeValorNegativo() {
        Lance lance = new Lance(trixie, -234);
    }
}
