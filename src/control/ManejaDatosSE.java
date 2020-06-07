/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author adrian
 */
public class ManejaDatosSE extends ManejaDatos{

    public ManejaDatosSE(){
       super();
       numCampos = 9;
    }
    
    @Override
    public List<Object[]> consultaDatos(String sql) {
        List<Object []> datos = new ArrayList();
        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
                campos = new Object[numCampos];
                campos[0] = rs.getInt(1);
                campos[1] = rs.getString(2);
                campos[2] = rs.getString(3);
                campos[3] = rs.getInt(4);
                campos[4] = rs.getString(5);
                campos[5] = rs.getString(6);
                campos[6] = rs.getInt(7);
                campos[7] = rs.getInt(8);
                campos[8] = rs.getInt(9);
                datos.add(campos);
            }
        } catch (SQLException e) {
            System.err.println("\n"+e.getMessage());
           
        }
        
        return datos;
    }

    public int lastRecord(){
        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("select max(nControl) from alumno");
            return (rs.next())?rs.getInt(1):1;
        } catch (SQLException e) {
        }
       return 0; 
    }
    
}
