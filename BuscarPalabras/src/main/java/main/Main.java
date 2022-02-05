package main;

import busqueda.Busqueda;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> listaLetrasContenidas = new ArrayList<>();
        List<String> listaLetrasEnAlfabeto = new ArrayList<>();

        listaLetrasContenidas.add("a");
        listaLetrasContenidas.add("l");
        listaLetrasContenidas.add("p");
        
        listaLetrasEnAlfabeto.add("p");
        listaLetrasEnAlfabeto.add("l");
//        listaLetrasEnAlfabeto.add("b");
//        listaLetrasEnAlfabeto.add("c");
//        listaLetrasEnAlfabeto.add("e");
        
        Busqueda busqueda = new Busqueda(listaLetrasContenidas, listaLetrasEnAlfabeto);
        
        List<String> palabrasEncontradas = busqueda.buscar();
        
        System.out.println("Palabras encontradas: " + palabrasEncontradas.size());
        palabrasEncontradas.forEach(palabra -> {
            System.out.println(palabra);
        });
    }
}
