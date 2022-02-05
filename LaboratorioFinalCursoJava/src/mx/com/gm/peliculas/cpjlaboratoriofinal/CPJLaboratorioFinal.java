package mx.com.gm.peliculas.cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {

        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar catalogo de peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar pelicula\n"
                    + "0. Salir");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Solo puedes escribir números como opciones");
                continue;
            }

            switch (opcion) {
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    String nombre = scanner.nextLine();
                    catalogo.agregarPelicula(nombre);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce tu busqueda: ");
                    String buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Opcion invalida, opciones válidas: 0,1,2,3,4");
            }
        }

    }
}
