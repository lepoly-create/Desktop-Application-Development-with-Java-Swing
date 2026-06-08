/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LePoly
 */
public class EcouteurBoutonAjouter implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());/*mais c'est pas une bonne 
        façon de faire si les deux boutons ont des missions différents au tant 
        créer un écouteur pour chacun */
        
        //System.out.println("Bouton 'Ajouter' sélectionnée");
    }
    
}
