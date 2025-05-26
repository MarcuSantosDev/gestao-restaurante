package main.src.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private List<Pedido> comanda = new ArrayList<>();

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getComanda() {
        return comanda;
    }
    public void setComanda(List<Pedido> comanda) {
        this.comanda = comanda;
    }
    public void adicionarPedido(Pedido pedido) {
        this.comanda.add(pedido);
    }
    public void removerPedido(Pedido pedido) {
        this.comanda.remove(pedido);
    }
    public double calcularTotalComanda() {
        return comanda.stream()
                      .mapToDouble(Pedido::calcularTotal)
                      .sum();
    }
    public void exibirComanda() {
        if (comanda.isEmpty()) {
            System.out.println("Nenhum pedido na comanda.");
            return;
        }
        System.out.println("Comanda do cliente " + nome + ":");
        for (Pedido pedido : comanda) {
            System.out.println(pedido);
        }
        System.out.printf("Total da comanda: R$ %.2f%n", calcularTotalComanda());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
