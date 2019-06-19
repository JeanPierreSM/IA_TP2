/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupouno.ia_tp2;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Julian
 */
public class ProcesadorTokens {

    public PalabrasClave palabrasClave;
    public PalabrasConversacion palabrasConver;
    
    public String procesar(String token) {
        token = StringUtils.lowerCase(token);
        if(palabrasClave.sinonimos.containsKey(token)) return palabrasClave.sinonimos.get(token);
        else return token;
    }

    public ProcesadorTokens() {
        this.palabrasClave = new PalabrasClave();
        this.palabrasConver = new PalabrasConversacion();
    }

    boolean esPalabraClave(String token) {
        token = StringUtils.lowerCase(token);
        return palabrasClave.listado.contains(token);
    }

    boolean esPalabraConversacion(String token) {
        token = StringUtils.lowerCase(token);
        return palabrasConver.listado.contains(token);
    }
}
