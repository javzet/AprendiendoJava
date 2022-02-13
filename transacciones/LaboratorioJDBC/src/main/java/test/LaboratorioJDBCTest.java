package test;

import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

public class LaboratorioJDBCTest {

    public static void main(String[] args) {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            
            if(conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            UsuarioDAO usuarioDao = new UsuarioDAO(conexion);
            
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsuario("Javier");
            nuevoUsuario.setPassword("ZACA1500200334");
            
            usuarioDao.insertar(nuevoUsuario);
            
            Usuario actualizarUsuario = new Usuario();
            actualizarUsuario.setId(1);
//            actualizarUsuario.setUsuario("Peterrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
            actualizarUsuario.setUsuario("Peter");
            actualizarUsuario.setPassword("ZACA1500200334");
            
            usuarioDao.actualizar(actualizarUsuario);
            
            conexion.commit();
            System.out.println("Se ha hecho el commit");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            
            System.out.println("Roleback hecho");
        } finally {
            Conexion.close(conexion);
        }

    }
}
