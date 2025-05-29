package main.src.service;


import main.src.models.Cliente;
import main.src.models.Pedido;

public class PedidoService {

    public void adicionarPedidoAoCliente(Cliente cliente, String descricao, int quantidade, double precoUnitario) {
        Pedido pedido = new Pedido(descricao, quantidade, precoUnitario);
        cliente.adicionarPedido(pedido);
        System.out.println("Pedido adicionado à comanda do cliente: " + cliente.getNome());
    }

    public void exibirComanda(Cliente cliente) {
        cliente.exibirComanda();
    }

    public double calcularTotal(Cliente cliente) {
        return cliente.calcularTotalComanda();
    }
}