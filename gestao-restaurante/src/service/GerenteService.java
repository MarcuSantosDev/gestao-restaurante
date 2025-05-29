package main.src.service;

import main.src.models.Gerente;
import main.src.models.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenteService {
    private List<Gerente> gerentes = new ArrayList<>();
    private int proximoId = 1;

    public Gerente cadastrarGerente(String nome) {
        Gerente gerente = new Gerente(proximoId++, nome);
        gerentes.add(gerente);
        System.out.println("Gerente cadastrado com sucesso.");
        return gerente;
    }

    public void listarGerentes() {
        if (gerentes.isEmpty()) {
            System.out.println("Nenhum gerente cadastrado.");
            return;
        }
        for (Gerente g : gerentes) {
            System.out.println("ID: " + g.id + " | Nome: " + g.getNome());
        }
    }

    public Optional<Gerente> buscarPorId(int id) {
        return gerentes.stream().filter(g -> g.id == id).findFirst();
    }

    public void demitirFuncionario(Gerente gerente, Funcionario funcionario) {
        gerente.demitirFuncionario(funcionario);
    }

}