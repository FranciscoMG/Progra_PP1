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

    private int minutos;
    private int segundos;
    private String tiempo;
    private PnlInfoJuego pnlInfoJuego;

    public HiloTiempo(PnlInfoJuego panelInfo) {
        this.pnlInfoJuego = panelInfo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public void setTiempo(String tiempo) {
        String[] divTiempo = tiempo.split(":");
        this.minutos = Integer.parseInt(divTiempo[0]);
        this.segundos = Integer.parseInt(divTiempo[1]);
        this.tiempo = tiempo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public String getTiempo() {
        return tiempo;
    }

    ///////////////////////////////////////////////////////////////////////////
    public void run() {
        int minTemp = minutos;
        int segTemp = segundos;
        while (true) {
            try {
                for (int minutos = minTemp; minutos < 10; minutos++) {
                    for (int segundos = segTemp; segundos < 60; segundos++) {
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
