package sistemacomercial;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("C1", "Joao", "joao@email.com", "000.000.000-00", "8888-8888");
        Produto produto = new Produto("P1", "Mouse", "Mouse sem fio", 120.0, 10, "Informatica");

        Pedido pedido = cliente.realizarPedido();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                System.out.println("\n=== Sistema Comercial ===");
                System.out.println("1 - Adicionar item");
                System.out.println("2 - Remover item");
                System.out.println("3 - Ver total");
                System.out.println("4 - Realizar pagamento");
                System.out.println("0 - Sair");
                System.out.print("Opcao: ");
                opcao = lerInteiro(scanner);

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Quantidade: ");
                        int quantidade = lerInteiro(scanner);
                        if (produto.consultarDisponibilidade(quantidade)) {
                            ItemPedido item = new ItemPedido(produto, quantidade, produto.getPreco());
                            pedido.adicionarItem(item);
                            produto.atualizarEstoque(-quantidade);
                            System.out.println("Item adicionado.");
                        } else {
                            System.out.println("Estoque insuficiente.");
                        }
                    }
                    case 2 -> {
                        if (pedido.getItens().isEmpty()) {
                            System.out.println("Nenhum item para remover.");
                        } else {
                            ItemPedido item = pedido.getItens().get(0);
                            pedido.removerItem(item);
                            produto.atualizarEstoque(item.getQuantidade());
                            System.out.println("Item removido.");
                        }
                    }
                    case 3 -> System.out.println("Total do pedido: " + pedido.getValorTotal());
                    case 4 -> {
                        Pagamento pagamento = new PagamentoPix("PG1", pedido.getValorTotal(), "chave-pix-001",
                                LocalDate.now().plusDays(1));
                        boolean aprovado = pedido.realizarPagamento(pagamento);
                        System.out.println("Pagamento aprovado: " + aprovado);
                        System.out.println("Status do pedido: " + pedido.getStatus());
                    }
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opcao invalida.");
                }
            } while (opcao != 0);
        }
    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um numero inteiro: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
}
