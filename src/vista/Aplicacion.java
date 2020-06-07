/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatos;
import datos.ModeloTabla;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author adrian
 */
public abstract class Aplicacion extends JFrame implements ActionListener, Runnable{
   protected ManejaDatos manejadorDatos;
   protected ModeloTabla modeloTabla;
   protected JTable tabla;
   protected JPanel pnlNorte,pnlCenter,pnlSur;
   
   public Aplicacion(){
       pnlNorte = new JPanel(new GridLayout(2,0));
       pnlCenter = new JPanel(new GridLayout(0, 1));
       pnlSur = new JPanel(new FlowLayout());
   }
  
   
   public abstract ManejaDatos crearManejador();
   public abstract ModeloTabla crearModelo();
}
