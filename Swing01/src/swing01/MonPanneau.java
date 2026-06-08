/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing01;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author LePoly
 */
public class MonPanneau extends JScrollPane {
    /*JScrollPane ne peut pas contenir d'élément ,
    il contient juste un composant pour lequel il gère le 
    dimensionnement donc l'élement qui va contenir 
    les objets c'est le pannel et ce travail nous permet de dire
    à JScrollPane le composant dont qui va gèrer la zone */
    
    private JPanel panel = new JPanel();
    
    public MonPanneau(){
        super();
        this.setViewportView(panel);
        this.setVisible(true);
    }
    @Override
    public Component add(Component comp){
        return this.panel.add(comp);
    }
    /*ici on a redefini la méthode addp our que si une personne
    venanit d'ajouter un élément à la zone
    ça n'aille pas dans le jscrollpane mais plutot
    dans le pannel*/
    
}
