/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloCRUD;

import java.sql.Connection;
import conexion.Conexion;
import java.util.List;
import modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rolan
 */

public class OperacionesDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    //Método para consultas registros.
    public List listar() {

        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM USUARIOS";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId(rs.getInt("IdUsuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setUser(rs.getString("usuario"));
                us.setPassword(rs.getString("contrasena"));
                us.setIdPerfil(rs.getInt("IdPerfil"));
                list.add(us);

            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    //Metodo para listar por id los usuarios.
   
    public Usuario list(int id) {
        Usuario us=null;
        String sql = "SELECT * FROM USUARIOS WHERE idusuario=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                us.setId(rs.getInt("IdUsuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setUser(rs.getString("usuario"));
                us.setPassword(rs.getString("contrasena"));
                us.setIdPerfil(rs.getInt("IdPerfil"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return us;
    }
    //Metodo para crear un nuevo Usuario.
    
    public boolean add(Usuario us) {
        String sql = "INSERT INTO USUARIOS (IdUsuario, [nombre],[apellido],[usuario],[contrasena],IdPerfil)VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, us.getId());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getApellido());
            ps.setString(4, us.getUser());
            ps.setString(5, us.getPassword());
            ps.setInt(6, us.getIdPerfil());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
        return false;

    }
    //Metodo para editar un Usuario.
    
    public boolean edit(Usuario us) {
        String sql = "UPDATE USUARIOS "
                + "SET nombre = ?, "
                + "    apellido = ?, "
                + "    usuario = ?, "
                + "    contrasena = ?, "
                + "    idPerfil = ? "
                + "WHERE idUsuario =" + us.getId();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getApellido());
            ps.setString(3, us.getUser());
            ps.setString(4, us.getPassword());
            ps.setInt(5, us.getIdPerfil());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
    //Metodo eliminar un Usuario.
    
    public boolean delete(int id) {
        String sql = "DELETE FROM USUARIOS WHERE idusuario=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }
    

    //Metodo validar y crear un Usuario.
   
    public void usuarioExiste(Usuario us) {
        String sql = "SELECT * FROM USUARIOS WHERE idusuario=" + us.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean existeUsuario = rs.next();
            if (existeUsuario) {
                System.out.println("***Usuario ya existe***");
            } 
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
