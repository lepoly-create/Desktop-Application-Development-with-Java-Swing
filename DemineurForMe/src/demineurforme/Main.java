/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demineurforme;

import metier.Niveau;
import metier.Partie;
import presentation.Plateau;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Niveau niveau = new Niveau();
        Partie partie = new Partie(niveau);
        Plateau plateau = new Plateau(partie);
        plateau.setVisible(true);
    }
    
}
