package br.pucminas.hackathon.repository;

import br.pucminas.hackathon.model.Equipe;
import java.util.ArrayList;
import java.util.List;

public class Equipes {
    private static Equipes instance;
    private List<Equipe> equipes;

    private Equipes() {
        this.equipes = new ArrayList<>();
    }

    public static Equipes getInstance() {
        if (instance == null) {
            instance = new Equipes();
        }
        return instance;
    }

    public void adicionar(Equipe equipe) {
        this.equipes.add(equipe);
    }

    public List<Equipe> getEquipes() {
        return this.equipes;
    }
}