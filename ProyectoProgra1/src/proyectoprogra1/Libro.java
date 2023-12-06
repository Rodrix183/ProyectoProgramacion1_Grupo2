package proyectoprogra1;

public class Libro {

    private String titulo;
    private String ISBN;
    private String autores;
    private String categoria;

    public Libro() {
    }

    public Libro(String titulo, String ISBN, String autores, String categoria) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.autores = autores;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
