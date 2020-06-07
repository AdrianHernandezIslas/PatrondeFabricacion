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
public class ModeloTablaE extends ModeloTabla{

    public ModeloTablaE() {
        super(new String[]{"N° Ctrol","Nombre","Sexo","Edad","Direccion"}, 
                  new Class[]{Integer.class,String.class,String.class,Integer.class,String.class});
    }

    @Override
    public void setValueAt(Object aValue, int r, int c) {
        if(c>0){
            dato.get(r)[c] = (Object) aValue;
            String datos = "UPDATE tec.alumno set nombre='"+
                           (String)dato.get(r)[1]+"', sexo ='"+dato.get(r)[2]+
                            "', edad="+dato.get(r)[3]+",direccion = '"+dato.get(r)[4]+
                            "' where nControl = "+dato.get(r)[0];
            System.out.println(datos);
            baseDatos.actualizarDatos(datos);
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col>2;
    }
    
    
    
}
