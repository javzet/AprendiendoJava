package com.mitocode.tema6;

import java.util.HashSet;
import java.util.Set;

public class AppSet {

    public static void main(String[] args) {
        /*
        Set<String> lista = new HashSet<>();
        lista.add("MitoCode");
        lista.add("Mito");
        lista.add("Code");
        lista.add("MitoCode");
        lista.add("Asadasd");
        lista.add("Hola");
        lista.add("hola");
        lista.add("perror");
        
        for(String elemento : lista) {
            System.out.println(elemento);
        }*/

        Set<Persona> lista = new HashSet<>();
        lista.add(new Persona("Pablo", 14));
        lista.add(new Persona("Luis", 48));
        lista.add(new Persona("Pablo", 17));
        lista.add(new Persona("Pablo", 10));
        lista.add(new Persona("Frank", 13));
        lista.add(new Persona("Pancho", 14));
        lista.add(new Persona("Pablo", 10));
        
        for(Persona per : lista) {
            System.out.println(per.getNombre());
        }
    }
}
