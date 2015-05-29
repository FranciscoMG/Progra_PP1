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
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author francisco
 */
public class RegistroUsuario {

    private Document documento;
    private Element raiz;
    private String rutaDocumento;

    private RegistroUsuario(String rutaDocumento, String nombreRaiz) throws IOException {
        this.rutaDocumento = rutaDocumento;
        this.raiz = new Element(nombreRaiz);
        this.documento = new Document(this.raiz);
        this.guardarDocumento();
    }

    private RegistroUsuario(String rutaDocumento) throws JDOMException, IOException {
        SAXBuilder saBuilder = new SAXBuilder();
        saBuilder.setIgnoringElementContentWhitespace(true);
        this.documento = saBuilder.build(rutaDocumento);
        this.raiz = documento.getRootElement();
        this.rutaDocumento = rutaDocumento;
    }

    public static RegistroUsuario crearDocumento(String nombreDocumento) throws IOException {
        return new RegistroUsuario(nombreDocumento, "usuarios");
    }

    public static RegistroUsuario abrirDocumento(String nombreDocumento) throws JDOMException, IOException {
        return new RegistroUsuario(nombreDocumento);
    }

    public void guardarDocumento() throws IOException {
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(documento, System.out);
        xmlOutputter.output(documento, new PrintWriter(this.rutaDocumento));
    }

    public boolean agregarUsuario(Usuario usuario) throws IOException {
        if (buscarUsuario(usuario.getNombre()) == null) {
            Element eUsuario = new Element("usuario");
            Element eNombre = new Element("nombre");
            Element eMT1 = new Element("MT1");
            Element eMT2 = new Element("MT2");
            Element eMT3 = new Element("MT3");
            Element eMT4 = new Element("MT4");
            eNombre.addContent(usuario.getNombre());
            eMT1.addContent(usuario.getMejoresTiempos()[0]);
            eMT2.addContent(usuario.getMejoresTiempos()[1]);
            eMT3.addContent(usuario.getMejoresTiempos()[2]);
            eMT4.addContent(usuario.getMejoresTiempos()[3]);
            eUsuario.addContent(eNombre);
            eUsuario.addContent(eMT1);
            eUsuario.addContent(eMT2);
            eUsuario.addContent(eMT3);
            eUsuario.addContent(eMT4);
            this.raiz.addContent(eUsuario);
            this.guardarDocumento();
            return true;
        }
        return false;
    }

    public void eliminarUsuario(Element elementoEliminar) throws IOException {
        this.raiz.removeContent(elementoEliminar);
        guardarDocumento();
    }

    public Element buscarUsuario(String nombre) {
        List<Element> listaUsuarios = (List<Element>) this.raiz.getChildren();
        for (Element elementoBuscar : listaUsuarios) {
            if (elementoBuscar.getChildText("nombre").equalsIgnoreCase(nombre)) {
                return elementoBuscar;
            }
        }
        return null;
    }

    public Usuario getUsuario(String nombre) {
        List<Element> listaUsuarios = (List<Element>) this.raiz.getChildren();
        for (Element elementoBuscar : listaUsuarios) {
            if (elementoBuscar.getChildText("nombre").equalsIgnoreCase(nombre)) {
                return new Usuario(elementoBuscar.getChildText("nombre"), new String[]{elementoBuscar.getChildText("MT1"), elementoBuscar.getChildText("MT2"), elementoBuscar.getChildText("MT3"), elementoBuscar.getChildText("MT4"), null});
            }
        }
        return null;
    }

    public void modificarUsuario(Usuario usuario) throws IOException {
        Element eUsuario = buscarUsuario(usuario.getNombre());
        eUsuario.getChild("nombre").setText(usuario.getNombre());
        eUsuario.getChild("MT1").setText(usuario.getMejoresTiempos()[0]);
        eUsuario.getChild("MT2").setText(usuario.getMejoresTiempos()[1]);
        eUsuario.getChild("MT3").setText(usuario.getMejoresTiempos()[2]);
        eUsuario.getChild("MT4").setText(usuario.getMejoresTiempos()[3]);
        guardarDocumento();
    }

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        List<Element> listaXml = (List<Element>) this.raiz.getChildren();
        for (Element elementos : listaXml) {
            listaUsuarios.add(new Usuario(elementos.getChildText("nombre"), new String[]{elementos.getChildText("MT1"), elementos.getChildText("MT2"), elementos.getChildText("MT3"), elementos.getChildText("MT4"), null}));
        }
        return listaUsuarios;
    }
}
