package proyectoprogra1;

import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoProgra1 {

    public static Scanner lectura = new Scanner(System.in);

    //public static ArrayList<String> listaAutores = new ArrayList<String>();
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
                    System.out.println("¿Busca un libro por titulo?");
                    System.out.println("Ingrese el título del libro:");
                    String tituloBusqueda = lectura.nextLine();
                    tituloBusqueda = lectura.nextLine();
                    int bandera = 1,
                     confirmacion = 0;
                    ArrayList<Libro> librosEncontradosPorTitulo = buscarPorTitulo(tituloBusqueda);

                    //RESULTADOS
                    String resultados = "";
                    for (int i = 0; i < librosEncontradosPorTitulo.size(); i++) {
                        if (!librosEncontradosPorTitulo.get(i).getTitulo().equals(tituloBusqueda)) {
                            bandera = 0;
                        } else {
                            resultados += "ISBN: " + librosEncontradosPorTitulo.get(i).getISBN()
                                    + " Título: " + librosEncontradosPorTitulo.get(i).getTitulo()
                                    + "\n";
                            confirmacion = 1;
                        }

                    }

                    if (confirmacion == 1) {
                        System.out.println(resultados);
                    } else if (bandera == 0) {
                        System.out.println("No hay libros registrados!");
                    }
                    break;
                case 4:

                    //Forma de buscar por categoria tematica.......... Jonathan L
                    System.out.println("¿Busca libros por categoría temática?");
                    System.out.println("Ingrese la categoría:");
                    String categoriaBusqueda = lectura.nextLine();
                    categoriaBusqueda = lectura.nextLine(); // Consumir el salto de línea pendiente

                    ArrayList<Libro> librosEncontradosPorCategoria = buscarPorCategoria(categoriaBusqueda);

                    // Verificar si se encontraron libros con esa categoría
                    if (!librosEncontradosPorCategoria.isEmpty()) {
                        System.out.println("Libros encontrados en la categoría " + categoriaBusqueda + ":");
                        for (Libro libro : librosEncontradosPorCategoria) {
                            System.out.println("ISBN: " + libro.getISBN() + ", Título: " + libro.getTitulo());
                            // Mostrar otros detalles del libro si es necesario
                        }
                    } else {
                        System.out.println("No se encontraron libros en la categoría " + categoriaBusqueda);
                    }
                    break;

                case 5:
                    //Eliminar por ISBN
                    eliminarISBN();
                    break;
                case 6:
                    //ELiminar por Categoria
                    eliminarCategoria();
                    break;
                case 7:
                    //Imprimir todos los libros
                    MostrarLibros();
                    break;
                case 8:
                    //Imprimir todos los libros dependiendo de la categoría
                    MostrarLibrosCategoria();
                    break;
                default: //opcion de salida
                    System.out.println("Saliendo...");
                    res_menu = 9;
            }
        } while (res_menu != 9);

    }

    public static void agregar() {
        try {
            int salida = 1;
            //Objeto libro
            Libro libroTemporal = new Libro();
            String titulo, ISBN, categoria, editorial;;
            int num_paginas, año = 0, num_edicion, num_estante, pos_estante, cantidad;
            int uniqueISBN = 0;

            String mensajeNO = "", mensajeSI = "";

            //Titulo
            do {
                System.out.println("Ingrese el título del libro!");
                titulo = lectura.nextLine();
                titulo = lectura.nextLine();
                if (titulo.length() < 1) {
                    System.out.println("Título debe tener al menos 1 caracter");
                } else {

                }
            } while (titulo.length() < 1);
            libroTemporal.setTitulo(titulo);

            //ISBN
            do {
                System.out.println("Ingrese el ISBN!");
                ISBN = lectura.nextLine();
                if (ISBN.length() < 1) {
                    System.out.println("ISBN no puede quedar vacío");
                } else {
                }

            } while (ISBN.length() < 1);//Fin While

            libroTemporal.setISBN(ISBN);

            //Autor(es)
            String resAutor = "";
            ArrayList<String> listaAutores = new ArrayList<String>();
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

            //Número de Páginas
            System.out.println("Ingrese el número de páginas!");
            num_paginas = lectura.nextInt();
            libroTemporal.setNum_paginas(num_paginas);

            //Año de publicación
            int flagAño = 6;
            do {
                System.out.println("Ingrese el año de publicación!");
                año = lectura.nextInt();
                if (año >= 0 && año <= 2023) {
                    libroTemporal.setAño(año);
                    flagAño = 1;
                } else if (año < 0 && año > 2023) {
                    System.out.println("Año no está en el rango!");
                    flagAño = 0;
                } else {
                    System.out.println("Dato no válido");
                    flagAño = 0;
                }

            } while (flagAño == 0);

            //Editorial
            System.out.println("Ingrese el nombre de la editorial!");
            editorial = lectura.nextLine();
            editorial = lectura.nextLine();
            libroTemporal.setEditorial(editorial);

            //Número de edición
            System.out.println("Ingrese el número de la edición!");
            num_edicion = lectura.nextInt();
            libroTemporal.setNum_edicion(num_edicion);

            //Número de estante
            System.out.println("Ingrese el número del estante!");
            num_estante = lectura.nextInt();
            libroTemporal.setNum_estante(num_estante);

            //Posición estante
            System.out.println("Ingrese la posición del estante!");
            pos_estante = lectura.nextInt();
            libroTemporal.setPos_estante(pos_estante);

            //Cantidad de copias
            System.out.println("Ingrese el número de copias!");
            cantidad = lectura.nextInt();
            libroTemporal.setCantidad(cantidad);

            //Agregar el libro recien creado a la lista
            listaLibros.add(libroTemporal);

            System.out.println(
                    "Libro agregado exitosamente!");

        } catch (Exception d) {
            System.out.println("¡Ha ocurrido un error! Por favor intente de nuevo.");
        }


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

    public static void MostrarLibros() {
        for (int i = 0; i < listaLibros.size(); i++) {
            System.out.println("* TITULO: " + listaLibros.get(i).getTitulo() + "\nISBN: " + listaLibros.get(i).getISBN());
            System.out.println("Autor(es): ");
            for (int j = 0; j < listaLibros.get(i).getAutores().size(); j++) {
                System.out.println("-" + listaLibros.get(i).getAutores().get(j));
            }
            System.out.println("\nCATEGORÍA: " + listaLibros.get(i).getCategoria() + "\nNÚMERO PÁGINAS: " + listaLibros.get(i).getNum_paginas()
                    + "\nAÑO PUBLICACIÓN: " + listaLibros.get(i).getAño() + "\nEDITORIAL: " + listaLibros.get(i).getEditorial()
                    + "\nNÚMERO EDICIÓN: " + listaLibros.get(i).getNum_edicion() + "\nESTANTE: " + listaLibros.get(i).getNum_estante()
                    + " POSICIÓN: " + listaLibros.get(i).getPos_estante() + "\nCANTIDAD: " + listaLibros.get(i).getCantidad());

            System.out.println("_________________________________________________");
        }
    }

    public static void eliminarLibroPorCategoria() {
        // Pedir al usuario que ingrese la categoría a buscar
        System.out.println("Ingrese la categoría del libro que desea eliminar:");
        String categoriaBusqueda = lectura.nextLine();
        categoriaBusqueda = lectura.nextLine();

        // Obtener todos los libros encontrados en esa categoría
        ArrayList<Libro> librosEncontradosPorCategoria = buscarPorCategoria(categoriaBusqueda);

        // Verificar si se encontraron libros con esa categoría y muestra cuantos hay
        if (!librosEncontradosPorCategoria.isEmpty()) {
            System.out.println("Libros encontrados en la categoría " + categoriaBusqueda + ":");
            for (int i = 0; i < librosEncontradosPorCategoria.size(); i++) {
                System.out.println((i + 1) + ") " + librosEncontradosPorCategoria.get(i).getTitulo());
            }

            // Pedir al usuario que elija el libro a eliminar segun numero listado
            try {
                System.out.println("Ingrese el número del libro que desea eliminar:");
                int numEliminar = lectura.nextInt();
                String tituloEliminar = librosEncontradosPorCategoria.get(numEliminar - 1).getTitulo();

                for (int i = 0; i < listaLibros.size(); i++) {
                    if (listaLibros.get(i).getTitulo().equals(tituloEliminar)) {
                        listaLibros.remove(i);
                        System.out.println("¡Libro '" + tituloEliminar + "' eliminado correctamente!");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese un número válido.");
            }
        } else {
            System.out.println("No se encontraron libros en la categoría " + categoriaBusqueda);
        }
    }

    public static void MostrarLibrosCategoria() {
        String categoriaBuscar;
        System.out.println("Ingrese una categoría");
        categoriaBuscar = lectura.nextLine();
        categoriaBuscar = lectura.nextLine();
        ArrayList<Libro> listaCategoria = new ArrayList<Libro>();

        //Ver si existe en la lista que tenemos
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getCategoria().equalsIgnoreCase(categoriaBuscar)) {
                System.out.println("* TITULO: " + listaLibros.get(i).getTitulo() + "\nISBN: " + listaLibros.get(i).getISBN());
                System.out.println("Autor(es): ");
                for (int j = 0; j < listaLibros.get(i).getAutores().size(); j++) {
                    System.out.println("-" + listaLibros.get(i).getAutores().get(j));
                }
                System.out.println("\nCATEGORÍA: " + listaLibros.get(i).getCategoria() + "\nNÚMERO PÁGINAS: " + listaLibros.get(i).getNum_paginas()
                        + "\nAÑO PUBLICACIÓN: " + listaLibros.get(i).getAño() + "\nEDITORIAL: " + listaLibros.get(i).getEditorial()
                        + "\nNÚMERO EDICIÓN: " + listaLibros.get(i).getNum_edicion() + "\nESTANTE: " + listaLibros.get(i).getNum_estante()
                        + " POSICIÓN: " + listaLibros.get(i).getPos_estante() + "\nCANTIDAD: " + listaLibros.get(i).getCantidad());

                System.out.println("_________________________________________________");
            }

        }

    }

    public static void eliminarISBN() {
        String ISBNBuscar, mensaje;
        int banderaSI = 0, banderaNO = 0;
        System.out.println("Ingrese el ISBN");
        ISBNBuscar = lectura.nextLine();
        ISBNBuscar = lectura.nextLine();
        Libro libroEncontrado = buscarPorISBN(ISBNBuscar);
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getISBN().equals(libroEncontrado.getISBN())) {
                listaLibros.remove(i);
                banderaSI = 1;
            } else {
                banderaNO = 1;
            }
        }

        if (banderaSI == 1) {
            System.out.println("Libro eliminado!");
        } else if (banderaNO == 1) {
            System.out.println("No se ha encontrado resultados de ese libro!");
        }
    }

    public static void eliminarCategoria() {
        String categoriaBusqueda, resultadoBusqueda;
        int numEliminar;
        System.out.println("Ingrese una categoría para eliminar");
        categoriaBusqueda = lectura.nextLine();
        categoriaBusqueda = lectura.nextLine();

        ArrayList<Libro> librosEncontradosPorCategoria = buscarPorCategoria(categoriaBusqueda);
        System.out.println(" Estos son los Libros encontrados en la categoría " + categoriaBusqueda + ":");
        for (int i = 0; i < librosEncontradosPorCategoria.size(); i++) {
            // Verificar si se encontraron libros con esa categoría
            if (!librosEncontradosPorCategoria.isEmpty()) {
                System.out.println((i + 1) + ") " + librosEncontradosPorCategoria.get(i).getTitulo());
            } else {
                System.out.println("No se encontraron libros con esa categoría " + categoriaBusqueda);
            }
        }

        try {
            System.out.println("Ingrese el número de libro que quiere eliminar");
            numEliminar = lectura.nextInt();
            resultadoBusqueda = librosEncontradosPorCategoria.get(numEliminar - 1).getTitulo();
            System.out.println("Libro " + resultadoBusqueda + " seleccionado.");

            //Eliminar libro del inventario
            for (int i = 0; i < listaLibros.size(); i++) {
                if (listaLibros.get(i).getTitulo().equals(resultadoBusqueda)) {
                    listaLibros.remove(i);
                }
            }

            System.out.println("¡Libro Eliminado!");
        } catch (Exception e) {
            System.out.println("Ingrese un número solamente");
        }
    }
}
