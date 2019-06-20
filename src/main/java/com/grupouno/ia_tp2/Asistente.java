/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupouno.ia_tp2;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Julian
 */
public class Asistente {

    private ArrayList<String> MTCaracteristicas;
    private ProcesadorTokens procesadorTokens;
    private ListaProductos listaProductos;
    private ListaRespuestas listaResp;
    private LogFrame log;
    private PreguntaSiNo preguntaSiNo;

    public Asistente() {

        this.MTCaracteristicas = new ArrayList<>();
        this.procesadorTokens = new ProcesadorTokens();
        this.listaProductos = new ListaProductos();
        this.listaResp = new ListaRespuestas();
        this.log = new LogFrame();
        this.preguntaSiNo = null;

        log.setTitle("Logs");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = 0;
        int y = (int) (rect.getMaxY() / 2 - log.getHeight() / 2);
        log.setLocation(x, y);
        log.setVisible(true);
    }

    public void addCaracteristica(String s) {
        this.MTCaracteristicas.add(s);
    }

    String esPalabraClave(String token) {
        token = procesadorTokens.procesar(token);
        boolean b = procesadorTokens.esPalabraClave(token);
        //Si es palabra clave se agrega a la MTCaracteristicas
        if (b) {
            addCaracteristica(token);
            return token;
        } else {
            return null;
        }
    }

    ArrayList<Producto> getSugeridos() {
        ArrayList<Producto> result = new ArrayList<>();
        if (!MTCaracteristicas.isEmpty()) {
            for (Integer i = 0; i < listaProductos.getLista().size(); i++) {
                if (listaProductos.getLista().get(i).getCaracteristicas().containsAll(MTCaracteristicas)) {
                    result.add(listaProductos.getLista().get(i));
                }
            }
        }
        log(result);
        return result;
    }

    void log(ArrayList<Producto> sugeridos) {
        String reglas = "";
        for (int i = 0; i < sugeridos.size(); i++) {
            if (i != 0) {
                reglas += '\n';
            }
            reglas += " " + ((Integer) (i + 1)).toString() + ") ";
            for (Integer j = 0; j < MTCaracteristicas.size(); j++) {
                if (j != 0) {
                    reglas += "∧ ";
                }
                reglas += StringUtils.capitalize(MTCaracteristicas.get(j)) + "() ";
            }
            reglas += "⇒ " + StringUtils.capitalize(sugeridos.get(i).getNombre());
        }
        log.getLogArea().setText(reglas);
    }

    boolean esPalabraConversacion(String token) {
        token = procesadorTokens.procesar(token);
        boolean b = procesadorTokens.esPalabraConversacion(token);
        return b;
    }

    ArrayList<Respuesta> getConversaciones(ArrayList<String> palabrasConver) {
        ArrayList<Respuesta> result = new ArrayList<>();
        if (!palabrasConver.isEmpty()) {
            for (Integer i = 0; i < listaResp.getLista().size(); i++) {
                if (listaResp.getLista().get(i).getPalabrasClave().containsAll(palabrasConver)) {
                    result.add(listaResp.getLista().get(i));
                }
            }
        }
        return result;
    }

    String getRespuestaGenerica() {
        Integer i = new Random().nextInt(listaResp.getGenericas().size());
        String respuesta = listaResp.getGenericas().get(i).getOracion();
        return respuesta;
    }

    String getRespuesta(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        ArrayList<String> palabrasConver = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            //Se pasa el token y se compara con el listado de conversación
            if (esPalabraConversacion(token)) {
                palabrasConver.add(token);
            }
        }
        Respuesta respuesta;
        ArrayList<Respuesta> respuestas = getConversaciones(palabrasConver);
        if (respuestas.isEmpty()) {
            preguntaSiNo = null;
            return getRespuestaGenerica();
        } else {
            Integer i = new Random().nextInt(respuestas.size());
            respuesta = respuestas.get(i);
            if (respuesta.getClass().equals(PreguntaSiNo.class)) {
                preguntaSiNo = (PreguntaSiNo) respuesta;
            } else {
                preguntaSiNo = null;
            }
        }
        return respuesta.getOracion();
    }

    public PreguntaSiNo getPreguntaSiNo() {
        return preguntaSiNo;
    }

    String esSiNo(String token) {
        token = procesadorTokens.procesar(token);
        if (token.equals("si") || token.equals("no")) {
            return token;
        } else {
            return null;
        }
    }
}
