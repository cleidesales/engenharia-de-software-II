package sistemabiblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Livro {
    private String isbn;
    private String titulo;
    private String genero;
    private int anoPublicacao;
    private int numeroPaginas;
    private Editora editora;
    private final List<Autor> autores = new ArrayList<>();
    private final List<Exemplar> exemplares = new ArrayList<>();

    public Livro(String isbn, String titulo, String genero, int anoPublicacao, int numeroPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
    }

    public boolean consultarDisponibilidade() {
        return exemplares.stream().anyMatch(Exemplar::isDisponivel);
    }

    public List<Exemplar> obterExemplares() {
        return Collections.unmodifiableList(exemplares);
    }

    public void adicionarExemplar(Exemplar exemplar) {
        if (exemplar != null && !exemplares.contains(exemplar)) {
            exemplares.add(exemplar);
            exemplar.setLivro(this);
        }
    }

    public void adicionarAutor(Autor autor) {
        if (autor != null && !autores.contains(autor)) {
            autores.add(autor);
        }
    }

    public List<Autor> getAutores() {
        return Collections.unmodifiableList(autores);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
