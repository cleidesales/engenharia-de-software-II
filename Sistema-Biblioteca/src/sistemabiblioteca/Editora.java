package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Editora {
    private String id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private final List<Livro> catalogo = new ArrayList<>();

    public Editora(String id, String nome, String cnpj, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void publicarLivro(Livro livro) {
        if (livro != null && !catalogo.contains(livro)) {
            catalogo.add(livro);
            livro.setEditora(this);
        }
    }

    public List<Livro> consultarCatalogo() {
        return Collections.unmodifiableList(catalogo);
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
