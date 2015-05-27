/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
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
    private HiloColisionador hiloColicionador;
    private Bala bala;
    private HiloBala hiloBala;
    private HiloColisionDisparo hiloColisionDisparo;
    private HiloPlataformas hiloPlataformas;
    private HiloColisionGanoPrimerJugador hiloColisionGanoPrimerJugador;
    public Document documento;
    public Element raiz;
    public String ruta;

    private RegistroJuego(String ruta, String raiz) throws IOException {
        this.ruta = ruta;
        this.raiz = new Element(raiz);
        this.documento = new Document(this.raiz);
        this.guardaDocumento();
    }

    private RegistroJuego(String ruta) throws JDOMException, IOException {
        SAXBuilder sBuilder = new SAXBuilder();
        sBuilder.setIgnoringElementContentWhitespace(true);
        this.documento = sBuilder.build(ruta);
        this.raiz = documento.getRootElement();
        this.ruta = ruta;
    }

    public static RegistroJuego abrirDocumento(String nombre) throws JDOMException, IOException {
        return new RegistroJuego(nombre);
    }

    public static RegistroJuego crearDocumento(String nombre) throws IOException {
        return new RegistroJuego(nombre, "partidas");
    }

    public void iniciaJuegoNuevo(PanelJuego panelJuego, PnlInfoJuego panelInfo) {
        this.panelJuego = panelJuego;
        this.panelInfo = panelInfo;
        try {
            this.bala = new Bala(-100, -100);
            jugador = new Jugador(3, 670, 578);
            tortugas.add(new Tortuga(1, 6, 423, 6, 248));
            tortugas.add(new Tortuga(1, 514, 423, 514, 756));
            tortugas.add(new Tortuga(1, 193, 263, 193, 569));

            panelJuego.setJugador(jugador);
            hiloJugador = new HiloJugador(panelJuego, jugador);
            hiloJugador.start();
            panelJuego.setTortuga(tortugas);
            for (int i = 0; i < tortugas.size(); i++) {
                hiloTortugas.add(new HiloTortuga(panelJuego, tortugas.get(i)));
                hiloTortugas.get(i).start();
            }

            hiloPlataformas = new HiloPlataformas(jugador, hiloJugador);
            hiloPlataformas.start();

            hiloColicionador = new HiloColisionador(tortugas, jugador);
            hiloColicionador.start();

            panelJuego.setBala(bala);
            this.hiloBala = new HiloBala(100, 100, bala, jugador, panelJuego);
            this.hiloBala.start();

            this.hiloColisionDisparo = new HiloColisionDisparo(bala, tortugas, hiloTortugas);
            this.hiloColisionDisparo.start();

            this.hiloColisionGanoPrimerJugador = new HiloColisionGanoPrimerJugador(panelJuego, jugador);
            this.hiloColisionGanoPrimerJugador.start();
        } catch (Exception ex) {
            GUIJuego.mensaje("Ha ocurrido un error al cargar el juego", false, 0);
        }
    }

    public void guardaDocumento() throws IOException {
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.output(documento, System.out);
        xmlOutput.output(documento, new PrintWriter(this.ruta));
    }

    public void guardarPartida() throws IOException {
        Element ePartida = new Element("partida");
        Attribute aUsuario = new Attribute("usuario", this.panelInfo.getLblNombreUsuario());
        Element eTiempo = new Element("tiempo");
        Element eJug = new Element("jugador");
        Element eJugPosX = new Element("pos-x");
        Element eJugPosY = new Element("pos-y");
        eTiempo.addContent(this.panelInfo.getLblTiempo());
        eJug.addContent(String.valueOf(jugador.getIsFirstPlayer()));
        eJugPosX.addContent(String.valueOf(jugador.getPosX()));
        eJugPosY.addContent(String.valueOf(jugador.getPosY()));
        ePartida.setAttribute(aUsuario);
        ePartida.addContent(eTiempo);
        ePartida.addContent(eJug);
        ePartida.addContent(eJugPosX);
        ePartida.addContent(eJugPosY);
        for (HiloTortuga hiloTortuga : hiloTortugas) {
            if (hiloTortuga.isAlive()) {
                Element eTortuga = new Element("tortuga");
                Element eLado = new Element("lado");
                Element eTorPosX = new Element("pos-x");
                Element eTorPosY = new Element("pos-y");
                eLado.addContent(String.valueOf(hiloTortuga.lado));
                eTorPosX.addContent(String.valueOf(hiloTortuga.tortuga.getPosX()));
                eTorPosY.addContent(String.valueOf(hiloTortuga.tortuga.getPosY()));
                eTortuga.addContent(eLado);
                eTortuga.addContent(eTorPosX);
                eTortuga.addContent(eTorPosY);
                ePartida.addContent(eTortuga);
            }
        }
        this.raiz.addContent(ePartida);
        this.guardaDocumento();
    }

    public void movJugAba() {
        if (hiloJugador.salto == false && hiloJugador.caida == false) {
            hiloJugador.altura = 0;
            hiloJugador.salto = true;
        }
    }

    public void movJugIzq(int x, boolean camina) {
        hiloJugador.setDireccionX(x);
        if (jugador.getIsFirstPlayer()) {
            if (camina == true) {
                this.jugador.setImgPers(jugador.imgPersIzqMov);
            } else {
                this.jugador.setImgPers(jugador.imgPersIzq);
            }
        } else {
            if (camina == true) {
                this.jugador.setImgPers(jugador.imgPersIzq2Mov);
            } else {
                this.jugador.setImgPers(jugador.imgPersIzq2);
            }
        }
        this.jugador.setDerecha(false);
    }

    public void movJugDer(int x, boolean camina) {
        hiloJugador.setDireccionX(x);
        if (jugador.getIsFirstPlayer()) {
            if (camina == true) {
                this.jugador.setImgPers(jugador.imgPersDerMov);
            } else {
                this.jugador.setImgPers(jugador.imgPersDer);
            }
        } else {
            if (camina == true) {
                this.jugador.setImgPers(jugador.imgPersDer2Mov);
            } else {
                this.jugador.setImgPers(jugador.imgPersDer2);
            }
        }
        this.jugador.setDerecha(true);
    }

    public void cargarPartida() {

    }

    /////////////////////////////////////////////////////////////////////////
    public void iniciarTiempo() {
        hiloTiempo = new HiloTiempo(panelInfo);
        hiloTiempo.start();
    }

    /////////////////////////////////////////////////////////////////////////
    public void dispara() {
        hiloBala.setDisparar(true);
    }

    public void detenerHilos() {
        hiloJugador.stop();
        for (int i = 0; i < tortugas.size(); i++) {
            hiloTortugas.get(i).stop();
        }
        this.hiloPlataformas.stop();
        this.hiloColicionador.stop();
        this.hiloBala.stop();
        this.hiloColisionDisparo.stop();
        this.hiloColisionGanoPrimerJugador.stop();
    }
}
