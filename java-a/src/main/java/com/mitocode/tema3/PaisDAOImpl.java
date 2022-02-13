package com.mitocode.tema3;

import java.util.ArrayList;
import java.util.List;

public class PaisDAOImpl {
    
    private static PaisDAOImpl instancia = null;
    
    public static PaisDAOImpl getInstance() {
        if(instancia == null) {
            instancia = new PaisDAOImpl();
        }
        
        return instancia;
    }
    
    private PaisDAOImpl() {}

    private List paises = null;

    public List getPaises() {

        if (paises == null) {

            this.paises = new ArrayList();

            Pais p1 = new Pais("México");
            Pais p2 = new Pais("EU");
            Pais p3 = new Pais("Colombia");

            this.paises.add(p1);
            this.paises.add(p2);
            this.paises.add(p3);
        }
        return this.paises;
    }
}
