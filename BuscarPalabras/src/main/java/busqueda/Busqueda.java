package busqueda;

import archivos.ManejoArchivos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Busqueda {

    private final List<String> listaLetrasContenidas;
    private final List<String> listaLetrasPosibles;
    private final String RUTA_ARCHIVOS = "/home/javier/Downloads/dict_rae_txt/dics";

    public Busqueda(List<String> listaLetrasContenidas, List<String> listaLetrasPosibles) {
        this.listaLetrasContenidas = listaLetrasContenidas;
        this.listaLetrasPosibles = listaLetrasPosibles;
    }

    public List<String> buscar() {
        List<String> palabrasEncontradas = new ArrayList<>();
        Map<String, List<String>> data = new HashMap<>();

        ManejoArchivos manejador = new ManejoArchivos(RUTA_ARCHIVOS);

        this.listaLetrasPosibles.forEach(letra -> {

            List<String> dataInFileFound = manejador.leerArchivo(letra.toLowerCase()+".txt");

            data.put(letra.toLowerCase(), dataInFileFound);

        });

        data.keySet().forEach(key -> {

            data.get(key).forEach(word -> {

                int matches = 0;

                for (int i = 0; i < this.listaLetrasContenidas.size(); i++) {
                    if (word.contains(this.listaLetrasContenidas.get(i))) {
                        matches++;
                    }
                }
                
//                if(matches >= 2) {
//                    palabrasEncontradas.add(word);
//                }
                if(matches >= listaLetrasContenidas.size()) {
                    palabrasEncontradas.add(word);
                }
            });
        });

        return palabrasEncontradas;
    }

}
