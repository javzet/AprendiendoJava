package test;

import static manejoarchivos.ManejoArchivos.*;

public class TestManejoArchivos {
    public static void main(String[] args) {
        String nombreArchivo = "/home/javier/Downloads/prueba.txt";
//        crearArchivo(nombreArchivo);
//        anexarInformacionAlArchivo(nombreArchivo, "Hola perror");
//        anexarInformacionAlArchivo(nombreArchivo, "ADIOS perror");
          leerArchivo(nombreArchivo);
    }
}
