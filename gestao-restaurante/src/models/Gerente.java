package main.src.models;

public class Gerente extends Funcionario {

    public Gerente(int id, String nome) {
        super(id, nome, "Gerente");
    }

    public void fecharComanda(Cliente cliente) {
        System.out.println("Fechando comanda para o cliente: " + cliente.getNome());
        cliente.exibirComanda();
    }

    public void demitirFuncionario(Funcionario funcionario) {
        System.out.println("Gerente " + nome + " demitiu o funcionário " + funcionario.getNome());
    }
}
