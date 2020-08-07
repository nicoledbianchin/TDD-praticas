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

    public double calculaMedia(List<Double> valores) {
        double soma = 0;
        int quantidade = 0;
        for (double valor : valores) {
            soma = soma + valor;
            quantidade++;
        }
        media = soma / quantidade;
        return media;
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
