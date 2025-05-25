package service;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public void adicionarCliente(String nome, String telefone) {
        Cliente cliente = new Cliente(proximoId++, nome, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void atualizarCliente(int id, String novoNome, String novoTelefone) {
        Optional<Cliente> clienteOpt = buscarPorId(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setNome(novoNome);
            cliente.setTelefone(novoTelefone);
            System.out.println("Cliente atualizado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void removerCliente(int id) {
        Optional<Cliente> clienteOpt = buscarPorId(id);
        if (clienteOpt.isPresent()) {
            clientes.remove(clienteOpt.get());
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }
}
