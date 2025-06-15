package br.pucminas.hackathon.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private List<Estudante> membros;

    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Estudante estudante) {
        if (this.membros.size() < 5) { // Limite de 5 alunos por equipe
            this.membros.add(estudante);
        }
    }
    
    public String getNome(){
        return this.nome;
    }
}