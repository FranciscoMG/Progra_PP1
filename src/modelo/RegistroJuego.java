/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    public void asignaPaneles(PanelJuego panelJuego, PnlInfoJuego panelInfo) {
        this.panelJuego = panelJuego;
        this.panelInfo = panelInfo;
    }

    public void iniciarJuegoNuevo() {
        try {
            alas = new Alas(0, 0);
            alas.setImgPers(alas.imgPersIzq);
            this.bala = new Bala(-100, -100);
            jugador = new Jugador(3, 670, 578);
            panelJuego.setJugador(jugador);
            panelJuego.setAlas(alas);
            hiloJugador = new HiloJugador(panelJuego, jugador, alas);
            hiloJugador.start();
            tortugas.add(new Tortuga(1, 6, 423, 6, 248));
            tortugas.add(new Tortuga(1, 514, 423, 514, 756));
            tortugas.add(new Tortuga(1, 193, 263, 193, 569));
            panelJuego.setTortuga(tortugas);
            for (int i = 0; i < tortugas.size(); i++) {
                hiloTortugas.add(new HiloTortuga(panelJuego, tortugas.get(i)));
                hiloTortugas.get(i).start();
            }
            hiloPlataformas = new HiloPlataformas(jugador, hiloJugador);
            hiloPlataformas.start();
            hiloColicionador = new HiloColisionador(panelInfo, tortugas, jugador);
            hiloColicionador.start();
            panelJuego.setBala(bala);
            this.hiloBala = new HiloBala(100, 100, bala, jugador, panelJuego);
            this.hiloBala.start();
            this.hiloColisionDisparo = new HiloColisionDisparo(bala, tortugas, hiloTortugas);
            this.hiloColisionDisparo.start();
            this.hiloColisionGanoPrimerJugador = new HiloColisionGanoPrimerJugador(panelJuego, jugador);
            this.hiloColisionGanoPrimerJugador.start();
            panelInfo.setLblVida(String.valueOf(jugador.getVidas()));
        } catch (Exception ex) {
            GUIJuego.mensaje("Ha ocurrido un error al cargar el juego", 0, 0);
        }
    }

    public void cargarPartida(String nombrePartida) {
        Element partidaCargada = buscarPartida("nombre-partida", nombrePartida).get(0);
        try {
            alas = new Alas(0, 0);
            alas.setImgPers(alas.imgPersIzq);
            this.bala = new Bala(-100, -100);
            jugador = new Jugador(Integer.parseInt(partidaCargada.getChildText("vidas")), Integer.parseInt(partidaCargada.getChildText("pos-x")), Integer.parseInt(partidaCargada.getChildText("pos-y")));
            jugador.setIsFirstPlayer(Boolean.parseBoolean(partidaCargada.getChildText("jugador")));
            panelJuego.setJugador(jugador);
            panelJuego.setAlas(alas);
            hiloJugador = new HiloJugador(panelJuego, jugador, this.alas);
            hiloJugador.start();
            if (jugador.getIsFirstPlayer()) {
                if (jugador.getLado()) {
                    jugador.setImgPers(jugador.imgPersDer);
                } else {
                    jugador.setImgPers(jugador.imgPersIzq);
                }
            } else {
                if (jugador.getLado()) {
                    jugador.setImgPers(jugador.imgPersDer2);
                } else {
                    jugador.setImgPers(jugador.imgPersIzq2);
                }
            }
            List<Element> listaTortugas = partidaCargada.getChildren("tortuga");
            for (int i = 0; i < listaTortugas.size(); i++) {
                if (Integer.parseInt(listaTortugas.get(i).getChildText("pos-x")) < 249 && Integer.parseInt(listaTortugas.get(i).getChildText("pos-y")) == 423) {
                    tortugas.add(new Tortuga(1, Integer.parseInt(listaTortugas.get(i).getChildText("pos-x")), 423, 6, 248));
                } else {
                    if (Integer.parseInt(listaTortugas.get(i).getChildText("pos-y")) == 423) {
                        tortugas.add(new Tortuga(1, Integer.parseInt(listaTortugas.get(i).getChildText("pos-x")), 423, 514, 756));
                    }
                }
                if (Integer.parseInt(listaTortugas.get(i).getChildText("pos-y")) == 263) {
                    tortugas.add(new Tortuga(1, Integer.parseInt(listaTortugas.get(i).getChildText("pos-x")), 263, 193, 569));
                }
                if (Boolean.parseBoolean(listaTortugas.get(i).getChildText("lado")) == true) {
                    tortugas.get(i).setImgPers(tortugas.get(i).imgPersIzq);
                } else {
                    tortugas.get(i).setImgPers(tortugas.get(i).imgPersDer);
                }
            }
            panelJuego.setTortuga(tortugas);
            for (int i = 0; i < tortugas.size(); i++) {
                hiloTortugas.add(new HiloTortuga(panelJuego, tortugas.get(i)));
                if (hiloTortugas.get(i).tortuga.getLado()) {
                    hiloTortugas.get(i).direccionX = 1;
                } else {
                    hiloTortugas.get(i).direccionX = -1;
                }
                hiloTortugas.get(i).start();
            }
            hiloPlataformas = new HiloPlataformas(jugador, hiloJugador);
            hiloPlataformas.start();
            hiloColicionador = new HiloColisionador(panelInfo, tortugas, jugador);
            hiloColicionador.start();
            panelJuego.setBala(bala);
            this.hiloBala = new HiloBala(100, 100, bala, jugador, panelJuego);
            this.hiloBala.start();
            this.hiloColisionDisparo = new HiloColisionDisparo(bala, tortugas, hiloTortugas);
            this.hiloColisionDisparo.start();
            this.hiloColisionGanoPrimerJugador = new HiloColisionGanoPrimerJugador(panelJuego, jugador);
            this.hiloColisionGanoPrimerJugador.start();
            panelInfo.setLblVida(String.valueOf(jugador.getVidas()));
            hiloTiempo = new HiloTiempo(panelInfo, jugador);
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
        eNombrePartida.addContent("Partida" + (raiz.getChildren().size() + 1) + "(" + System.nanoTime() + ")");
        eTiempo.addContent(this.panelInfo.getLblTiempo());
        eJug.addContent(String.valueOf(jugador.getIsFirstPlayer()));
        eJugVidas.addContent(String.valueOf(jugador.getVidas()));
        eJugPosX.addContent(String.valueOf(jugador.getPosX()));
        eJugPosY.addContent(String.valueOf(jugador.getPosY()));
        eJugLado.addContent(String.valueOf(jugador.getLado()));
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
        this.jugador.setLado(false);
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
        this.jugador.setLado(true);
    }

    /////////////////////////////////////////////////////////////////////////
    public void iniciarTiempo() {
        hiloTiempo = new HiloTiempo(panelInfo, jugador);
        hiloTiempo.start();
    }

    /////////////////////////////////////////////////////////////////////////
    public void dispara() {
        hiloBala.setDisparar(true);
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
