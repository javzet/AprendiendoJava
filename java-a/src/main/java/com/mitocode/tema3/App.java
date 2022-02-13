package com.mitocode.tema3;

public class App {
    public static void main(String[] args) {
        PaisDAOImpl dao = PaisDAOImpl.getInstance();
        for(Object obj : dao.getPaises()) {
            System.out.println(((Pais)obj).getNombre());
        }
        
        System.out.println("*****************");
        
        for(Object obj : dao.getPaises()) {
            System.out.println(((Pais)obj).getNombre());
        }
        
        System.out.println("*****************");
        
        PaisDAOImpl dao1 = PaisDAOImpl.getInstance();
        for(Object obj : dao1.getPaises()) {
            System.out.println(((Pais)obj).getNombre());
        }
        
    }
}
