package leilao.main.service;

import leilao.main.domain.Leilao;
import leilao.main.domain.Lance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double media = 0;
    private List<Lance> maiores;

    public void avalia(Leilao leilao) {
        for(Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
            if (lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
        }

        pegaOsMaiores(leilao);
    }

    private void pegaOsMaiores(Leilao leilao) {
        maiores = new ArrayList<Lance>(leilao.getLances());
        maiores.sort(new Comparator<Lance>() {
            @Override
            public int compare(Lance o1, Lance o2) {
                if (o1.getValor() < o2.getValor()) return 1;
                if (o1.getValor() > o2.getValor()) return -1;
                return 0;
            }
        });
        maiores = maiores.subList(0, Math.min(maiores.size(), 3));

    }

    public void calculaMedia(List<Lance> lances) {
        double soma = 0;
        if (lances.size() == 0) {
            media = 0;
        } else {
            for (Lance lance : lances) {
                double valor = lance.getValor();
                soma = soma + valor;
            }
            media = soma / lances.size();
        }
    }

    public List<Lance> getTresMaiores() {
        return this.maiores;
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }

    public double getMedia() {
        return media;
    }
}
