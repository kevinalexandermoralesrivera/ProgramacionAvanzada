package main;

import javax.swing.*;

import practica2_1.vista.VistaLista;
import practica2_1.controlador.ControladorLista;

import practica2_2.vista.VistaTabla;
import practica2_2.controlador.ControladorTabla;

import practica2_3.vista.VistaLayouts;
import practica2_3.controlador.ControladorLayouts;

public class Main {

    public static void main(String[] args){

        String op = JOptionPane.showInputDialog("""
1 Practica2_1
2 Practica2_2
3 Practica2_3
""");

        switch(op){
            case "1" -> {
                VistaLista v = new VistaLista();
                new ControladorLista(v);
                v.setVisible(true);
            }
            case "2" -> {
                VistaTabla v = new VistaTabla();
                new ControladorTabla(v);
                v.setVisible(true);
            }
            case "3" -> {
                VistaLayouts v = new VistaLayouts();
                new ControladorLayouts(v);
                v.setVisible(true);
            }
        }
    }
}