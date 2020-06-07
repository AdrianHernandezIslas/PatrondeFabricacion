/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author adrian
 */
public class ModeloTablaP extends ModeloTabla{

    public ModeloTablaP() {
        super(new String[]{"N° Ctrol","Nombre","Calificacion",}, 
                  new Class[]{Integer.class,String.class,Integer.class});
    }

    @Override
    public void setValueAt(Object aValue, int r, int c) {
        if(c == 2){
            dato.get(r)[c] = (Object) aValue;
            String datos = "UPDATE tec.alumno set calificacion ="+
                           dato.get(r)[2]+
                            " where nControl = "+dato.get(r)[0];
            System.out.println(datos);
            baseDatos.actualizarDatos(datos);
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 2;
    }
    
    
    
}
