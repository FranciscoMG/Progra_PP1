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
    private int suma = 0;
    private PnlInfoJuego pnlInfoJuego;

    public HiloTiempo(PnlInfoJuego panelInfo) {
        this.pnlInfoJuego = panelInfo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public String getTiempo() {
        return tiempo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public void iniciarRelog() {
        reloj();
    }

    ///////////////////////////////////////////////////////////////////////////
    public void run() {
        while (true) {
            try {
                this.sleep(1000); // el tiempo debe ser de 1000
                suma++;
                System.out.println(suma);
                pnlInfoJuego.setjLabel_TiempoDeJuego(String.valueOf(suma));
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    private void reloj() {

        for (int minutos = 0; minutos < 60; minutos++) {

            for (int segundos = 0; segundos < 60; segundos++) {
                this.tiempo = minutos + ":" + segundos;

                System.err.println(tiempo);
                //retraso();

            }
        }
    }

} // fin de clase
