/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LePoly
 */
public class EcouteurBoutonAjouter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        //Le message renvoyer quand le bouton ajouter ec1 perçoit un clic
        //System.out.println(" Bouton 'Ajouter' selectionné ");
    }
    
}
