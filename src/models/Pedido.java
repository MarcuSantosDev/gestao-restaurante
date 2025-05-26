package main.src.models;

public class Pedido {
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public Pedido(String descricao, int quantidade, double precoUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double calcularTotal() {
        return quantidade * precoUnitario;
    }

    @Override
    public String toString() {
        return quantidade + "x " + descricao + " - R$ " + String.format("%.2f", calcularTotal());
    }
}
