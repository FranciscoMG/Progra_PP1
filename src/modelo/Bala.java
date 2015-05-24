/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author vini
 */
public class Bala extends Canvas {
    
    private int x;
    private int y;
    private Image imagen;

    public Bala(int x, int y) {
        this.x = x;
        this.y = y;
        this.imagen = new ImageIcon(getClass().getResource("/img/bala.gif")).getImage();
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getX () {
        return this.x;
    }
    
    public int getY () {
        return this.y;
    }
    
    public void pintarBala (Graphics g) {
        g.drawImage(imagen, this.getX(), this.getY(), 50, 50, this);
    }
    
}
