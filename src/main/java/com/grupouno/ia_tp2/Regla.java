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
public class Regla {

    public String consecuente;
    public ArrayList<String> antecedentes;
    public Prioridad prioridad;

    public Regla(String consecuente) {
        this.consecuente = consecuente;
        this.prioridad = Prioridad.BAJA;
    }

    public Regla(String consecuente, Prioridad prioridad) {
        this.consecuente = consecuente;
        this.prioridad = prioridad;
    }

    public ArrayList<String> getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(ArrayList<String> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getConsecuente() {
        return consecuente;
    }

    public void setConsecuente(String oracion) {
        this.consecuente = oracion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    enum Prioridad {
        BAJA,
        MEDIA,
        ALTA
    }
}
