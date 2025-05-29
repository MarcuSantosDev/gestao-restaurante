package main.src.service;

import main.src.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public Cliente cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(proximoId++, nome);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
        return cliente;
    }
    public Cliente atualizarCliente(int idAtualizar, String nome){
        Cliente cliente = new Cliente(proximoId++, nome);
        clientes.add(cliente);
        System.out.println("Cliente atualizado com sucesso.");
        return cliente;
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome());
        }
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    public void removerCliente(int id) {
        buscarPorId(id).ifPresentOrElse(
                cliente -> {
                    clientes.remove(cliente);
                    System.out.println("Cliente removido com sucesso.");
                },
                () -> System.out.println("Cliente não encontrado.")
        );
    }
}
