package sistemabiblioteca;

import java.time.LocalDate;

public class Reserva {
    private String id;
    private LocalDate dataSolicitacao;
    private LocalDate dataExpiracao;
    private String status;
    private Usuario usuario;
    private Biblioteca biblioteca;

    public Reserva(String id, LocalDate dataSolicitacao, LocalDate dataExpiracao, String status, Usuario usuario, Biblioteca biblioteca) {
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
        this.dataExpiracao = dataExpiracao;
        this.status = status;
        this.usuario = usuario;
        this.biblioteca = biblioteca;
    }

    public void confirmar() {
        this.status = "CONFIRMADA";
    }

    public void cancelar() {
        this.status = "CANCELADA";
    }

    public boolean verificarExpiracao() {
        if (dataExpiracao != null && LocalDate.now().isAfter(dataExpiracao)) {
            this.status = "EXPIRADA";
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
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

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
