package proyectoprogra1;

import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoProgra1 {

    public static Scanner lectura = new Scanner(System.in);

    public static ArrayList<String> listaAutores = new ArrayList<String>();
    public static ArrayList<Libro> listaLibros = new ArrayList<Libro>();
    
    public static void main(String[] args) {
        int res_menu = 0;
        do {
            try { //Validar que solo sean numeros y nada mas
                System.out.println("Cambio probando");
                System.out.println("====Menu====");
                System.out.println("1) Ingresar Nuevo Libro\n2) Buscar libro por código ISBN\n3) Buscar libro por título del libro\n4) Buscar libros por categoría temática deseada\n5) Eliminar libro por código ISBN"
                        + "\n6) Eliminar libro por categoría temática\n7) Imprimir la información de todos los libros\n8) Imprimir la información de los libros que tengan una categoría temática deseada\n9) Salir");
                System.out.println("============");

                res_menu = lectura.nextInt();
            } catch (Exception e) {
                System.out.println("Opción no valida, ingrese solo números");
            }
            switch (res_menu) {
                case 1: //Agregar libros
                    agregar();
                    break;
                case 2:
                    System.out.println("Trabajando en opción 2");
                    break;
                case 3:
                    System.out.println("Trabajando en opción 3");
                    break;
                case 4:
                    System.out.println("Trabajando en opción 4");
                    break;
                case 5:
                    System.out.println("Trabajando en opción 5");
                    break;
                case 6:
                    System.out.println("Trabajando en opción 6");
                    break;
                case 7: //Imprimir todos los libros
                    for (int i = 0; i < listaLibros.size(); i++) {
                        System.out.println("TITULO: " + listaLibros.get(i).getTitulo() + " ISBN:" + listaLibros.get(i).getISBN());
                    }
                    break;
                case 8:
                    System.out.println("Trabajando en opción 8");
                    break;
                default: //opcion de salida
                    System.out.println("Saliendo...");
                    res_menu = 9;                    
            }
        } while (res_menu != 9);
        
    }

    public static void agregar() {
        int salida = 1;
        
        //Objeto libro
        Libro libroTemporal = new Libro();
        String titulo, ISBN, categoria;
        
        //Titulo
        System.out.println("Ingrese el título del libro!");
        titulo = lectura.nextLine();
        lectura.nextLine();        
        libroTemporal.setTitulo(titulo);
        
        
        //ISBN
        System.out.println("Ingrese el ISBN!");
        ISBN = lectura.nextLine();
        libroTemporal.setISBN(ISBN);
        
        //Autor(es)
        String resAutor = "";
        while (salida != 0) {
            System.out.println("Ingrese autor(es)!");
            resAutor = lectura.nextLine();
            lectura.nextLine();
            listaAutores.add(resAutor);

            //Validar solo números
            try {
                System.out.println("Desea ingresar otro autor? (1 Para Sí || 0 Para No)");
                salida = lectura.nextInt();
                switch (salida) {
                    case 1:
                        break;
                    case 0:
                        salida = 0;
                        break;
                    default:
                        salida = 1;
                        System.out.println("Opción no válida");

                }
            } catch (Exception e) {
                System.out.println("Opción no válida");
            }
        } //Fin While
        libroTemporal.setAutores(listaAutores);
        
        //Categoría
        System.out.println("Ingrese la categoría del libro!");
        categoria = lectura.nextLine();
        lectura.nextLine();
        libroTemporal.setCategoria(categoria);
                        
        //Agregar el libro recien creado a la lista
        listaLibros.add(libroTemporal);
    }//FIN METODO AGREGAR LIBRO
}
