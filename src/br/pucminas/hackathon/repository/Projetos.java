package br.pucminas.hackathon.repository;

import br.pucminas.hackathon.model.Projeto;
import java.util.ArrayList;
import java.util.List;

public class Projetos {
    private static Projetos instance;
    private List<Projeto> projetos;

    private Projetos() {
        this.projetos = new ArrayList<>();
    }

    public static Projetos getInstance() {
        if (instance == null) {
            instance = new Projetos();
        }
        return instance;
    }

    public void adicionar(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public List<Projeto> getProjetos() {
        return this.projetos;
    }
}