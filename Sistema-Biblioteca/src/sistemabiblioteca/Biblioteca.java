package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private String id;
    private String nome;
    private String endereco;
    private String telefone;
    private String horarioFuncionamento;
    private final List<Exemplar> exemplares = new ArrayList<>();
    private final List<Livro> acervo = new ArrayList<>();

    public Biblioteca(String id, String nome, String endereco, String telefone, String horarioFuncionamento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public void cadastrarExemplar(Exemplar exemplar) {
        if (exemplar != null && !exemplares.contains(exemplar)) {
            exemplares.add(exemplar);
            exemplar.setBiblioteca(this);
            Livro livro = exemplar.getLivro();
            if (livro != null && !acervo.contains(livro)) {
                acervo.add(livro);
            }
        }
    }

    public List<Livro> consultarAcervo() {
        return Collections.unmodifiableList(acervo);
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

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }
}
