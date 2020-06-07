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
import java.util.List;

/**
 *
 * @author adrian
 */
public class ManejaDatosE extends ManejaDatos{

    public ManejaDatosE(){
       super();
       numCampos = 5;
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
                datos.add(campos);
            }
        } catch (SQLException e) {
            System.err.println("\n"+e.getMessage());
            
        }
        
        return datos; 
    }

    
}
