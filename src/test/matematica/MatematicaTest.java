package test.matematica;

import main.com.thoughtworks.matematica.Calculadora;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class MatematicaTest {

    @Test
    public void deveRetornarQuadruploComValorMaiorQueTrinta() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.conta(31);

        Assert.assertThat(resultado, is(equalTo(31*4)));
    }

    @Test
    public void deveRetornarTriploComValorMaiorQueDez() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.conta(11);

        Assert.assertThat(resultado, is(equalTo(11*3)));
    }

    @Test
    public void deveRetornarTriploComValorTrinta() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.conta(30);

        Assert.assertThat(resultado, is(equalTo(30*3)));
    }

    @Test
    public void deveRetornarDuploComValorMenorQueDez() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.conta(8);

        Assert.assertThat(resultado, is(equalTo(8*2)));
    }

    @Test
    public void deveRetornarDuploComValorDez() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.conta(10);

        Assert.assertThat(resultado, is(equalTo(10*2)));
    }
}
