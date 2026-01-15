package sistemabiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private String id;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private String status;
    private Usuario usuario;
    private Exemplar exemplar;

    public Emprestimo(String id, LocalDate dataRetirada, LocalDate dataDevolucaoPrevista, String status, Usuario usuario, Exemplar exemplar) {
        this.id = id;
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.status = status;
        this.usuario = usuario;
        this.exemplar = exemplar;
    }

    public void renovar(int dias) {
        if (dataDevolucaoPrevista != null && "ATIVO".equalsIgnoreCase(status)) {
            this.dataDevolucaoPrevista = dataDevolucaoPrevista.plusDays(dias);
        }
    }

    public void devolver(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.status = "DEVOLVIDO";
        if (exemplar != null) {
            exemplar.devolver();
        }
    }

    public double calcularMulta(double valorPorDia) {
        if (dataDevolucaoReal == null || dataDevolucaoPrevista == null) {
            return 0.0;
        }
        long diasAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoReal);
        return diasAtraso > 0 ? diasAtraso * valorPorDia : 0.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
}
