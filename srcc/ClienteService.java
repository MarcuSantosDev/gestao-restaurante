public void cadastrarCliente(String nome)
public void listarClientes()
public Optional<Cliente> buscarPorId(int id)

public void cadastrarCliente(String nome)
public void listarClientes()
public Optional<Cliente> buscarPorId(int id)

package main.src.service;

import main.src.models.Cliente;
import java.util.*;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    private int idCounter = 1;

    public void cadastrarCliente(String nome) {
        Cliente novo = new Cliente(idCounter++, nome);
        clientes.add(novo);
        System.out.println("Cliente cadastrado: " + novo.getNome());
    }

    public void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c.getId() + " - " + c.getNome());
        }
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }
}
