package mx.com.gm.peliculas.negocio;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos accesoDatos;
    private final String NOMBRE_RECURSO = "peliculas.txt";

    public CatalogoPeliculasImpl() {
        this.accesoDatos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {

        Pelicula nuevaPelicula = new Pelicula(nombrePelicula);

        try {
            this.accesoDatos.escribir(nuevaPelicula, NOMBRE_RECURSO, true);
        } catch (EscrituraDatosEx ex) {
            System.out.println("Ha ocurrido un error al agregar la pelicula");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = this.accesoDatos.listar(NOMBRE_RECURSO);
            peliculas.forEach(pelicula -> {
                System.out.println(pelicula);
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Ha ocurrido un error al listar las películas");
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        try {
            String resultado = this.accesoDatos.buscar(NOMBRE_RECURSO, buscar);
            System.out.println(resultado);
        } catch (LecturaDatosEx ex) {
            System.out.println("Ha ocurrido un error al buscar la película");
            ex.printStackTrace();
        }
    }

    @Override
    public void iniciarArchivo() {
        try {

            boolean archivoExiste = this.accesoDatos.existe(NOMBRE_RECURSO);
            if (archivoExiste) {
                System.out.println("El archivo " + NOMBRE_RECURSO + "ya existe");
                return;
            }

            this.accesoDatos.crear(NOMBRE_RECURSO);
        } catch (AccesoDatosEx ex) {
            System.out.println("Ha ocurrido un error al crear el archivo");
        }
    }

}
