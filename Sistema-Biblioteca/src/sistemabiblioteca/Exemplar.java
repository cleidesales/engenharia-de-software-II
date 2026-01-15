package sistemabiblioteca;

public class Exemplar {
    private String codigo;
    private String localizacao;
    private String estado;
    private boolean disponivel;
    private Livro livro;
    private Biblioteca biblioteca;

    public Exemplar(String codigo, String localizacao, String estado, boolean disponivel) {
        this.codigo = codigo;
        this.localizacao = localizacao;
        this.estado = estado;
        this.disponivel = disponivel;
    }

    public boolean emprestar() {
        if (!disponivel) {
            return false;
        }
        this.disponivel = false;
        return true;
    }

    public void devolver() {
        this.disponivel = true;
    }

    public boolean verificarDisponibilidade() {
        return disponivel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
