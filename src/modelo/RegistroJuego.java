/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.util.ArrayList;
import vista.GUIJuego;
import vista.PanelJuego;
import vista.PnlInfoJuego;

/**
 *
 * @author francisco
 */
public class RegistroJuego {

    private PanelJuego panelJuego;
    private PnlInfoJuego panelInfo;
    private Jugador jugador;
    private HiloJugador hiloJugador;
    private ArrayList<Tortuga> tortugas = new ArrayList<>();
    private ArrayList<HiloTortuga> hiloTortugas = new ArrayList<>();

    private HiloTiempo hiloTiempo;

    public RegistroJuego(PanelJuego panelJuego, PnlInfoJuego panelInfo) {
        this.panelJuego = panelJuego;
        this.panelInfo = panelInfo;
        try {
            jugador = new Jugador(3, 670, 578);
            tortugas.add(new Tortuga(1, 6, 423, 6, 248));
            tortugas.add(new Tortuga(1, 514, 423, 514, 756));
            tortugas.add(new Tortuga(1, 193, 263, 193, 569));
        } catch (IOException ex) {
            GUIJuego.mensaje("Ha ocurrido un error al cargar el juego", 0);
        }
        panelJuego.setJugador(jugador);
        hiloJugador = new HiloJugador(panelJuego, jugador);
        hiloJugador.start();
        panelJuego.setTortuga(tortugas);
        for (int i = 0; i < tortugas.size(); i++) {
            hiloTortugas.add(new HiloTortuga(panelJuego, tortugas.get(i)));
            hiloTortugas.get(i).start();
        }
    }

    public void movJugAba() {
        HiloJugador.direccionY = -1;
    }

    public void movJugIzq() {
        HiloJugador.direccionX = -1;
        this.jugador.setImgPers(jugador.imgPersIzq);
    }

    public void movJugDer() {
        HiloJugador.direccionX = 1;
        this.jugador.setImgPers(jugador.imgPersDer);
    }

    /////////////////////////////////////////////////////////////////////////
     public void iniciarTiempo () {
         hiloTiempo = new HiloTiempo(panelInfo);
         hiloTiempo.iniciarRelog();
         hiloTiempo.start();
     }

}
