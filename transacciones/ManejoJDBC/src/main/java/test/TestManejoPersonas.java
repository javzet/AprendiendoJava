package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;

public class TestManejoPersonas {
    public static void main(String[] args) {
        
        Connection conexion = null;
        
        try {
            
            conexion = Conexion.getConnection();
            
            if(conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            PersonaDAO personaDao = new PersonaDAO(conexion);
            
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(4);
            cambioPersona.setNombre("Pedro");
            cambioPersona.setApellido("Costra");
            cambioPersona.setEmail("pedro.cs@mail.com");
            cambioPersona.setTelefono("5578151465");
            
            personaDao.actualizar(cambioPersona);
            
            Persona nuevaPersona = new Persona();
            
            nuevaPersona.setNombre("Iban");
//            nuevaPersona.setApellido("Ramirezffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
            nuevaPersona.setApellido("Ramirez");

            personaDao.insertar(nuevaPersona);
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transacción");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
