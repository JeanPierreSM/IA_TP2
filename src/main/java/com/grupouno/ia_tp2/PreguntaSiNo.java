/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupouno.ia_tp2;

import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class PreguntaSiNo extends Regla {
    
    public ArrayList<String> ifSi;
    public ArrayList<String> ifNo;
    public ArrayList<Regla> siguientes;
    
    
    public PreguntaSiNo(String oracion) {
        super(oracion);
        this.ifNo = new ArrayList<>();
    }
    
    public PreguntaSiNo(String oracion, Prioridad prioridad) {
        super(oracion, prioridad);
        this.ifNo = new ArrayList<>();
    }
    

    public ArrayList<String> getIfSi() {
        return ifSi;
    }

    public void setIfSi(ArrayList<String> ifSi) {
        this.ifSi = ifSi;
    }

    public ArrayList<String> getIfNo() {
        return ifNo;
    }

    public void setIfNo(ArrayList<String> ifNo) {
        this.ifNo = ifNo;
    }

    public ArrayList<Regla> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(ArrayList<Regla> siguiente) {
        this.siguientes = siguiente;
    }
    
    
    
    
}
