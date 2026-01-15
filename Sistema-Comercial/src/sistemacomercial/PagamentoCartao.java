package sistemacomercial;

import java.time.LocalDate;

public class PagamentoCartao extends Pagamento {
    private String numeroCartao;
    private String bandeira;
    private String cvv;
    private LocalDate dataValidade;

    public PagamentoCartao(String id, double valor, String numeroCartao, String bandeira, String cvv, LocalDate dataValidade) {
        super(id, valor);
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.cvv = cvv;
        this.dataValidade = dataValidade;
    }

    @Override
    public boolean processar() {
        if (!validar()) {
            setStatus("NEGADO");
            return false;
        }
        setStatus("APROVADO");
        setDataPagamento(LocalDate.now());
        return true;
    }

    @Override
    public boolean validar() {
        return numeroCartao != null && !numeroCartao.isBlank() && cvv != null && cvv.length() >= 3 && dataValidade != null;
    }

    public boolean verificarLimite(double limiteDisponivel) {
        return limiteDisponivel >= getValor();
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
