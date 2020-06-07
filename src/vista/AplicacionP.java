/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatos;
import control.ManejaDatosP;
import datos.ModeloTabla;
import datos.ModeloTablaP;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author adrian
 */
public class AplicacionP extends Aplicacion{
    private JButton btnTerminar;
    public AplicacionP() {
        super();
        modeloTabla = crearModelo();
        manejadorDatos = crearManejador();
        iniElemnts();
        addElementos();
    }
    
    public void iniElemnts(){
       tabla = new JTable();
       modeloTabla.setDatos(manejadorDatos.consultaDatos("SELECT nControl,nombre,calificacion FROM tec.alumno;"), manejadorDatos);
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
        return new ManejaDatosP(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModeloTabla crearModelo() {
        return new ModeloTablaP(); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void run() {
        setSize(800,300);
        setTitle("Docente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(manejadorDatos.cerrarSesion()){
            dispose();
        }
    }
}
