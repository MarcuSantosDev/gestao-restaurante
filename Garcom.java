package Entidade;


public class Garcom extends Usuario{
	public Garcom(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void mostrarPermissoes() {
        System.out.println("Permissões de Garçom:");
        System.out.println("1 - Criar pedido");
        System.out.println("2 - Atualizar status do pedido");
        System.out.println("3 - Visualizar mesas");
    }

    public void criarPedido() {
        System.out.println("Pedido criado com sucesso!");
    }

    public void atualizarStatusPedido() {
        System.out.println("Status do pedido atualizado para 'Entregue'.");
    }

    public void visualizarMesas() {
        System.out.println("Exibindo lista de mesas ativas...");
    }

}
