package main;

import service.ClienteService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Gestão de Clientes ---");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Atualizar cliente");
            System.out.println("4. Remover cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    clienteService.adicionarCliente(nome, telefone);
                    break;
                case 2:
                    clienteService.listarClientes();
                    break;
                case 3:
                    System.out.print("ID do cliente: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    clienteService.atualizarCliente(idAtualizar, novoNome, novoTelefone);
                    break;
                case 4:
                    System.out.print("ID do cliente: ");
                    int idRemover = scanner.nextInt();
                    clienteService.removerCliente(idRemover);
                    break;
                case 0:
                    System.out.println("Saindo da gestão de clientes.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
