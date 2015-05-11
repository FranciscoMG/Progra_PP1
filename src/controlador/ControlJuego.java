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
import modelo.RegistroJuego;
import vista.GUIJuego;
import vista.PanelJuego;
import vista.PnlInfoJuego;

/**
 *
 * @author francisco
 */
public class ControlJuego implements ActionListener, KeyListener {

    private GUIJuego guiJuego;
    private PnlInfoJuego panelInfo;
    private RegistroJuego registroJuego;

    public ControlJuego(GUIJuego guiJuego, PanelJuego panelJuego, PnlInfoJuego panelInfo) {
        panelJuego.addKeyListener(this);
        panelJuego.setFocusable(true);
        this.guiJuego = guiJuego;
        this.panelInfo = panelInfo;
        this.registroJuego = new RegistroJuego(panelJuego, this.panelInfo);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

        }
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            this.registroJuego.movJugAba();
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.registroJuego.movJugIzq();
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.registroJuego.movJugDer();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
    }

}
