package test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Alrevez voltearPalabra = new Alrevez();

        char opcion = 'Y';

        while (opcion != 'N') {
            System.out.println("Digite una palabra");
            String palabra = scanner.nextLine();

            String nuevaPalabra = voltearPalabra.alrevez(palabra);
            System.out.println(nuevaPalabra);

            System.out.println("Desea insertar una nueva palabra?\nPresione \"Y\" continuar.\nPresione \"N\" para salir");
            String respuesta = scanner.nextLine();
            opcion = respuesta.charAt(0);

        }

    }

}
