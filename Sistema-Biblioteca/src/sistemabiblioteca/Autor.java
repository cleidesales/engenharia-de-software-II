package sistemabiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Autor {
    private String id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;
    private String biografia;
    private final List<Livro> obras = new ArrayList<>();

    public Autor(String id, String nome, String nacionalidade, LocalDate dataNascimento, String biografia) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.biografia = biografia;
    }

    public void publicarLivro(Livro livro) {
        if (livro != null && !obras.contains(livro)) {
            obras.add(livro);
            livro.adicionarAutor(this);
        }
    }

    public List<Livro> consultarObras() {
        return Collections.unmodifiableList(obras);
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
