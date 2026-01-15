package sistemacomercial;

import java.time.LocalDate;

public class PagamentoBoleto extends Pagamento {
    private String codigoBarras;
    private LocalDate dataVencimento;
    private String linhaDigitavel;

    public PagamentoBoleto(String id, double valor, String codigoBarras, LocalDate dataVencimento, String linhaDigitavel) {
        super(id, valor);
        this.codigoBarras = codigoBarras;
        this.dataVencimento = dataVencimento;
        this.linhaDigitavel = linhaDigitavel;
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
        return codigoBarras != null && !codigoBarras.isBlank() && linhaDigitavel != null && !linhaDigitavel.isBlank()
                && dataVencimento != null;
    }

    public String gerarBoleto() {
        return "BOLETO-" + codigoBarras;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }
}
