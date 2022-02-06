package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioJDBCTest {
    
    private static final UsuarioDAO usuarioDao = new UsuarioDAO();
    
    public static void main(String[] args) {
//        insertarUsuarios();
        
//        actualizarUsuarios();

        eliminarUsuarios();
        
        listarUsuarios();
        
    }
    
    public static void eliminarUsuarios() {
        int registrosAfectados = 0;
        
        Usuario usuarioEliminar = new Usuario(2);
        
        registrosAfectados = usuarioDao.eliminar(usuarioEliminar);
        
        System.out.println(registrosAfectados);
    }
    
    public static void actualizarUsuarios() {
        int registrosAfectados = 0;
        
        Usuario usuarioActualizar = new Usuario(1, "Peter", "1378");
        registrosAfectados = usuarioDao.actualizar(usuarioActualizar);
        
        System.out.println(registrosAfectados);
        
    }
    
    public static void insertarUsuarios() {
        Usuario usuarioNuevo1 = new Usuario("Pedro", "1379");
        Usuario usuarioNuevo2 = new Usuario("Francisco", "1379");
        Usuario usuarioNuevo3 = new Usuario("Carlos", "1379");
        
        usuarioDao.insertar(usuarioNuevo1);
        usuarioDao.insertar(usuarioNuevo2);
        usuarioDao.insertar(usuarioNuevo3);
    }
    
    public static void listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        
        usuarios = usuarioDao.seleccionar();
        
        usuarios.forEach(usuario -> {
            System.out.println(usuario.toString());
        });
    }
}
