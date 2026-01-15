package sistemabiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String matricula;
    private String telefone;
    private String tipo;
    private final List<Reserva> reservas = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String id, String nome, String email, String matricula, String telefone, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public Reserva reservarLivro(Biblioteca biblioteca, LocalDate dataExpiracao) {
        Reserva reserva = new Reserva(UUID.randomUUID().toString(), LocalDate.now(), dataExpiracao, "PENDENTE", this, biblioteca);
        this.reservas.add(reserva);
        return reserva;
    }

    public List<Emprestimo> consultarEmprestimos() {
        return Collections.unmodifiableList(emprestimos);
    }

    public List<Reserva> consultarReservas() {
        return Collections.unmodifiableList(reservas);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo != null) {
            this.emprestimos.add(emprestimo);
        }
    }

    public void adicionarReserva(Reserva reserva) {
        if (reserva != null) {
            this.reservas.add(reserva);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
