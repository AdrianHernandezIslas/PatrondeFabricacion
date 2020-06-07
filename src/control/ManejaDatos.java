/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author adrian
 */
public abstract class ManejaDatos {
    protected Connection con;
    protected Conexion conec;
    protected int numCampos;
    protected Object campos[];
    
    protected ManejaDatos(){
        conec = Conexion.getConexion("jdbc:mysql://localhost/tec","root","Ahi.290795");
        con = Conexion.getConnection();
    }
    
    public abstract List<Object []> consultaDatos(String sql);
    
    public boolean actualizarDatos(String sql){
        boolean res = false;
        try {
            Statement st = con.createStatement();
            st.execute(sql);
            res=true;
        } catch (SQLException e) {
            System.err.println(e.getCause()+"\n"+e.getMessage());
        }
        return res;
    }
    
    public boolean cerrarSesion(){
        return conec.cerrarConexion();
    }
    
}
