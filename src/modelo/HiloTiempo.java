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
    private final Jugador jugador;

    public HiloTiempo(PnlInfoJuego panelInfo, Jugador jugador) {
        this.pnlInfoJuego = panelInfo;
        this.jugador = jugador;
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
                        this.sleep(1063);
                        pnlInfoJuego.setLblTiempo(tiempo);
                    }
                    segTemp = 0;
                    jugador.setVidas(jugador.getVidas() - 1);
                    if (jugador.getIsFirstPlayer()) {
                        jugador.setPosX(670);
                        jugador.setPosY(578);
                    } else {
                        jugador.setPosX(150);
                        jugador.setPosY(95);
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }

}
