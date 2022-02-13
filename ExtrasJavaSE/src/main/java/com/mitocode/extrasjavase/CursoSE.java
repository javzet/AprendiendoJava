package com.mitocode.extrasjavase;

import java.util.LinkedList;
import java.util.List;

public class CursoSE {
    public static void main(String[] args) {
        List<Integer> lista = new LinkedList();
        
        lista.add(1);
        lista.add(2);
        
        System.out.println(lista.size());
        System.out.println(lista.get(0));
        System.out.println(lista.get(lista.size() - 1));
        
        // LinkedList es mucho más rápido que ArrayList al agregar y eliminar elementos
        // mientas que LinkedList es mucho más lento para obtener elementos
    }
}
