/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupouno.ia_tp2;

import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Julian
 */
public class ProcesadorTokens {

    public PalabrasClaveProductos palabrasClave;
    public PalabrasClaveConversacion palabrasConver;
    public HashMap<String, String> sinonimos;

    public String procesar(String token) {
        token = StringUtils.lowerCase(token);
        if (sinonimos.containsKey(token)) {
            return sinonimos.get(token);
        } else {
            return token;
        }
    }

    public ProcesadorTokens() {
        this.palabrasClave = new PalabrasClaveProductos();
        this.palabrasConver = new PalabrasClaveConversacion();

        //Diccionario Sinonimos
        sinonimos = new HashMap<>();
        sinonimos.put("telefono", "smartphone");
        sinonimos.put("celular", "smartphone");
        sinonimos.put("cel", "smartphone");
        sinonimos.put("pequeño", "portable");
        sinonimos.put("chico", "portable");
        sinonimos.put("full", "fhd");
        sinonimos.put("fullhd", "fhd");
        sinonimos.put("baja", "gamma baja");
        sinonimos.put("alta", "gamma alta");
        sinonimos.put("premium", "gamma alta");
        sinonimos.put("media", "gamma media");
        sinonimos.put("medio", "gamma media");
        sinonimos.put("basica", "gamma baja");
        sinonimos.put("basico", "gamma baja");
        sinonimos.put("computadora", "notebook");
        sinonimos.put("microprocesador", "microprocesador potente");
        sinonimos.put("ultimo", "reciente");
        sinonimos.put("tv", "televisor");
        sinonimos.put("juegos", "videojuegos");
        sinonimos.put("gaming", "videojuegos");
        sinonimos.put("3", "3gb");
        sinonimos.put("jugar", "videojuegos");
    }

    boolean esPalabraClaveProducto(String token) {
        token = StringUtils.lowerCase(token);
        return palabrasClave.listado.contains(token);
    }

    boolean esPalabraConversacion(String token) {
        token = StringUtils.lowerCase(token);
        return palabrasConver.listado.contains(token);
    }
}
