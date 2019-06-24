/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupouno.ia_tp2;

import javax.swing.JFrame;

/**
 *
 * @author Julian
 */
public class Main {
    
    
    public static void main(String[] args) {

        Asistente as = new Asistente();
        JFrame f = new MainFrame(as);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
