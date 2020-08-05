package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTeste {

    public static void main(String[] args) {
        Usuario trixie = new Usuario("Trixie");
        Usuario katya = new Usuario("Katya");
        Usuario jinkx = new Usuario("Jinkx");

        Leilao leilao = new Leilao("Playstation 3");

        leilao.propoe(new Lance(trixie, 250.0));
        leilao.propoe(new Lance(katya, 300.0));
        leilao.propoe(new Lance(jinkx, 440.0));

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        System.out.println(avaliador.getMaiorLance());
        System.out.println(avaliador.getMenorLance());
    }
}
