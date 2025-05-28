package main.src.models;

public class Funcionario {
    public int id;
    public String nome;
    public String cargo;

    public Funcionario(int id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    public void atenderCliente(Cliente cliente) {
        System.out.println(cargo + " " + nome + " está atendendo o cliente " + cliente.getNome());
    }

    public String getNome() {
        return nome;
    }
}
