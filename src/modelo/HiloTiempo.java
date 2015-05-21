/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PnlInfoJuego;

/**
 *
 * @author vini
 */
public class HiloTiempo extends Thread {
    
    private String tiempo = "";
    private PnlInfoJuego pnlInfoJuego;
    
    public HiloTiempo(PnlInfoJuego panelInfo) {
        this.pnlInfoJuego = panelInfo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public String getTiempo() {
        return tiempo;
    }
  

    ///////////////////////////////////////////////////////////////////////////
    public void run() {
        while (true) {
            try {
                
                for (int minutos = 0; minutos < 60; minutos++) {
                    for (int segundos = 0; segundos < 60; segundos++) {
                        this.tiempo = minutos + ":" + segundos;
                        this.sleep(1000); // el tiempo debe ser de 1000
                        
                        pnlInfoJuego.setjLabel_TiempoDeJuego(tiempo);
                        
                    }
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
} // fin de clase
