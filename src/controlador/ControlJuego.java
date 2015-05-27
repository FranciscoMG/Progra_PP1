/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import modelo.RegistroJuego;
import vista.GUIJuego;
import vista.GUIOpciones;
import vista.PanelJuego;
import vista.PnlInfoJuego;

/**
 *
 * @author francisco
 */
public class ControlJuego implements ActionListener, KeyListener, MouseListener {

    private GUIJuego guiJuego;
    private PanelJuego panelJuego;
    private PnlInfoJuego panelInfo;
    private RegistroJuego registroJuego;

    public ControlJuego(GUIJuego guiJuego, PanelJuego panelJuego, PnlInfoJuego panelInfo, RegistroJuego registroJuego) {
        this.panelJuego = panelJuego;
        this.panelJuego.addKeyListener(this);
        this.panelJuego.setFocusable(true);
        this.guiJuego = guiJuego;
        this.panelInfo = panelInfo;
        this.registroJuego = registroJuego;
        registroJuego.iniciaJuegoNuevo(panelJuego, this.panelInfo);
        registroJuego.iniciarTiempo();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.registroJuego.dispara();
        }
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            this.registroJuego.movJugAba();
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.registroJuego.movJugIzq(-1, true);
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.registroJuego.movJugDer(1, true);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.registroJuego.movJugIzq(0, false);
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.registroJuego.movJugDer(0, false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(PnlInfoJuego.BTN_GUARDAR)) {
            try {
                this.registroJuego.guardarPartida();
            } catch (IOException ex) {
            }
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlInfoJuego.BTN_NUEVA)) {
            if (GUIJuego.mensaje("Se cerrará la sesión de juego actual y se perderá el progreso\n¿Deseas iniciar un nuevo juego?", true, 1) == 0) {
                GUIOpciones guiOpciones = new GUIOpciones(true, this.panelInfo.getLblNombreUsuario());
                guiOpciones.setVisible(true);
                this.guiJuego.dispose();
                this.registroJuego.detenerHilos();
            }
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlInfoJuego.BTN_CARGAR)) {
            if (GUIJuego.mensaje("¿Deseas cargar una partida?", true, 1) == 0) {
                GUIOpciones guiOpciones = new GUIOpciones(false, this.panelInfo.getLblNombreUsuario());
                guiOpciones.setVisible(true);
                this.guiJuego.dispose();
                this.registroJuego.detenerHilos();
            }
        }
        if (e.getActionCommand().equalsIgnoreCase(PnlInfoJuego.BTN_SALIR)) {
            if (GUIJuego.mensaje("Se cerrará la sesión de juego actual y se perderá el progreso\n¿Deseas salir del juego?", true, 1) == 0) {
                System.exit(0);
            }
        }
    }

    public void mouseClicked(MouseEvent me) {
        System.err.println("x " + me.getX() + " y " + me.getY());
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }
}
