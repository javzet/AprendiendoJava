package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestColeciones {

    public static void main(String[] args) {
        
        // Ordenado, se pueden duplicar los elementos
        
        List miLista = new ArrayList();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");
        
//        imprimir(miLista);
        
        // Desordenado y más rápido, no se pueden duplicar elementos, si se agreago otro, se elimina el primero

        Set miSet = new HashSet();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Sabado");
        miSet.add("Domingo");
        
//        imprimir(miSet);


        Map miMapa = new HashMap();
        miMapa.put("valor1", "Juan");
        miMapa.put("valor2", "Karla");
        miMapa.put("valor3", "Pedro");
        miMapa.put("valor4", "Franco");
        miMapa.put("valor5", "Pablo");
        
        String elemento = (String) miMapa.get("valor1");
        System.out.println(elemento);
        
        Set keySet = miMapa.keySet();
        System.out.println(keySet);
        
        imprimir(keySet);
        
        Collection miMapaValores = miMapa.values();
        imprimir(miMapaValores);
    }

    public static void imprimir(Collection c) {
        // For each clásico
        for (Object elemento : c) {
            System.out.println("Elemento = " + elemento);
        }

        // For each con lamnda (+Java 8)
        c.forEach(element -> {
            System.out.println("elemento lamnda forEach = " + element);
        });
    }
}
