package com.mitocode.tema6;

import java.util.LinkedHashSet;
import java.util.Set;

public class AppLinkedHashSet {
    public static void main(String[] args) {
        Set<Persona> lista = new LinkedHashSet<>();
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

/*
        HashSet     TreeSet     LinkedSet
Valores Si          Si          Si      
Unicos

Orden   No          Orden A..Z  Orden de adición
                                a la colecc
ion
*/
