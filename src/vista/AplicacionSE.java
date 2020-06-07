/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ManejaDatos;
import control.ManejaDatosSE;
import datos.ModeloTabla;
import datos.ModeloTablaSE;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author adrian
 */
public class AplicacionSE extends Aplicacion implements ActionListener,Runnable{
    private JLabel eNCtrl,eNombre,eSexo,eEdad,eDireccion,eCarrera,eSemestre,eCreditos;
    private JTextField cNombre,cDireccion;
    private JComboBox selectCarrera;
    private JSpinner spinnerCreditos,spinnerSemestre,spinnerEdad;
    private JRadioButton radioSexoM,radioSexoF;
    private ButtonGroup btnGroup;
    private Container contenedorN,contenedorS;
    private JButton btnRegistrar,btnTerminar;
    
    public AplicacionSE(){
        super();
        modeloTabla = crearModelo();
        manejadorDatos = crearManejador();
        iniElemnts();
        addElementos();
    }
    

    private void iniElemnts() {
       btnRegistrar = new JButton("Registar");
       btnTerminar = new JButton("Terminar");
       eNCtrl = new JLabel("N° Cntrl: "+(((ManejaDatosSE)manejadorDatos).lastRecord()+1));
       eNombre = new JLabel("Nombre: ");
       eSexo = new JLabel("Sexo: ");
       eEdad = new JLabel("Edad: ");
       eDireccion = new JLabel("Direccion: ");
       eCarrera = new JLabel("Carrera: ");
       eSemestre = new JLabel("Semestre: ");
       eCreditos = new JLabel("Creditos");
       cNombre = new JTextField(15);
       cDireccion = new JTextField(20);
       selectCarrera = new JComboBox(new String[]{"Ing. Sistemas","Ing. Mecanica","Ing. Civil"});
       spinnerEdad = new JSpinner(new SpinnerNumberModel(15,15,100,1));
       spinnerSemestre = new JSpinner(new SpinnerNumberModel(1,1,12,1));
       spinnerCreditos = new JSpinner(new SpinnerNumberModel(0,0,50,1));
       btnGroup = new ButtonGroup();
       radioSexoM = new JRadioButton("Masculino");
       radioSexoF = new JRadioButton("Femenino",true);
       contenedorN = new Container();
       contenedorN.setLayout(new FlowLayout());
       contenedorS = new Container();
       contenedorS.setLayout(new FlowLayout());
       tabla = new JTable();
       btnGroup.add(radioSexoM);
       btnGroup.add(radioSexoF);
       modeloTabla.setDatos(manejadorDatos.consultaDatos("select * from alumno"), manejadorDatos);
       tabla.setModel(modeloTabla);
       btnRegistrar.addActionListener(this);
       btnTerminar.addActionListener(this);
    }
    
    public void addElementos(){
        setLayout(new BorderLayout());
        contenedorN.add(eNCtrl);
        contenedorN.add(eNombre);
        contenedorN.add(cNombre);
        contenedorN.add(eSexo);
        contenedorN.add(radioSexoF);
        contenedorN.add(radioSexoM);
        contenedorN.add(eEdad);
        contenedorN.add(spinnerEdad);
        contenedorS.add(eDireccion);
        contenedorS.add(cDireccion);
        contenedorS.add(eCarrera);
        contenedorS.add(selectCarrera);
        contenedorS.add(eSemestre);
        contenedorS.add(spinnerSemestre);
        contenedorS.add(eCreditos);
        contenedorS.add(spinnerCreditos);
        pnlNorte.add(contenedorN);
        pnlNorte.add(contenedorS);
        pnlSur.add(btnTerminar);
        pnlSur.add(btnRegistrar);
        
        pnlCenter.add(new JScrollPane(tabla));
        add(pnlNorte,BorderLayout.NORTH);
        add(pnlCenter,BorderLayout.CENTER);
        add(pnlSur,BorderLayout.SOUTH);
        
    }
    
    @Override
    public ManejaDatos crearManejador() {
         return new ManejaDatosSE();
    }

    @Override
    public ModeloTabla crearModelo() {
        return new ModeloTablaSE();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            manejadorDatos.actualizarDatos(getValues());
            modeloTabla.setDatos(manejadorDatos.consultaDatos("select * from tec.alumno"),manejadorDatos);
            modeloTabla.fireTableDataChanged();
        }else{
            if(manejadorDatos.cerrarSesion()){
                System.exit(0);
            }
        }
    }
    
    public String getValues(){
       return "insert into alumno values("+(((ManejaDatosSE)manejadorDatos).lastRecord()+1)+
              ",'"+cNombre.getText()+"','"+(radioSexoM.isSelected()?'M':'F')+"',"+spinnerEdad.getValue()
               +",'"+cDireccion.getText()+"','"+selectCarrera.getSelectedItem()+"',"+spinnerSemestre.getValue()
               +","+spinnerCreditos.getValue()+","+0+");";
    }

    @Override
    public void run() {
        setSize(800,300);
        setTitle("Servicios Escolares");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    

    
    
}
