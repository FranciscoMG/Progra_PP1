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
import modelo.RegistroJuego;
import vista.GUIJuego;
import vista.PanelJuego;
import vista.PnlInfoJuego;

/**
 *
 * @author francisco
 */
public class ControlJuego implements ActionListener, KeyListener ,MouseListener {

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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.registroJuego.dispara();
        }    
        if (e.getKeyCode()== KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            this.registroJuego.movJugAba();
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.registroJuego.movJugIzq(-1);
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.registroJuego.movJugDer(1);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            this.registroJuego.movJugAba();
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.registroJuego.movJugIzq(0);
             }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.registroJuego.movJugDer(0);
        }   
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(PnlInfoJuego.BTN_NUEVA)) {
            registroJuego.iniciarTiempo();
        }
    }

    public void mouseClicked(MouseEvent me) {
        System.err.println("x "+me.getX()+" y "+me.getY());
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
