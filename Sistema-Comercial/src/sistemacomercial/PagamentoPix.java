package sistemacomercial;

import java.time.LocalDate;

public class PagamentoPix extends Pagamento {
    private String chavePix;
    private String qrCode;
    private LocalDate dataExpiracao;

    public PagamentoPix(String id, double valor, String chavePix, LocalDate dataExpiracao) {
        super(id, valor);
        this.chavePix = chavePix;
        this.dataExpiracao = dataExpiracao;
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
        return chavePix != null && !chavePix.isBlank() && dataExpiracao != null;
    }

    public String gerarQRCode() {
        this.qrCode = "QR-" + chavePix + "-" + getValor();
        return qrCode;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getQrCode() {
        return qrCode;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
