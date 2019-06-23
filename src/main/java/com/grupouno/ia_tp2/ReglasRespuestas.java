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
class ReglasRespuestas {

    ArrayList<Regla> lista;
    ArrayList<Regla> genericas;

    public ReglasRespuestas() {

        this.lista = new ArrayList<>();
        

        ArrayList<String> antecedentes1 = new ArrayList<String>();
        antecedentes1.add("buscar");
        antecedentes1.add("compar");
        antecedentes1.add("necesitar");
        antecedentes1.add("notebook");
        
        ArrayList<String> antecedentes2 = (ArrayList<String>) antecedentes1.clone();
        antecedentes2.add("gamma baja");
        antecedentes2.add("basica");
        antecedentes2.add("gamma media");
        antecedentes2.add("gamma alta");
        
        ArrayList<String> antecedentes3 = (ArrayList<String>) antecedentes2.clone();
        antecedentes3.add("pantalla");
        antecedentes3.add("grande");
        antecedentes3.add("notebook");
        antecedentes3.add("portable");
        antecedentes3.add("pequeña");
        
        ArrayList<String> antecedentes4 = (ArrayList<String>) antecedentes3.clone();
        antecedentes4.add("ultimo");
        antecedentes4.add("modelo");
        antecedentes4.add("reciente");
        antecedentes4.add("nuevo");
                
        ArrayList<String> antecedentes5 = (ArrayList<String>) antecedentes4.clone();
        antecedentes5.add("edicion");
        antecedentes5.add("editar");
        
        ArrayList<String> antecedentes6 = (ArrayList<String>) antecedentes5.clone();
        antecedentes6.add("ram");
        
        ArrayList<String> antecedentes7 = (ArrayList<String>) antecedentes6.clone();
        antecedentes7.add("almacenamiento");
        
        ArrayList<String> antecedentes8 = (ArrayList<String>) antecedentes7.clone();
        antecedentes8.add("ssd");
        
        ArrayList<String> antecedentes9 = (ArrayList<String>) antecedentes8.clone();
        antecedentes9.add("microprocesador");
        antecedentes9.add("generacion");
        
        Regla ultima = new Regla("Estas son todas las sugerencias que encontre. Espero haberle sido de ayuda! Hasta pronto.");
        
        PreguntaSiNo siNo0 = new PreguntaSiNo("¿Necesita el equipo para hacer labores de edición?");
        siNo0.setAntecedentes(antecedentes9);
        siNo0.setIfSi(new ArrayList<String>() {
            {
                add("edicion");
            }
        }
        );
        siNo0.setSiguientes(new ArrayList<Regla>() {
            {
                add(ultima);
            }
        }
        );
        lista.add(siNo0);
        
        PreguntaSiNo siNo1 = new PreguntaSiNo("¿Realiza trabajos de edición de imagenes/video?", Regla.Prioridad.BAJA);
        siNo1.setAntecedentes(antecedentes9);
        siNo1.setIfSi(new ArrayList<String>() {
            {
                add("edicion");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<Regla>() {
            {
                add(ultima);
            }
        }
        );
        lista.add(siNo1);
        
        PreguntaSiNo siNo2 = new PreguntaSiNo("De acuerdo a sus necesidades, ¿cree que necesita un microprocesador potente?", Regla.Prioridad.BAJA);
        siNo2.setAntecedentes(antecedentes8);
        siNo2.setIfSi(new ArrayList<String>() {
            {
                add("micropocesador potente");
                add("gamma alta");
            }
        }
        );
        siNo2.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo1);
                add(siNo0);
            }
        }
        );
        lista.add(siNo2);
        
        PreguntaSiNo siNo3 = new PreguntaSiNo("¿Está buscando una PC con un gran microprocesador?");
        siNo3.setAntecedentes(antecedentes8);
        siNo3.setIfSi(new ArrayList<String>() {
            {
                add("micropocesador potente");
                add("gamma alta");
            }
        }
        );
        siNo3.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo1);
                add(siNo0);
            }
        }
        );
        lista.add(siNo3);
        
        PreguntaSiNo siNo4 = new PreguntaSiNo("¿Considera de utilidad que el ordenador este equipado con una unidad de estado sólido (SDD)?");
        siNo4.setAntecedentes(antecedentes7);
        siNo4.setIfSi(new ArrayList<String>() {
            {
                add("ssd");
            }
        }
        );
        siNo4.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo3);
                add(siNo2);
            }
        }
        );
        lista.add(siNo4);
        
        PreguntaSiNo siNo5 = new PreguntaSiNo("¿Necesita un ordenador con SSD?");
        siNo5.setAntecedentes(antecedentes7);
        siNo5.setIfSi(new ArrayList<String>() {
            {
                add("ssd");
            }
        }
        );
        siNo5.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo3);
                add(siNo2);
            }
        }
        );
        lista.add(siNo5);
        
        PreguntaSiNo siNo6 = new PreguntaSiNo("¿Necesita un ordenador con grandes capacidades de almacenamiento?");
        siNo6.setAntecedentes(antecedentes6);
        siNo6.setIfSi(new ArrayList<String>() {
            {
                add("1tb hdd");
            }
        }
        );
        siNo6.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo4);
                add(siNo5);
            }
        }
        );
        lista.add(siNo6);
        
        PreguntaSiNo siNo7 = new PreguntaSiNo("¿Está buscando un ordenador con mucho almacenamiento perdurable?");
        siNo7.setAntecedentes(antecedentes6);
        siNo7.setIfSi(new ArrayList<String>() {
            {
                add("1tb hdd");
            }
        }
        );
        siNo7.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo4);
                add(siNo5);
            }
        }
        );
        lista.add(siNo7);
        
        
        PreguntaSiNo siNo8 = new PreguntaSiNo("¿Está buscando un equipo con al menos 8GB de RAM?");
        siNo8.setAntecedentes(antecedentes5);
        siNo8.setIfSi(new ArrayList<String>() {
            {
                add("8gb");
            }
        }
        );
        siNo8.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo6);
                add(siNo7);
            }
        }
        );
        lista.add(siNo8);
        
        
        PreguntaSiNo siNo9 = new PreguntaSiNo("¿Necesita una PC con 8GB de RAM como mínimo?");
        siNo9.setAntecedentes(antecedentes5);
        siNo9.setIfSi(new ArrayList<String>() {
            {
                add("8gb");
            }
        }
        );
        siNo9.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo6);
                add(siNo7);
            }
        }
        );
        lista.add(siNo9);
        
        PreguntaSiNo siNo10 = new PreguntaSiNo("¿Necesita el equipo para hacer labores de edición?", Regla.Prioridad.BAJA);
        siNo10.setAntecedentes(antecedentes4);
        siNo10.setIfSi(new ArrayList<String>() {
            {
                add("edicion");
            }
        }
        );
        siNo8.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo8);
                add(siNo9);
            }
        }
        );
        lista.add(siNo10);
        
        PreguntaSiNo siNo11 = new PreguntaSiNo("¿Realiza trabajos de edición de imagenes/video?", Regla.Prioridad.BAJA);
        siNo11.setAntecedentes(antecedentes4);
        siNo11.setIfSi(new ArrayList<String>() {
            {
                add("edicion");
            }
        }
        );
        siNo11.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo8);
                add(siNo9);
            }
        }
        );
        lista.add(siNo11);
        
        Regla regla12 = new Regla("¿Quiere un equipo último modelo o prefiere economizar comprando modelos anteriores?");
        regla12.setAntecedentes(antecedentes3);
        lista.add(regla12);
        
        PreguntaSiNo siNo13 = new PreguntaSiNo("¿Necesita un ordenador que salió recientemente en el mercado?");
        siNo13.setAntecedentes(antecedentes3);
        siNo13.setIfSi(new ArrayList<String>() {
            {
                add("nuevo");
                add("reciente");
            }
        }
        );
        siNo13.setIfNo(new ArrayList<String>() {
            {
                add("viejo");
                add("economizar");
            }
        }
        );
        siNo13.setSiguientes(new ArrayList<Regla>() {
            {
                add(siNo10);
                add(siNo11);
            }
        }
        );
        lista.add(siNo13);
        
        Regla regla14 = new Regla("¿Está buscando un equipo portable o prioriza una pantalla mas grande?", Regla.Prioridad.ALTA);
        regla14.setAntecedentes(antecedentes2);
        lista.add(regla14);
        
        Regla regla15 = new Regla("¿Prefiere un equipo con pantalla grande? ¿O prioriza algo más pequeño?", Regla.Prioridad.ALTA);
        regla15.setAntecedentes(antecedentes2);
        lista.add(regla15);
        
        Regla regla16 = new Regla("¿Está buscando un producto de gama básica, media o premium?", Regla.Prioridad.ALTA);
        regla16.setAntecedentes(antecedentes1);
        lista.add(regla16);
        
        Regla regla17 = new Regla("¿Necesita un ordenador de gama baja, media o alta?", Regla.Prioridad.ALTA);
        regla17.setAntecedentes(antecedentes1);
        lista.add(regla17);
        
        this.genericas = new ArrayList<>();
        Regla gen = new Regla("Perfecto!");
        genericas.add(gen);
        gen = new Regla("Excelente!");
        genericas.add(gen);
        gen = new Regla("Entendido!");
        genericas.add(gen);

    }

    public ArrayList<Regla> getGenericas() {
        return genericas;
    }

    public ArrayList<Regla> getLista() {
        return lista;
    }
}
