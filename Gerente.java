package Entidade;


public class Gerente extends Usuario{
	 public Gerente(String nome, String email) {
	        super(nome, email);
	    }

	    @Override
	    public void mostrarPermissoes() {
	        System.out.println("Permiss�es de Gerente:");
	        System.out.println("1 - Cadastrar prato");
	        System.out.println("2 - Ver relat�rios");
	        System.out.println("3 - Gerenciar funcion�rios");
	    }

	    public void cadastrarPrato() {
	        System.out.println("Prato cadastrado com sucesso!");
	    }

	    public void verRelatorios() {
	        System.out.println("Exibindo relat�rios de vendas e desempenho...");
	    }

	    public void gerenciarFuncionarios() {
	        System.out.println("Acessando sistema de gerenciamento de funcion�rios...");
	    }
	

}
