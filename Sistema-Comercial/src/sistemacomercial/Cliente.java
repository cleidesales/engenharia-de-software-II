package sistemacomercial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Cliente {
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private final List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String id, String nome, String email, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Pedido realizarPedido() {
        Pedido pedido = new Pedido(UUID.randomUUID().toString(), this);
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> consultarPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido != null && !pedidos.contains(pedido)) {
            pedidos.add(pedido);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
