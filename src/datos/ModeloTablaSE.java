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
public class ModeloTablaSE extends ModeloTabla{

    public ModeloTablaSE() {
        super(new String[]{"N° Ctrol","Nombre","Sexo","Edad","Direccion","Carrera","Semestre","Creditos","Calificacion"}, 
                  new Class[]{Integer.class,String.class,String.class,Integer.class,String.class,String.class,
                              Integer.class,Integer.class,Integer.class});
    }

    @Override
    public void setValueAt(Object aValue, int r, int c) {
        if(c>0){
            dato.get(r)[c] = (Object) aValue;
            String datos = "UPDATE tec.alumno set nombre='"+
                           dato.get(r)[1]+"', sexo ='"+dato.get(r)[2]+
                            "', edad="+dato.get(r)[3]+" , direccion = '"+
                            dato.get(r)[4]+ "', Carrera = '"+dato.get(r)[5]+
                            "', semestre = "+dato.get(r)[6]+", creditos = "+dato.get(r)[7]+
                            ", calificacion = "+dato.get(r)[8]+
                    " where nControl = "+dato.get(r)[0];
            //System.out.println(datos);
            baseDatos.actualizarDatos(datos);
        }
        
    }
    
    
    
}
