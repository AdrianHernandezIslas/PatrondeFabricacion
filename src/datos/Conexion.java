/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author adrian
 */
public class Conexion {
    private static Connection coneccion;
    private static Conexion conexion;
    private static int numConexiones;
    
    private Conexion(String url, String usuario,String password ){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coneccion = (Connection) DriverManager.getConnection(url, usuario, password);
            System.out.println();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized Conexion getConexion(String url, String usuario,String password){
        numConexiones++;
        if(coneccion == null){
           conexion = new Conexion(url, usuario, password);
        }
        return conexion;
    }
    
    public static Connection getConnection(){
        return coneccion;
    }
    
    public boolean cerrarConexion(){
        try {
          if(coneccion != null){
            if (numConexiones == 1) {
                coneccion.close();
                return true;
            }else{
               numConexiones--;
               return false;
            }
          }
        } catch (SQLException e) {}
        return false;
    }
    
    
}
