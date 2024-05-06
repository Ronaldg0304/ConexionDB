/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //Conectando a la base de datos.
    Connection con;
    // URL y driver de conexión a la base de datos
    String URL = "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=BD_CONEXION";
    String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // Nombre de usuario y contraseña para acceder a la base de datos
    String USUARIO = "sa";
    String CONTRASENA = "1234";

    public Conexion() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (Exception e) {
            System.out.println("Error en la conexión " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }

}
