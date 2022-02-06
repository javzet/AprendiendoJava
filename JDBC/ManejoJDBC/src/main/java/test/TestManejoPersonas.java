package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        int registrosAfectados = 0;
        
        // Insertar persona a la base de datos
//        Persona nuevaPersona = new Persona("Ubaldo", "Costra", "ubaldo.c@mail.com", "5578151465");
//        registrosAfectados = personaDao.insertar(nuevaPersona);
//        System.out.println(registrosAfectados + " registros afectados");
        
        // Actualizar persona a la base de datos
        Persona personaActualizar = new Persona(1, "Pancho", "Lopez", "pancho.lpz@mail.com", "5589213254");
        registrosAfectados = personaDao.actualizar(personaActualizar);
        System.out.println(registrosAfectados + " registros afectados");
        
        // Eliminar persona de la base de datos
//        Persona personaBorrar = new Persona(2);
//        registrosAfectados = personaDao.eliminar(personaBorrar);
//        System.out.println(registrosAfectados + " registros afectados");
        
        // Consultar datos
        List<Persona> personas = personaDao.seleccionar();
        
        for(Persona persona: personas) {
            System.out.println(persona.toString());
        }
        
    }
}
