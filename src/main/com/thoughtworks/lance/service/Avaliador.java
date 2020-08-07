package main.com.thoughtworks.lance.service;

import main.com.thoughtworks.lance.domain.Leilao;
import main.com.thoughtworks.lance.domain.Lance;

import java.util.List;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double media = 0;

    public void avalia(Leilao leilao) {
        for(Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
            if (lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
        }
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
