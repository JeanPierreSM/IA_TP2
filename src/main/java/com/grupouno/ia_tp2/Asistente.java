/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupouno.ia_tp2;

import com.grupouno.ia_tp2.Regla.Prioridad;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Julian
 */
public class Asistente {

    private ArrayList<String> MTCaracteristicas;
    private ArrayList<String> MTConversacion;
    private ProcesadorTokens procesadorTokens;
    private ReglasProductos listaProductos;
    private ReglasRespuestas listaReglasResp;
    private LogFrame log;
    private PreguntaSiNo preguntaSiNo;
    private ArrayList<Regla> aplicadas;

    public Asistente() {

        this.MTCaracteristicas = new ArrayList<>();
        this.MTConversacion = new ArrayList<>();
        this.procesadorTokens = new ProcesadorTokens();
        this.listaProductos = new ReglasProductos();
        this.listaReglasResp = new ReglasRespuestas();
        this.log = new LogFrame();
        this.preguntaSiNo = null;
        this.aplicadas = new ArrayList<>();

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

    String esPalabraClaveProducto(String token) {
        token = procesadorTokens.procesar(token);
        boolean b = procesadorTokens.esPalabraClaveProducto(token);
        //Si es palabra clave de producto se agrega a la MTCaracteristicas
        if (b) {
            addCaracteristica(token);
            return token;
        } else {
            return null;
        }
    }

    ArrayList<Regla> getSugeridos() {
        ArrayList<Regla> result = new ArrayList<>();
        if (!MTCaracteristicas.isEmpty()) {
            for (Integer i = 0; i < listaProductos.getLista().size(); i++) {
                if (listaProductos.getLista().get(i).getAntecedentes().containsAll(MTCaracteristicas)) {
                    result.add(listaProductos.getLista().get(i));
                }
            }
        }
        logReglasProductos(result);
        return result;
    }

    private void logReglasProductos(ArrayList<Regla> sugeridos) {
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
            reglas += "⇒ " + StringUtils.capitalize(sugeridos.get(i).getConsecuente());
        }
        log.getLogProductosArea().setText(reglas);
    }

    String esPalabraConversacion(String token) {
        token = procesadorTokens.procesar(token);
        boolean b = procesadorTokens.esPalabraConversacion(token);
        //Si es palabra clave de conversacion se agrega a la MTConversacion
        if (b) {
            addConversacion(token);
            return token;
        } else {
            return null;
        }
    }

    ArrayList<Regla> getConversaciones(ArrayList<String> palabrasConver) {
        ArrayList<Regla> result = new ArrayList<>();
        if (!palabrasConver.isEmpty()) {
            for (Integer i = 0; i < listaReglasResp.getLista().size(); i++) {
                ArrayList<String> antecedentes = listaReglasResp.getLista().get(i).getAntecedentes();

                //1. CRITERIO: ESPECIFICIDAD
                if (antecedentes.containsAll(palabrasConver)) {
                    result.add(listaReglasResp.getLista().get(i));
                }
            }
        }
        return result;
    }

    Regla getRespuestaGenerica() {
        Integer i = new Random().nextInt(listaReglasResp.getGenericas().size());
        Regla respuesta = listaReglasResp.getGenericas().get(i);
        return respuesta;
    }

    String getRespuesta(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        ArrayList<String> palabrasConver = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            //Se pasa el token y se compara con el listado de conversación
            token = esPalabraConversacion(token);
            if (token != null) {
                palabrasConver.add(token);
            }
        }
        Regla respuesta;
        ArrayList<Regla> respuestas = getConversaciones(palabrasConver);
        respuesta = getReglaPorCriterios(respuestas);

        return respuesta.getConsecuente();
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

    private ArrayList<Regla> getPrioridadMasAlta(ArrayList<Regla> respuestas) {
        ArrayList<Regla> result = new ArrayList<>();
        Prioridad max = Prioridad.BAJA;
        for (int i = 0; i < respuestas.size(); i++) {
            Prioridad aux = respuestas.get(i).getPrioridad();
            if (aux == Prioridad.ALTA) {
                max = Prioridad.ALTA;
            } else {
                if (aux == Prioridad.MEDIA && max == Prioridad.BAJA) {
                    max = Prioridad.MEDIA;
                }
            }
        }
        for (int i = 0; i < respuestas.size(); i++) {
            if (respuestas.get(i).getPrioridad() == max) {
                result.add(respuestas.get(i));
            }
        }
        return result;
    }

    Regla getSiguiente() {
        ArrayList<Regla> reglas = this.getPreguntaSiNo().getSiguientes();
        Regla r = getReglaPorCriterios(reglas);
        if (r.getClass().equals(PreguntaSiNo.class)) {
            this.preguntaSiNo = (PreguntaSiNo) r;
        } else {
            this.preguntaSiNo = null;
        }
        return r;
    }

    private Regla getReglaPorCriterios(ArrayList<Regla> reglas) {
        ArrayList<Regla> respuestas = reglas;
        Regla respuesta;

        //2. CRITERIO: NO DUPLICIDAD
        respuestas.removeAll(aplicadas);
        if (respuestas.isEmpty()) {
            preguntaSiNo = null;
            return getRespuestaGenerica();
        } else {

            //3. CRITERIO: PRIORIDAD
            respuestas = getPrioridadMasAlta(respuestas);

            //4. CRITERIO: ALEATOREIDAD
            Integer i = new Random().nextInt(respuestas.size());
            respuesta = respuestas.get(i);
            aplicadas.add(respuesta);
            if (respuesta.getClass().equals(PreguntaSiNo.class)) {
                preguntaSiNo = (PreguntaSiNo) respuesta;
            } else {
                preguntaSiNo = null;
            }
        }
        logReglaConversacion(respuesta);
        return respuesta;
    }

    private void logReglaConversacion(Regla respuesta) {
        String reglas = log.getLogConversacionArea().getText();
        if (!"".equals(reglas)) {
            reglas += '\n';
        }
        reglas += " > ";
        for (Integer j = 0; j < MTConversacion.size(); j++) {
            if (j != 0) {
                reglas += "∧ ";
            }
            reglas += StringUtils.capitalize(MTConversacion.get(j)) + "() ";
        }
        reglas += "⇒ " + StringUtils.capitalize(respuesta.getConsecuente());
        log.getLogConversacionArea().setText(reglas);
    }

    private void addConversacion(String token) {
        MTConversacion.add(token);
    }
}
