/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import modelo.RegistroUsuario;
import modelo.Usuario;
import org.jdom2.JDOMException;
import vista.GUIJuego;
import vista.GUIOpciones;
import vista.PanelOpciones;

/**
 *
 * @author francisco
 */
public class ControlOpciones implements ActionListener {

    private GUIOpciones guiOpciones;
    private PanelOpciones panelOpciones;
    private RegistroUsuario registroUsuario;

    public ControlOpciones(GUIOpciones guiOpciones, PanelOpciones panelOpciones) {
        this.guiOpciones = guiOpciones;
        this.panelOpciones = panelOpciones;
        File existeXml = new File("usuarios.xml");
        if (existeXml.exists()) {
            try {
                registroUsuario = RegistroUsuario.abrirDocumento("usuarios.xml");
            } catch (JDOMException | IOException ex) {
                GUIOpciones.mensaje("Ha ocurrido un error al obtener la lista de los usuarios", 0);
                System.exit(0);
            }
        } else {
            try {
                registroUsuario = RegistroUsuario.crearDocumento("usuarios.xml");
            } catch (IOException ex) {
            }
        }
        panelOpciones.setCboUsuarios(registroUsuario.getUsuarios());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(PanelOpciones.BTN_EMPEZAR)) {
            if (panelOpciones.getRbExistente() || panelOpciones.getRbNuevo()) {
                Usuario usuarioEscogido = registroUsuario.getUsuario(panelOpciones.getCboUsuarios());
                if (panelOpciones.getRbNuevo() && panelOpciones.getTxtNuevo() == null) {
                    GUIOpciones.mensaje("El campo Nuevo usuario no puede estar vacío", 2);
                    usuarioEscogido = null;
                } else {
                    if (panelOpciones.getRbNuevo()) {
                        try {
                            usuarioEscogido = new Usuario(panelOpciones.getTxtNuevo(), null);
                            if (!registroUsuario.agregarUsuario(usuarioEscogido)) {
                                GUIOpciones.mensaje("El usuario ya esta registrado, por favor seleccione otro nombre", 1);
                            }
                        } catch (IOException ex) {
                        }
                    }
                }
                if (usuarioEscogido != null) {
                    GUIJuego guiJuego = new GUIJuego(usuarioEscogido);
                    guiJuego.setVisible(true);
                    guiOpciones.dispose();
                }
            } else {
                GUIOpciones.mensaje("Seleccione una opción para empezar el juego", 1);
            }
        }
        if (e.getActionCommand().equalsIgnoreCase(PanelOpciones.BTN_SALIR)) {
            System.exit(0);
        }
    }

}
