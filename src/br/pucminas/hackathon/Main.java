package br.pucminas.hackathon;

import br.pucminas.hackathon.model.*;
import br.pucminas.hackathon.repository.Equipes;
import br.pucminas.hackathon.repository.Projetos;

public class Main {

    public static void main(String[] args) {
        // --- Instanciando Instituições ---
        Universidade puc = new Universidade("PUC Minas");
        Empresa google = new Empresa("Google");
        Empresa oracle = new Empresa("Oracle");

        // --- Obtendo instâncias dos repositórios Singleton ---
        Equipes repositorioEquipes = Equipes.getInstance();
        Projetos repositorioProjetos = Projetos.getInstance();

        // --- Cria 2 equipes com 5 alunos cada --- 
        System.out.println("Criando equipes...");
        for (int i = 1; i <= 2; i++) {
            Equipe equipe = new Equipe("Equipe " + i);
            for (int j = 1; j <= 5; j++) {
                equipe.adicionarMembro(new Estudante("Aluno " + j + " da Eq" + i, puc));
            }
            repositorioEquipes.adicionar(equipe);
        }
        System.out.println("Equipes criadas com sucesso!");

        // --- Adiciona um projeto diferente para cada equipe --- 
        System.out.println("\nCriando projetos...");
        Profissional orientador1 = new Profissional("Prof. Daniel", puc);
        Profissional orientador2 = new Profissional("Prof. Salles", puc);

        Projeto projeto1 = new Projeto("Sistema de Gestão", orientador1, repositorioEquipes.getEquipes().get(0));
        Projeto projeto2 = new Projeto("App de Mobilidade", orientador2, repositorioEquipes.getEquipes().get(1));

        repositorioProjetos.adicionar(projeto1);
        repositorioProjetos.adicionar(projeto2);
        System.out.println("Projetos criados e associados às equipes!");


        // --- Criar uma banca avaliadora para cada projeto (4 jurados cada) e calcular nota --- 
        System.out.println("\nAvaliando projetos...");
        
        // Banca para o Projeto 1
        Banca banca1 = new Banca(projeto1);
        banca1.adicionarJurado(new Jurado("Jurado A", google), 8);
        banca1.adicionarJurado(new Jurado("Jurado B", oracle), 7);
        banca1.adicionarJurado(new Jurado("Jurado C", google), 9);
        banca1.adicionarJurado(new Jurado("Jurado D", puc), 8);
        banca1.calcularNotaFinal(); // Média: (8+7+9+8)/4 = 8.0

        // Banca para o Projeto 2
        Banca banca2 = new Banca(projeto2);
        banca2.adicionarJurado(new Jurado("Jurado E", oracle), 6);
        banca2.adicionarJurado(new Jurado("Jurado F", google), 5);
        banca2.adicionarJurado(new Jurado("Jurado G", puc), 7);
        banca2.adicionarJurado(new Jurado("Jurado H", oracle), 6);
        banca2.calcularNotaFinal(); // Média: (6+5+7+6)/4 = 6.0
        
        System.out.println("Avaliações concluídas!");

        // --- Lista os projetos com nota final >= 7 (usar stream) --- 
        System.out.println("\n--- Projetos Aprovados (Nota Final >= 7) ---");
        repositorioProjetos.getProjetos().stream()
                .filter(p -> p.getNotaFinal() >= 7)
                .forEach(System.out::println);
    }
}