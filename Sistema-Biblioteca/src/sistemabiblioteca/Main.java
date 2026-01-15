package sistemabiblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("A1", "Machado de Assis", "BR", LocalDate.of(1839, 6, 21), "Autor brasileiro.");
        Editora editora = new Editora("E1", "Editora Central", "00.000.000/0001-00", "Rua A, 123", "1111-1111");
        Livro livro = new Livro("9780000000001", "Dom Casmurro", "Romance", 1899, 256);
        Biblioteca biblioteca = new Biblioteca("B1", "Biblioteca Central", "Rua B, 456", "2222-2222", "08:00-18:00");

        autor.publicarLivro(livro);
        editora.publicarLivro(livro);

        Exemplar exemplar = new Exemplar("EX1", "Estante 1", "Novo", true);
        livro.adicionarExemplar(exemplar);
        biblioteca.cadastrarExemplar(exemplar);

        Usuario usuario = new Usuario("U1", "Ana", "ana@email.com", "MAT123", "9999-9999", "ALUNO");

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                System.out.println("\n=== Sistema Biblioteca ===");
                System.out.println("1 - Reservar livro");
                System.out.println("2 - Consultar reservas");
                System.out.println("3 - Realizar emprestimo");
                System.out.println("4 - Consultar emprestimos");
                System.out.println("5 - Consultar disponibilidade");
                System.out.println("0 - Sair");
                System.out.print("Opcao: ");
                opcao = lerInteiro(scanner);

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Dias para expirar a reserva: ");
                        int dias = lerInteiro(scanner);
                        Reserva reserva = usuario.reservarLivro(biblioteca, LocalDate.now().plusDays(dias));
                        System.out.println("Reserva criada. Status: " + reserva.getStatus());
                    }
                    case 2 -> {
                        if (usuario.consultarReservas().isEmpty()) {
                            System.out.println("Nenhuma reserva encontrada.");
                        } else {
                            usuario.consultarReservas().forEach(r -> System.out.println("Reserva " + r.getId() + " - " + r.getStatus()));
                        }
                    }
                    case 3 -> {
                        if (exemplar.emprestar()) {
                            Emprestimo emprestimo = new Emprestimo("EMP" + (usuario.consultarEmprestimos().size() + 1),
                                    LocalDate.now(), LocalDate.now().plusDays(14), "ATIVO", usuario, exemplar);
                            usuario.adicionarEmprestimo(emprestimo);
                            System.out.println("Emprestimo realizado.");
                        } else {
                            System.out.println("Exemplar indisponivel.");
                        }
                    }
                    case 4 -> {
                        if (usuario.consultarEmprestimos().isEmpty()) {
                            System.out.println("Nenhum emprestimo encontrado.");
                        } else {
                            usuario.consultarEmprestimos().forEach(e -> System.out.println("Emprestimo " + e.getId() + " - " + e.getStatus()));
                        }
                    }
                    case 5 -> System.out.println("Livro disponivel: " + livro.consultarDisponibilidade());
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
