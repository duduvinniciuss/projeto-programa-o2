package view;

import entidade.Pedido;
import interfaces.servico.PedidoServico;
import servico.PedidoServicoImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static PedidoServico servico = new PedidoServicoImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n==== MENU PEDIDO ====");
            System.out.println("1 - Cadastrar Pedido");
            System.out.println("2 - Listar Pedidos");
            System.out.println("3 - Atualizar Pedido");
            System.out.println("4 - Remover Pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> remover();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void cadastrar() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = Double.parseDouble(scanner.nextLine());

        Pedido pedido = new Pedido(codigo, descricao, valor);
        servico.cadastrar(pedido);
    }

    private static void listar() {
        List<Pedido> pedidos = servico.listar();
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado.");
        } else {
            pedidos.forEach(System.out::println);
        }
    }

    private static void atualizar() {
        System.out.print("Código do pedido a atualizar: ");
        String codigo = scanner.nextLine();
        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Novo valor: ");
        double valor = Double.parseDouble(scanner.nextLine());

        Pedido pedido = new Pedido(codigo, descricao, valor);
        servico.atualizar(pedido);
    }

    private static void remover() {
        System.out.print("Código do pedido a remover: ");
        String codigo = scanner.nextLine();
        servico.remover(codigo);
    }
}
