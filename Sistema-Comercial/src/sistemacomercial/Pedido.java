package sistemacomercial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private String id;
    private LocalDate dataPedido;
    private String status;
    private double valorTotal;
    private final List<ItemPedido> itens = new ArrayList<>();
    private Pagamento pagamento;
    private Cliente cliente;

    public Pedido(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = LocalDate.now();
        this.status = "ABERTO";
        this.valorTotal = 0.0;
    }

    public void adicionarItem(ItemPedido item) {
        if (item != null) {
            itens.add(item);
            calcularTotal();
        }
    }

    public void removerItem(ItemPedido item) {
        if (item != null && itens.remove(item)) {
            calcularTotal();
        }
    }

    public double calcularTotal() {
        this.valorTotal = itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
        return valorTotal;
    }

    public boolean realizarPagamento(Pagamento pagamento) {
        if (pagamento == null) {
            return false;
        }
        this.pagamento = pagamento;
        boolean aprovado = pagamento.processar();
        this.status = aprovado ? "PAGO" : "PENDENTE";
        return aprovado;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
