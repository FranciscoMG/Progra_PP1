/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.PnlInfoJuego;

/**
 *
 * @author vini
 */
public class HiloTiempo extends Thread {

    private String tiempo;
    private PnlInfoJuego pnlInfoJuego;

    public HiloTiempo(PnlInfoJuego panelInfo) {
        this.pnlInfoJuego = panelInfo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public String getTiempo() {
        return tiempo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public void run() {
        while (true) {
            try {
                for (int minutos = 0; minutos < 10; minutos++) {
                    for (int segundos = 0; segundos < 60; segundos++) {
                        if (segundos < 10) {
                            this.tiempo = minutos + ":0" + segundos;
                        } else {
                            this.tiempo = minutos + ":" + segundos;
                        }
                        this.sleep(1000);
                        pnlInfoJuego.setLblTiempo(tiempo);
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }

}
