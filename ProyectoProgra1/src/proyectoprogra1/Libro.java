package proyectoprogra1;

import java.util.ArrayList;

public class Libro {

    private String titulo;
    private String ISBN;
    private ArrayList <String> autores;
    private String categoria;
    private int num_paginas;
    private int año;
    private String editorial;
    private int num_edicion;
    private int num_estante;
    private int pos_estante;
    private int cantidad;

    public Libro() {
    }

    public Libro(String titulo, String ISBN, ArrayList<String> autores, String categoria, int num_paginas, int año, String editorial, int num_edicion, int num_estante, int pos_estante, int cantidad) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.autores = autores;
        this.categoria = categoria;
        this.num_paginas = num_paginas;
        this.año = año;
        this.editorial = editorial;
        this.num_edicion = num_edicion;
        this.num_estante = num_estante;
        this.pos_estante = pos_estante;
        this.cantidad = cantidad;
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

    public int getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNum_edicion() {
        return num_edicion;
    }

    public void setNum_edicion(int num_edicion) {
        this.num_edicion = num_edicion;
    }

    public int getNum_estante() {
        return num_estante;
    }

    public void setNum_estante(int num_estante) {
        this.num_estante = num_estante;
    }

    public int getPos_estante() {
        return pos_estante;
    }

    public void setPos_estante(int pos_estante) {
        this.pos_estante = pos_estante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
