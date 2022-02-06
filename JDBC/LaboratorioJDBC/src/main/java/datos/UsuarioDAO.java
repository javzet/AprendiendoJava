package datos;

import java.util.List;
import domain.Usuario;

import static datos.Conexion.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario;";
    private static final String SQL_INSERT = "INSERT INTO "
            + "usuario(usuario, password) "
            + "VALUES(?, ?);";
    private static final String SQL_UPDATE = "UPDATE usuario "
            + "SET usuario = ?, password = ? WHERE id_usuario = ?;";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?;";
    
    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
            
                int idUsuario = rs.getInt("id_usuario");
                String usuarioUsario = rs.getString("usuario");
                String password = rs.getString("password");
                
               usuario = new Usuario(idUsuario, usuarioUsario, password);
               usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return usuarios;
    }
    
    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return registros;
    }
    
    public int actualizar(Usuario usuario) {
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getId());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return registros;
    }
    
    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, usuario.getId());
            
            registros = stmt.executeUpdate();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return registros;
    }
}
