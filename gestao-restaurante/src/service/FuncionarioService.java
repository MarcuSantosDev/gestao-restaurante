package main.src.service;

import main.src.models.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private int proximoId = 1;

    public Funcionario contratarFuncionario(String nome, String cargo) {
        Funcionario funcionario = new Funcionario(proximoId++, nome, cargo);
        funcionarios.add(funcionario);
        System.out.println("Funcionário contratado com sucesso.");
        return funcionario;
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (Funcionario f : funcionarios) {
            System.out.println("ID: " + f.id + " | Nome: " + f.getNome() + " | Cargo: " + f.cargo);
        }
    }

    public Optional<Funcionario> buscarPorId(int id) {
        return funcionarios.stream().filter(f -> f.id == id).findFirst();
    }

    public void demitirFuncionario(int id) {
        buscarPorId(id).ifPresentOrElse(
                funcionario -> {
                    funcionarios.remove(funcionario);
                    System.out.println("Funcionário demitido com sucesso.");
                },
                () -> System.out.println("Funcionário não encontrado.")
        );
    }
}