/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControlJuego;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public PnlInfoJuego panelInfo;
    private Jugador jugador;
    private HiloJugador hiloJugador;
    private ArrayList<Tortuga> tortugas = new ArrayList<>();
    private ArrayList<HiloTortuga> hiloTortugas = new ArrayList<>();
    public HiloTiempo hiloTiempo;
    private HiloColisionador hiloColicionador;
    private Bala bala;
    private HiloBala hiloBala;
    private HiloColisionDisparo hiloColisionDisparo;
    private HiloPlataformas hiloPlataformas;
    private HiloColisionGanoPrimerJugador hiloColisionGanoPrimerJugador;
    private ControlJuego controlJuego;
    private Document documento;
    private Element raiz;
    private String ruta;
    private Alas alas;

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

    public void asignaPaneles(PanelJuego panelJuego, PnlInfoJuego panelInfo, ControlJuego controlJuego) {
        this.panelJuego = panelJuego;
        this.panelInfo = panelInfo;
        this.controlJuego = controlJuego;
    }

    public void iniciarJuegoNuevo() {
        try {
            this.alas = new Alas(0, 0);
            this.alas.setImgPers(this.alas.imgPersIzq);
            this.bala = new Bala(-100, -100);
            this.jugador = new Jugador(3, 670, 578);
            this.panelJuego.setJugador(this.jugador);
            this.panelJuego.setAlas(this.alas);
            this.hiloJugador = new HiloJugador(panelJuego, this.jugador, this.alas);
            this.hiloJugador.start();
            this.tortugas.add(new Tortuga(1, 6, 423, 6, 248));
            this.tortugas.add(new Tortuga(1, 514, 423, 514, 756));
            this.tortugas.add(new Tortuga(1, 193, 263, 193, 569));
            panelJuego.setTortuga(this.tortugas);
            for (int i = 0; i < this.tortugas.size(); i++) {
                this.hiloTortugas.add(new HiloTortuga(panelJuego, this.tortugas.get(i)));
                this.hiloTortugas.get(i).start();
            }
            this.hiloPlataformas = new HiloPlataformas(this.jugador, this.hiloJugador);
            this.hiloPlataformas.start();
            this.hiloColicionador = new HiloColisionador(panelInfo, this.tortugas, this.jugador, controlJuego);
            this.hiloColicionador.start();
            this.panelJuego.setBala(this.bala);
            this.hiloBala = new HiloBala(100, 100, this.bala, this.jugador, panelJuego);
            this.hiloBala.start();
            this.hiloColisionDisparo = new HiloColisionDisparo(this.bala, this.tortugas, this.hiloTortugas);
            this.hiloColisionDisparo.start();
            this.hiloColisionGanoPrimerJugador = new HiloColisionGanoPrimerJugador(panelJuego, this.jugador, controlJuego);
            this.hiloColisionGanoPrimerJugador.start();
            panelInfo.setLblVida(String.valueOf(jugador.getVidas()));
        } catch (Exception ex) {
            GUIJuego.mensaje("Ha ocurrido un error al cargar el juego", 0, 0);
        }
    }

    public void cargarPartida(String nombrePartida) {
        Element partidaCargada = buscarPartida("nombre-partida", nombrePartida).get(0);
        try {
            this.alas = new Alas(0, 0);
            this.alas.setImgPers(this.alas.imgPersIzq);
            this.bala = new Bala(-100, -100);
            this.jugador = new Jugador(Integer.parseInt(partidaCargada.getChildText("vidas")), Integer.parseInt(partidaCargada.getChildText("pos-x")), Integer.parseInt(partidaCargada.getChildText("pos-y")));
            this.jugador.setIsFirstPlayer(Boolean.parseBoolean(partidaCargada.getChildText("jugador")));
            this.panelJuego.setJugador(this.jugador);
            this.panelJuego.setAlas(this.alas);
            this.hiloJugador = new HiloJugador(panelJuego, this.jugador, this.alas);
            this.hiloJugador.start();
            if (this.jugador.getIsFirstPlayer()) {
                if (this.jugador.getLado()) {
                    this.jugador.setImgPers(this.jugador.imgPersDer);
                } else {
                    this.jugador.setImgPers(this.jugador.imgPersIzq);
                }
            } else {
                if (this.jugador.getLado()) {
                    this.jugador.setImgPers(this.jugador.imgPersDer2);
                } else {
                    this.jugador.setImgPers(this.jugador.imgPersIzq2);
                }
            }
            List<Element> listaTortugas = partidaCargada.getChildren("tortuga");
            for (int i = 0; i < listaTortugas.size(); i++) {
                if (Integer.parseInt(listaTortugas.get(i).getChildText("pos-x")) < 249 && Integer.parseInt(listaTortugas.get(i).getChildText("pos-y")) == 423) {
                    this.tortugas.add(new Tortuga(1, Integer.parseInt(listaTortugas.get(i).getChildText("pos-x")), 423, 6, 248));
                } else {
                    if (Integer.parseInt(listaTortugas.get(i).getChildText("pos-y")) == 423) {
                        this.tortugas.add(new Tortuga(1, Integer.parseInt(listaTortugas.get(i).getChildText("pos-x")), 423, 514, 756));
                    }
                }
                if (Integer.parseInt(listaTortugas.get(i).getChildText("pos-y")) == 263) {
                    this.tortugas.add(new Tortuga(1, Integer.parseInt(listaTortugas.get(i).getChildText("pos-x")), 263, 193, 569));
                }
                if (Boolean.parseBoolean(listaTortugas.get(i).getChildText("lado")) == true) {
                    this.tortugas.get(i).setImgPers(tortugas.get(i).imgPersIzq);
                } else {
                    this.tortugas.get(i).setImgPers(tortugas.get(i).imgPersDer);
                }
            }
            panelJuego.setTortuga(this.tortugas);
            for (int i = 0; i < this.tortugas.size(); i++) {
                this.hiloTortugas.add(new HiloTortuga(panelJuego, this.tortugas.get(i)));
                if (this.hiloTortugas.get(i).tortuga.getLado()) {
                    this.hiloTortugas.get(i).direccionX = 1;
                } else {
                    this.hiloTortugas.get(i).direccionX = -1;
                }
                hiloTortugas.get(i).start();
            }
            this.hiloPlataformas = new HiloPlataformas(jugador, this.hiloJugador);
            this.hiloPlataformas.start();
            this.hiloColicionador = new HiloColisionador(panelInfo, this.tortugas, this.jugador, controlJuego);
            this.hiloColicionador.start();
            this.panelJuego.setBala(this.bala);
            this.hiloBala = new HiloBala(100, 100, this.bala, this.jugador, panelJuego);
            this.hiloBala.start();
            this.hiloColisionDisparo = new HiloColisionDisparo(this.bala, this.tortugas, this.hiloTortugas);
            this.hiloColisionDisparo.start();
            this.hiloColisionGanoPrimerJugador = new HiloColisionGanoPrimerJugador(panelJuego, this.jugador, controlJuego);
            this.hiloColisionGanoPrimerJugador.start();
            panelInfo.setLblVida(String.valueOf(jugador.getVidas()));
            this.hiloTiempo = new HiloTiempo(panelInfo, this.jugador);
            this.hiloTiempo.setTiempo(partidaCargada.getChildText("tiempo"));
            this.hiloTiempo.start();
        } catch (Exception ex) {
            GUIJuego.mensaje("Ha ocurrido un error al cargar el juego", 0, 0);
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
        Element eNombrePartida = new Element("nombre-partida");
        Element eTiempo = new Element("tiempo");
        Element eJug = new Element("jugador");
        Element eJugVidas = new Element("vidas");
        Element eJugPosX = new Element("pos-x");
        Element eJugPosY = new Element("pos-y");
        Element eJugLado = new Element("lado-jugador");
        eNombrePartida.addContent("Partida" + (raiz.getChildren().size() + 1) + " (" + String.valueOf(new Date().getDate()) + "/" + String.valueOf(new Date().getMonth() + 1) + "/" + String.valueOf(new Date().getYear() + 1900) + " " + String.valueOf(new Date().getHours()) + ":" + String.valueOf(new Date().getMinutes()) + ":" + String.valueOf(new Date().getSeconds()) + ")");
        eTiempo.addContent(panelInfo.getLblTiempo());
        eJug.addContent(String.valueOf(this.jugador.getIsFirstPlayer()));
        eJugVidas.addContent(String.valueOf(this.jugador.getVidas()));
        eJugPosX.addContent(String.valueOf(this.jugador.getPosX()));
        eJugPosY.addContent(String.valueOf(this.jugador.getPosY()));
        eJugLado.addContent(String.valueOf(this.jugador.getLado()));
        ePartida.setAttribute(aUsuario);
        ePartida.addContent(eNombrePartida);
        ePartida.addContent(eTiempo);
        ePartida.addContent(eJug);
        ePartida.addContent(eJugVidas);
        ePartida.addContent(eJugPosX);
        ePartida.addContent(eJugPosY);
        ePartida.addContent(eJugLado);
        for (HiloTortuga hiloTortuga : hiloTortugas) {
            if (hiloTortuga.isAlive()) {
                Element eTortuga = new Element("tortuga");
                Element eLado = new Element("lado");
                Element eTorPosX = new Element("pos-x");
                Element eTorPosY = new Element("pos-y");
                eLado.addContent(String.valueOf(hiloTortuga.tortuga.getLado()));
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
        if (this.hiloJugador.salto == false && this.hiloJugador.caida == false) {
            this.hiloJugador.altura = 0;
            this.hiloJugador.salto = true;
        }
    }

    public void movJugIzq(int x, boolean camina) {
        this.hiloJugador.setDireccionX(x);
        if (this.jugador.getIsFirstPlayer()) {
            if (camina == true) {
                this.jugador.setImgPers(this.jugador.imgPersIzqMov);
            } else {
                this.jugador.setImgPers(this.jugador.imgPersIzq);
            }
        } else {
            if (camina == true) {
                this.jugador.setImgPers(this.jugador.imgPersIzq2Mov);
            } else {
                this.jugador.setImgPers(this.jugador.imgPersIzq2);
            }
        }
        this.jugador.setLado(false);
    }

    public void movJugDer(int x, boolean camina) {
        this.hiloJugador.setDireccionX(x);
        if (jugador.getIsFirstPlayer()) {
            if (camina == true) {
                this.jugador.setImgPers(this.jugador.imgPersDerMov);
            } else {
                this.jugador.setImgPers(this.jugador.imgPersDer);
            }
        } else {
            if (camina == true) {
                this.jugador.setImgPers(this.jugador.imgPersDer2Mov);
            } else {
                this.jugador.setImgPers(this.jugador.imgPersDer2);
            }
        }
        this.jugador.setLado(true);
    }

    /////////////////////////////////////////////////////////////////////////
    public void iniciarTiempo() {
        this.hiloTiempo = new HiloTiempo(panelInfo, this.jugador);
        this.hiloTiempo.start();
    }

    /////////////////////////////////////////////////////////////////////////
    public void dispara() {
        this.hiloBala.setDisparar(true);
    }

    public List<Element> buscarPartida(String filtro, String nombreFiltro) {
        List<Element> listaPartidas = (List<Element>) this.raiz.getChildren();
        List<Element> partidasJugador = new ArrayList<>();
        for (Element elemento : listaPartidas) {
            if (filtro.equalsIgnoreCase("usuario")) {
                if (elemento.getAttributeValue(filtro).equals(nombreFiltro)) {
                    partidasJugador.add(elemento);
                }
            }
            if (filtro.equalsIgnoreCase("nombre-partida")) {
                if (elemento.getChildText(filtro).equals(nombreFiltro)) {
                    partidasJugador.add(elemento);
                }
            }
        }
        return partidasJugador;
    }

    public ArrayList<String> getPartidas(String nombreUsuario) {
        ArrayList<String> listaPartidas = new ArrayList<>();
        List<Element> listaPartidasXml = buscarPartida("usuario", nombreUsuario);
        for (Element elementos : listaPartidasXml) {
            listaPartidas.add(elementos.getChildText("nombre-partida"));
        }
        return listaPartidas;
    }

    public void detenerHilos() {
        this.hiloJugador.direccionX = 0;
        this.hiloJugador.stop();
        for (int i = tortugas.size() - 1; i >= 0; i--) {
            this.hiloTortugas.get(i).stop();
            this.hiloTortugas.remove(i);
            this.tortugas.remove(i);
        }
        this.hiloPlataformas.stop();
        this.hiloColicionador.stop();
        this.hiloBala.stop();
        this.hiloColisionDisparo.stop();
        this.hiloColisionGanoPrimerJugador.stop();
    }
}
