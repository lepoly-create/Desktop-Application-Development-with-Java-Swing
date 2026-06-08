/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import metier.Case;

/**
 *
 * @author DELL
 */
public class CaseUI extends JButton {
    
    private final Case caseMetier;
    
    public CaseUI(Case caseMetier){
        this.caseMetier = caseMetier;
        EcouteurCaseUI ecouteur = new EcouteurCaseUI();
        this.addMouseListener(ecouteur);
    }
    
    public Case getCaseMetier(){
        return this.caseMetier;
    }
    
    public void rafraichir(){
        
        
    }
    
    public void afficherDrapeau(){
        URL url = getClass().getResource("/images/drapeau.png");
        ImageIcon icone = new ImageIcon(url);
        this.setIcon(icone);
    }
    public void afficherMine(){
        URL url = getClass().getResource("/images/minee.png");
        ImageIcon icone = new ImageIcon(url);
        this.setIcon(icone);
    }
}
