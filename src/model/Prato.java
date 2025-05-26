package model;

public class Prato {
    private int id;
    private String nome;
    private double preco;
    private boolean disponivel;
    private Categoria categoria;

    public Prato(int id, String nome, double preco, boolean disponivel, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public boolean isDisponivel() { return disponivel; }
    public Categoria getCategoria() { return categoria; }

    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "Prato{id=" + id + ", nome='" + nome + "', preco=" + preco +
               ", disponivel=" + disponivel + ", categoria=" + categoria.getNome() + '}';
    }
}
