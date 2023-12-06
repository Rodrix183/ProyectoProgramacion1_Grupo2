package proyectoprogra1;

import java.util.ArrayList;

public class Libro {

    private String titulo;
    private String ISBN;
    private ArrayList <String> autores;
    private String categoria;

    public Libro() {
    }

    public Libro(String titulo, String ISBN, ArrayList <String> autores, String categoria) {
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

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
