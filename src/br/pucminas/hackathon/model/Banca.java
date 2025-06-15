package br.pucminas.hackathon.model;

import java.util.HashMap;
import java.util.Map;

public class Banca implements Avaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados;

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
        this.jurados = new HashMap<>();
    }

    public void adicionarJurado(Jurado jurado, int nota) {
        if (this.jurados.size() < 4) { // Limite de 4 jurados
            this.jurados.put(jurado, nota);
        }
    }

    @Override
    public void calcularNotaFinal() {
        if (jurados.isEmpty()) {
            projetoAvaliado.setNotaFinal(0);
            return;
        }
        double soma = 0;
        for (Integer nota : jurados.values()) {
            soma += nota;
        }
        projetoAvaliado.setNotaFinal(soma / jurados.size());
    }
}