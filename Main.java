package Entidade;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Acesso do Restaurante ===");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.println("Selecione seu tipo de usu�rio:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Gar�om");
        System.out.print("Op��o: ");
        int tipo = scanner.nextInt();

        Usuario usuario;

        if (tipo == 1) {
            usuario = new Gerente(nome, email);
        } else if (tipo == 2) {
            usuario = new Garcom(nome, email);
        } else {
            System.out.println("Tipo inv�lido. Encerrando.");
            scanner.close();
            return;
        }

        System.out.println("\nBem-vindo, " + usuario.getNome());
        usuario.mostrarPermissoes();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nDigite o n�mero da a��o que deseja realizar (ou 0 para sair): ");
            int opcao = scanner.nextInt();

            if (usuario instanceof Gerente) {
                Gerente g = (Gerente) usuario;
                switch (opcao) {
                    case 1 -> g.cadastrarPrato();
                    case 2 -> g.verRelatorios();
                    case 3 -> g.gerenciarFuncionarios();
                    case 0 -> continuar = false;
                    default -> System.out.println("Op��o inv�lida.");
                }
            } else if (usuario instanceof Garcom) {
                Garcom g = (Garcom) usuario;
                switch (opcao) {
                    case 1 -> g.criarPedido();
                    case 2 -> g.atualizarStatusPedido();
                    case 3 -> g.visualizarMesas();
                    case 0 -> continuar = false;
                    default -> System.out.println("Op��o inv�lida.");
                }
            }
        }

        System.out.println("Encerrando o sistema. At� logo!");
        scanner.close();
    }


}
