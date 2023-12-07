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
                    System.out.println("buscas un libro por ISBN?");
                    System.out.println("Ingrese el código ISBN:");
                    String isbnBusqueda = lectura.next();
                    Libro libroEncontrado = buscarPorISBN(isbnBusqueda);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println("Título: " + libroEncontrado.getTitulo());
                    } else {
                        System.out.println("No se encontró un libro con ese ISBN.VERIFIQUE y pruebe de nuevo");
                    }
                    break;
                case 3:
                    System.out.println("buscas un libro por titulo?");
                    System.out.println("Ingrese el título del libro:");
                    String tituloBusqueda = lectura.nextLine();
                    tituloBusqueda = lectura.nextLine();
                    int bandera = 1, confirmacion = 0;
                    ArrayList<Libro> librosEncontradosPorTitulo = buscarPorTitulo(tituloBusqueda);

                    //RESULTADOS
                    String resultados="";
                    for (int i = 0; i < librosEncontradosPorTitulo.size(); i++) {
                        if (!librosEncontradosPorTitulo.get(i).getTitulo().equals(tituloBusqueda)) {
                            bandera = 0;
                        } else {                            
                            resultados += "Título: " + librosEncontradosPorTitulo.get(i).getTitulo() 
                                    + " ISBN: " + librosEncontradosPorTitulo.get(i).getISBN()
                                    + " Categoría: " + librosEncontradosPorTitulo.get(i).getCategoria()
                                    + "\n";
                            confirmacion = 1;
                        }

                    }
                    
                    if (confirmacion == 1) {
                        System.out.println(resultados);
                    }else if(bandera == 0){
                        System.out.println("No hay libros registrados!");
                    }

//                    if (librosEncontradosPorTitulo.isEmpty()) {
//                        System.out.println("Libros encontrados con ese título:");
//                        for (Libro libro : librosEncontradosPorTitulo) {
//                            System.out.println("Título: " + libro.getTitulo());
//                        }
//                    } else {
//                        System.out.println("No se encontraron libros con ese título. Pruebe de nuevo");
//                    }
                    break;
                case 4:
                    System.out.println("Quiere buscar un libro por categoria??");
                    System.out.println("Ingrese la categoría del libro:");
                    String categoriaBusqueda = lectura.nextLine();
                    categoriaBusqueda = lectura.nextLine();
                    ArrayList<Libro> librosEncontradosPorCategoria = buscarPorCategoria(categoriaBusqueda);
                    if (!librosEncontradosPorCategoria.isEmpty()) {
                        System.out.println("Libros encontrados en esa categoría:");
                        for (Libro libro : librosEncontradosPorCategoria) {
                            System.out.println("Título: " + libro.getTitulo());
                        }
                    } else {
                        System.out.println("No se encontraron libros en esa categoría.");
                    }
                    break;

                case 5:
                    System.out.println("Trabajando en opción 5");
                    break;
                case 6:
                    System.out.println("Trabajando en opción 6");
                    break;
                case 7: //Imprimir todos los libros
                    for (int i = 0; i < listaLibros.size(); i++) {
                        System.out.println("TITULO: " + listaLibros.get(i).getTitulo() + " ISBN:" + listaLibros.get(i).getISBN()
                                + " CATEGORÍA: " + listaLibros.get(i).getCategoria());
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
        titulo = lectura.nextLine();
        libroTemporal.setTitulo(titulo);

        //ISBN
        System.out.println("Ingrese el ISBN!");
        ISBN = lectura.next();
        libroTemporal.setISBN(ISBN);

        //Autor(es)
        String resAutor = "";
        while (salida != 0) {
            System.out.println("Ingrese autor(es)!");
            resAutor = lectura.nextLine();
            resAutor = lectura.nextLine();
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
        categoria = lectura.nextLine();
        libroTemporal.setCategoria(categoria);

        //Agregar el libro recien creado a la lista
        listaLibros.add(libroTemporal);

        System.out.println("Libro agregado exitosamente!");

    }//FIN METODO AGREGAR LIBRO

    public static Libro buscarPorISBN(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(isbn)) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro con ese ISBN
    }

    public static ArrayList<Libro> buscarPorTitulo(String titulo) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public static ArrayList<Libro> buscarPorCategoria(String categoria) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getCategoria().equalsIgnoreCase(categoria)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

}
