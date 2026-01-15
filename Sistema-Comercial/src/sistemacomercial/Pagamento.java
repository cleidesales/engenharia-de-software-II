package sistemacomercial;

import java.time.LocalDate;

public abstract class Pagamento {
    private String id;
    private double valor;
    private LocalDate dataPagamento;
    private String status;

    protected Pagamento(String id, double valor) {
        this.id = id;
        this.valor = valor;
        this.status = "PENDENTE";
    }

    public abstract boolean processar();

    public abstract boolean validar();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
