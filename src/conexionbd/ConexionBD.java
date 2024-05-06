/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionbd;

import conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import modeloCRUD.OperacionesDAO;

/**
 *
 * @author rolan
 */
public class ConexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Usuario us = new Usuario(1, "Ronald", "Guerra", "rdguerra", "1234", 1); //Creación intancia de un usuario para registra en la BD_CONEXION
        OperacionesDAO dao = new OperacionesDAO(); //Instancia para realizar las operaciones CRUD.

       System.out.println("***************************");
        System.out.println("******AGREGAR USUARIO******");
        
        dao.add(us);//Inserción de un usuario a la BD_CONEXION
        System.out.println("¡Usuario agregado con exito!");

        System.out.println("***************************");
        System.out.println("******CONSULTAR USUARIOS******");

        List<Usuario> lista = new ArrayList<>();
        lista = dao.listar();

        for (int i = 0; i < lista.size(); i++) {
            Usuario registro = lista.get(i);
            System.out.println("ID: " + registro.getId() + ", Nombre: " + registro.getNombre() + ", Apellido: " + registro.getApellido() + ", Usuario: " + registro.getUser() + ", Contraseña: " + registro.getPassword() + ", Perfil: " + registro.getIdPerfil());
        }

        System.out.println("***************************");
        System.out.println("******MODIFICACIÓN USUARIO******");
        us.setApellido("Pérez");
        us.setIdPerfil(4);
        dao.edit(us);
        System.out.println("¡Usuario modificado con exito!");
        lista = dao.listar();

        for (int i = 0; i < lista.size(); i++) {
            Usuario registro = lista.get(i);
            System.out.println("ID: " + registro.getId() + ", Nombre: " + registro.getNombre() + ", Apellido: " + registro.getApellido() + ", Usuario: " + registro.getUser() + ", Contraseña: " + registro.getPassword() + ", Perfil: " + registro.getIdPerfil());
        }
        System.out.println("***************************");
        System.out.println("******ELIMINAR USUARIO*******");
        dao.delete(us.getId());
        System.out.println("¡Usuario eliminado con exito!");
        lista = dao.listar();

        for (int i = 0; i < lista.size(); i++) {
            Usuario registro = lista.get(i);
            System.out.println("ID: " + registro.getId() + ", Nombre: " + registro.getNombre() + ", Apellido: " + registro.getApellido() + ", Usuario: " + registro.getUser() + ", Contraseña: " + registro.getPassword() + ", Perfil: " + registro.getIdPerfil());
        }

    }

}
