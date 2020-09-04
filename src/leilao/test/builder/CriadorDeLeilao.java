package leilao.test.builder;

import leilao.main.domain.Lance;
import leilao.main.domain.Leilao;
import leilao.main.domain.Usuario;

public class CriadorDeLeilao {
    private Leilao leilao;

    public CriadorDeLeilao() {
    }

    public CriadorDeLeilao para (String descricao) {
        this.leilao = new Leilao(descricao);
        return this;
    }

    public CriadorDeLeilao lance(Usuario usuario, double valor) {
        leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public Leilao constroi() {
        return leilao;
    }
}
