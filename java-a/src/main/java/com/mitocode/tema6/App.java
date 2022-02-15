package com.mitocode.tema6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(25);
        lista.add(10000);
        lista.add(1);
        
        Collections.reverse(lista);
        
        System.out.println(lista);
        
        
        List<String> lista1 = new ArrayList<>();
        lista1.add("aaaaaaaaaa");
        lista1.add("zdads");
        lista1.add("yyy");
        lista1.add("basdas");
        
//        Collections.sort(lista1);
        Collections.reverse(lista1);
        
        System.out.println(lista1);
        
        List<Persona> lista2 = new ArrayList<>();
        lista2.add(new Persona("Pablo", 12));
        lista2.add(new Persona("Franco", 212));
        lista2.add(new Persona("Chili", 9));
        
        // Collections.sort(lista2, new NombreComparator());
        /*
        Collections.sort(lista2, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                int rpsta = 0;
                
                if(p1.getEdad() > p2.getEdad()) {
                    rpsta = 1;
                } else if(p1.getEdad() < p2.getEdad()) {
                    rpsta = -1;
                } else {
                    rpsta = 0;
                }
                
                return rpsta;
            }
        });
        
        for(Persona p: lista2) {
            System.out.println(p.getNombre());
        }*/
        
        Collections.sort(lista2);
        
        for(Persona p : lista2) {
            System.out.println(p.getNombre());
        }
    }
}
