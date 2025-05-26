package main.src;
import main.src.models.Cliente;
import main.src.models.Funcionario;
import main.src.models.Gerente;
import main.src.service.ClienteService;
import main.src.service.FuncionarioService;
import main.src.service.GerenteService;
import main.src.service.PedidoService;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instâncias de service
        ClienteService clienteService = new ClienteService();
        FuncionarioService funcionarioService = new FuncionarioService();
        GerenteService gerenteService = new GerenteService();
        PedidoService pedidoService = new PedidoService();

        boolean executando = true;

        while (executando) {
            System.out.println("\n====== MENU PRINCIPAL ======");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Adicionar pedido a cliente");
            System.out.println("4. Exibir comanda do cliente");
            System.out.println("5. Contratar funcionário");
            System.out.println("6. Listar funcionários");
            System.out.println("7. Cadastrar gerente");
            System.out.println("8. Fechar comanda (gerente)");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    clienteService.cadastrarCliente(nome);
                }
                case 2 -> clienteService.listarClientes();
                case 3 -> {
                    System.out.print("ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine();
                    Optional<Cliente> clienteOpt = clienteService.buscarPorId(idCliente);
                    if (clienteOpt.isPresent()) {
                        System.out.print("Descrição do pedido: ");
                        String desc = scanner.nextLine();
                        System.out.print("Quantidade: ");
                        int qtd = scanner.nextInt();
                        System.out.print("Preço unitário: ");
                        double preco = scanner.nextDouble();
                        pedidoService.adicionarPedidoAoCliente(clienteOpt.get(), desc, qtd, preco);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    clienteService.buscarPorId(idCliente)
                            .ifPresentOrElse(
                                    pedidoService::exibirComanda,
                                    () -> System.out.println("Cliente não encontrado.")
                            );
                }
                case 5 -> {
                    System.out.print("Nome do funcionário: ");
                    String nomeFunc = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    funcionarioService.contratarFuncionario(nomeFunc, cargo);
                }
                case 6 -> funcionarioService.listarFuncionarios();
                case 7 -> {
                    System.out.print("Nome do gerente: ");
                    String nomeGerente = scanner.nextLine();
                    gerenteService.cadastrarGerente(nomeGerente);
                }
                case 8 -> {
                    System.out.print("ID do gerente: ");
                    int idGerente = scanner.nextInt();
                    System.out.print("ID do cliente: ");
                    int idCliente = scanner.nextInt();

                    Optional<Gerente> gerenteOpt = gerenteService.buscarPorId(idGerente);
                    Optional<Cliente> clienteOpt = clienteService.buscarPorId(idCliente);

                    if (gerenteOpt.isPresent() && clienteOpt.isPresent()) {
                        gerenteOpt.get().fecharComanda(clienteOpt.get());
                    } else {
                        System.out.println("Gerente ou cliente não encontrado.");
                    }
                }
                case 9 -> {
                    System.out.println("Encerrando o sistema...");
                    executando = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
