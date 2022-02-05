package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements AccesoDatos {

    public AccesoDatosImpl() {
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;

            linea = entrada.readLine();

            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }

            entrada.close();
            return peliculas;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:\n" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:\n" + ex.getMessage());
        }
    }

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        PrintWriter salida = null;

        try {
            salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.getNombre());
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx(ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            int indice = 1;

            while (linea != null) {
                if (linea != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en el índice " + indice;
                    break;
                }

                linea = entrada.readLine();
                indice++;
            }

            if (resultado == null) {
                resultado = "No se ha encontrado una película con nombre " + "\"" + buscar + "\"";
            }

            entrada.close();
            return resultado;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx(ex.getMessage());
        }
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx(ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }

}
