/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica01;

import vista.Aplicacion;
import vista.AplicacionE;
import vista.AplicacionP;
import vista.AplicacionSE;

/**
 *
 * @author adrian
 */
public class Fabrica01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aplicacion appS = new AplicacionSE();
        Aplicacion appP = new AplicacionP();
        Aplicacion appE = new AplicacionE();
        Thread hiloS = new Thread(appS);
        hiloS.start();
        
        Thread hiloP = new Thread(appP);
        hiloP.start();

        Thread hiloE = new Thread(appE);
        hiloE.start();

    }
    
}
