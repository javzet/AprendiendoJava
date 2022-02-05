package mx.com.gm.peliculas.negocio;

public interface CatalogoPeliculas {
    void agregarPelicula(String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarArchivo();
}
