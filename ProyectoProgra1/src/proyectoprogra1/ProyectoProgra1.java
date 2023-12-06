package proyectoprogra1;

import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoProgra1 {

    public static Scanner lectura = new Scanner(System.in);
    //public String [] listaAutores = new String[7];

    public static ArrayList<String> listaAutores = new ArrayList<String>();

    public static void main(String[] args) {
        int res_menu;
        System.out.println("Cambio probando");
        System.out.println("====Menu====");
        System.out.println("1) Ingresar Nuevo Libro\n2) Buscar libro por código ISBN\n3) Buscar libro por título del libro\n4) Buscar libros por categoría temática deseada\n5) Eliminar libro por código ISBN"
                + "\n6) Eliminar libro por categoría temática\n7) Imprimir la información de todos los libros\n8) Imprimir la información de los libros que tengan una categoría temática deseada\n9) Salir");

        res_menu = lectura.nextInt();
        switch(res_menu){
            case 1:
                agregar();
                break;
            default:
                System.out.println("Saliendo...");
        
        
        }
    }

    public static void agregar() {
        int salida;
        String resAutor = "";
        do {
            System.out.println("Ingrese autor(es): ");
            resAutor = lectura.nextLine();
            lectura.nextLine();
            listaAutores.add(resAutor);
            try {
                System.out.println("Desea ingresar otro autor? (1 Para Sí || 0 Para No)");
                salida = lectura.nextInt();
                switch (salida) {
                    case 1:
                        System.out.println("");
                        break;
                    case 0:
                        System.out.println("");
                        break;
                    default:
                        System.out.println("");

                }
            } catch (Exception e) {
                System.out.println("Opción no válida");
                salida = 1;
            }

        } while (salida != 0);
    }
}
