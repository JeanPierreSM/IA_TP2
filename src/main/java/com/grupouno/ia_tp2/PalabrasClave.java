/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupouno.ia_tp2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Julian
 */
public class PalabrasClave {
    
    public static ArrayList<String> listado;
    public HashMap<String, String> sinonimos;

    public PalabrasClave() {
        listado = new ArrayList<>();
        listado.add("notebook");
        listado.add("telefono");
        listado.add("smartphone");
        listado.add("portable");
        listado.add("grande");
        listado.add("televisor");
        listado.add("smart");
        listado.add("samsung");
        listado.add("lg");
        listado.add("tcl");
        listado.add("philips");
        listado.add("32");
        listado.add("hd");
        listado.add("fhd");
        listado.add("4k");
        
        sinonimos = new HashMap<>();
        sinonimos.put("telefono", "smartphone");
        sinonimos.put("celular", "smartphone");
        sinonimos.put("cel", "smartphone");
        sinonimos.put("pequeño", "portable");
        sinonimos.put("chico", "portable");
        sinonimos.put("full", "fhd");
        sinonimos.put("fullhd", "fhd");
    }
    
}
