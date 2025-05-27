package view;

import entidade.Cliente;
import entidade.Funcionario;
import entidade.Produto;
import entidade.Pedido;
import servico.ClienteServico;
import servico.FuncionarioServico;
import servico.ProdutoServico;
import servico.PedidoServico;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteServico clienteServico = new ClienteServico();
        FuncionarioServico funcionarioServico = new FuncionarioServico();
        ProdutoServico produtoServico = new ProdutoServico();
        PedidoServico pedidoServico = new PedidoServico();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Produtos");
            System.out.println("4. Gerenciar Pedidos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> menuCliente(sc, clienteServico);
                case 2 -> menuFuncionario(sc, funcionarioServico);
                case 3 -> menuProduto(sc, produtoServico);
                case 4 -> menuPedido(sc, pedidoServico);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    // ==================== MENU CLIENTE ====================
    private static void menuCliente(Scanner sc, ClienteServico servico) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    Cliente cliente = new Cliente(nome, email, telefone);
                    servico.salvar(cliente);
                }
                case 2 -> {
                    List<Cliente> lista = servico.listar();
                    lista.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID do Cliente: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Cliente cliente = servico.buscarPorId(id);
                    if (cliente != null) {
                        System.out.print("Novo nome: ");
                        cliente.setNome(sc.nextLine());
                        System.out.print("Novo email: ");
                        cliente.setEmail(sc.nextLine());
                        System.out.print("Novo telefone: ");
                        cliente.setTelefone(sc.nextLine());
                        servico.atualizar(cliente);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do Cliente: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    servico.remover(id);
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    // ==================== MENU FUNCIONARIO ====================
    private static void menuFuncionario(Scanner sc, FuncionarioServico servico) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU FUNCIONÁRIO ===");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();
                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    Funcionario funcionario = new Funcionario(nome, cargo, salario);
                    servico.salvar(funcionario);
                }
                case 2 -> {
                    List<Funcionario> lista = servico.listar();
                    lista.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID do Funcionário: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Funcionario funcionario = servico.buscarPorId(id);
                    if (funcionario != null) {
                        System.out.print("Novo nome: ");
                        funcionario.setNome(sc.nextLine());
                        System.out.print("Novo cargo: ");
                        funcionario.setCargo(sc.nextLine());
                        System.out.print("Novo salário: ");
                        funcionario.setSalario(sc.nextDouble());
                        sc.nextLine();
                        servico.atualizar(funcionario);
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do Funcionário: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    servico.remover(id);
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    // ==================== MENU PRODUTO ====================
    private static void menuProduto(Scanner sc, ProdutoServico servico) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU PRODUTO ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Estoque: ");
                    int estoque = sc.nextInt();
                    sc.nextLine();

                    Produto produto = new Produto(nome, preco, estoque);
                    servico.salvar(produto);
                }
                case 2 -> {
                    List<Produto> lista = servico.listar();
                    lista.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID do Produto: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Produto produto = servico.buscarPorId(id);
                    if (produto != null) {
                        System.out.print("Novo nome: ");
                        produto.setNome(sc.nextLine());
                        System.out.print("Novo preço: ");
                        produto.setPreco(sc.nextDouble());
                        System.out.print("Novo estoque: ");
                        produto.setEstoque(sc.nextInt());
                        sc.nextLine();
                        servico.atualizar(produto);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do Produto: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    servico.remover(id);
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    // ==================== MENU PEDIDO ====================
    private static void menuPedido(Scanner sc, PedidoServico servico) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== MENU PEDIDO ===");
            System.out.println("1. Cadastrar Pedido");
            System.out.println("2. Listar Pedidos");
            System.out.println("3. Atualizar Pedido");
            System.out.println("4. Remover Pedido");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    System.out.print("Valor Total: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    Pedido pedido = new Pedido(descricao, valor);
                    servico.salvar(pedido);
                }
                case 2 -> {
                    List<Pedido> lista = servico.listar();
                    lista.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID do Pedido: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Pedido pedido = servico.buscarPorId(id);
                    if (pedido != null) {
                        System.out.print("Nova descrição: ");
                        pedido.setDescricao(sc.nextLine());
                        System.out.print("Novo valor total: ");
                        pedido.setValorTotal(sc.nextDouble());
                        sc.nextLine();
                        servico.atualizar(pedido);
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do Pedido: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    servico.remover(id);
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
