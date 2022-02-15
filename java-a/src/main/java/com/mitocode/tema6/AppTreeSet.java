package com.mitocode.tema6;

import java.util.Set;
import java.util.TreeSet;

public class AppTreeSet {

    public static void main(String[] args) {
        /*
        Set<String> lista = new TreeSet<>();
        lista.add("Mito");
        lista.add("MitoCode");
        lista.add("Code");
        lista.add("Jaime");
        lista.add("MitoCode");
        
        for(String el : lista) {
            System.out.println(el);
        }
         */
        Set<Persona> lista = new TreeSet<>();
        lista.add(new Persona("MitoCode", 10));
        lista.add(new Persona("Code", 13));
        lista.add(new Persona("Mito", 12));
        lista.add(new Persona("MitoCode", 100));
        lista.add(new Persona("Jaime", 25));
        lista.add(new Persona("MitoCode", 100));

        for (Persona p : lista) {
            System.out.println(p.getNombre() + " - " + p.getEdad());
        }
    }
}
