package Entidade;


public class Gerente extends Usuario{
	 public Gerente(String nome, String email) {
	        super(nome, email);
	    }

	    @Override
	    public void mostrarPermissoes() {
	        System.out.println("Permissões de Gerente:");
	        System.out.println("1 - Cadastrar prato");
	        System.out.println("2 - Ver relatórios");
	        System.out.println("3 - Gerenciar funcionários");
	    }

	    public void cadastrarPrato() {
	        System.out.println("Prato cadastrado com sucesso!");
	    }

	    public void verRelatorios() {
	        System.out.println("Exibindo relatórios de vendas e desempenho...");
	    }

	    public void gerenciarFuncionarios() {
	        System.out.println("Acessando sistema de gerenciamento de funcionários...");
	    }
	

}
