package view;

import entidade.Cliente;
import entidade.Funcionario;
import entidade.Pedido;
import entidade.Produto;
import repositorio.ClienteRepositorio;
import repositorio.FuncionarioRepositorio;
import repositorio.PedidoRepositorio;
import repositorio.ProdutoRepositorio;
import servico.ClienteServico;
import servico.FuncionarioServico;
import servico.PedidoServico;
import servico.ProdutoServico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instâncias dos repositórios e serviços
        ClienteServico clienteServico = new ClienteServico(new ClienteRepositorio());
        FuncionarioServico funcionarioServico = new FuncionarioServico(new FuncionarioRepositorio());
        ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
        PedidoServico pedidoServico = new PedidoServico(new PedidoRepositorio());

        boolean executando = true;

        while (executando) {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Funcionários");
            System.out.println("3 - Gerenciar Produtos");
            System.out.println("4 - Gerenciar Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> menuCliente(scanner, clienteServico);
                case 2 -> menuFuncionario(scanner, funcionarioServico);
                case 3 -> menuProduto(scanner, produtoServico);
                case 4 -> menuPedido(scanner, pedidoServico);
                case 0 -> {
                    executando = false;
                    System.out.println("Encerrando o programa...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // Menu Cliente
    private static void menuCliente(Scanner scanner, ClienteServico clienteServico) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n== MENU CLIENTE ==");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    clienteServico.cadastrar(new Cliente(nome, cpf, endereco));
                    System.out.println("Cliente cadastrado.");
                }
                case 2 -> {
                    System.out.println("== Lista de Clientes ==");
                    clienteServico.buscarTodos().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo endereço: ");
                    String endereco = scanner.nextLine();
                    clienteServico.atualizar(new Cliente(nome, cpf, endereco));
                    System.out.println("Cliente atualizado.");
                }
                case 4 -> {
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    clienteServico.excluir(cpf);
                    System.out.println("Cliente removido.");
                }
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // Menu Funcionario
    private static void menuFuncionario(Scanner scanner, FuncionarioServico funcionarioServico) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n== MENU FUNCIONÁRIO ==");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    funcionarioServico.cadastrar(new Funcionario(nome, cpf, cargo));
                    System.out.println("Funcionário cadastrado.");
                }
                case 2 -> {
                    System.out.println("== Lista de Funcionários ==");
                    funcionarioServico.buscarTodos().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("CPF do funcionário: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo cargo: ");
                    String cargo = scanner.nextLine();
                    funcionarioServico.atualizar(new Funcionario(nome, cpf, cargo));
                    System.out.println("Funcionário atualizado.");
                }
                case 4 -> {
                    System.out.print("CPF do funcionário: ");
                    String cpf = scanner.nextLine();
                    funcionarioServico.excluir(cpf);
                    System.out.println("Funcionário removido.");
                }
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // Menu Produto
    private static void menuProduto(Scanner scanner, ProdutoServico produtoServico) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n== MENU PRODUTO ==");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    produtoServico.cadastrar(new Produto(codigo, nome, preco));
                    System.out.println("Produto cadastrado.");
                }
                case 2 -> {
                    System.out.println("== Lista de Produtos ==");
                    produtoServico.buscarTodos().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Código do produto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo preço: ");
                    double preco = scanner.nextDouble();
                    produtoServico.atualizar(new Produto(codigo, nome, preco));
                    System.out.println("Produto atualizado.");
                }
                case 4 -> {
                    System.out.print("Código do produto: ");
                    String codigo = scanner.nextLine();
                    produtoServico.excluir(codigo);
                    System.out.println("Produto removido.");
                }
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // Menu Pedido
    private static void menuPedido(Scanner scanner, PedidoServico pedidoServico) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n== MENU PEDIDO ==");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Valor Total: ");
                    double valor = scanner.nextDouble();
                    pedidoServico.cadastrar(new Pedido(codigo, descricao, valor));
                    System.out.println("Pedido cadastrado.");
                }
                case 2 -> {
                    System.out.println("== Lista de Pedidos ==");
                    pedidoServico.buscarTodos().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Código do pedido: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Novo valor total: ");
                    double valor = scanner.nextDouble();
                    pedidoServico.atualizar(new Pedido(codigo, descricao, valor));
                    System.out.println("Pedido atualizado.");
                }
                case 4 -> {
                    System.out.print("Código do pedido: ");
                    String codigo = scanner.nextLine();
                    pedidoServico.excluir(codigo);
                    System.out.println("Pedido removido.");
                }
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
