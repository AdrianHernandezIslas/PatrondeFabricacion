/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatos;
import control.ManejaDatosE;
import datos.ModeloTabla;
import datos.ModeloTablaE;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author adrian
 */
public class AplicacionE extends Aplicacion{
    private JButton btnTerminar;
    public AplicacionE() {
        super();
        modeloTabla = crearModelo();
        manejadorDatos = crearManejador();
        iniElemnts(JOptionPane.showInputDialog("Numero de Control"));
        addElementos();
    }
    
    public void iniElemnts(String n){
       tabla = new JTable();
       modeloTabla.setDatos(manejadorDatos.consultaDatos("select nControl,nombre,sexo,edad,direccion from alumno where nControl = "+n), manejadorDatos);
       tabla.setModel(modeloTabla);
       btnTerminar = new JButton("Terminar");
       btnTerminar.addActionListener(this);
    }
    
     public void addElementos(){
        setLayout(new BorderLayout());
        pnlSur.add(btnTerminar);
        pnlCenter.add(new JScrollPane(tabla));
        add(pnlNorte,BorderLayout.NORTH);
        add(pnlCenter,BorderLayout.CENTER);
        add(pnlSur,BorderLayout.SOUTH);
        
    }
    

    @Override
    public ManejaDatos crearManejador() {
        return new ManejaDatosE(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModeloTabla crearModelo() {
        return new ModeloTablaE(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(manejadorDatos.cerrarSesion()){
            dispose();
        }
    }

    @Override
    public void run() {
        setSize(800,300);
        setTitle("Estudiante");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
