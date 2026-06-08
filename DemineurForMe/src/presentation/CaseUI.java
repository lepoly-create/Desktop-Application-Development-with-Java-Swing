/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import metier.Case;

/**
 *
 * @author DELL
 */
public class CaseUI extends JButton{
    
    private final Case caseMetier ;
    private final Plateau plateau;
    
    public CaseUI(Case caseMetier, Plateau plateau){
        this.plateau = plateau;
        this.caseMetier = caseMetier;
        EcouteurCaseUI ecouteur = new EcouteurCaseUI();
        this.addMouseListener(ecouteur);
        this.afficher();
    }
    
    public Case getCaseMetier(){
        return this.caseMetier;
        
    }
    
    public void afficher(){
        if(this.caseMetier.isDevoilee()){
            if(this.caseMetier.isMinee()){
                this.afficherMine();
            } else {
                this.afficherContenu();
            }
        } else if(this.caseMetier.isMarquee()){
            this.afficherDrapeau();
        } else {
            this.setIcon(null);
        }
    }
    

    private void afficherContenu(){
        this.setBackground(Color.WHITE);
        String texte = this.caseMetier.getContenu();
        this.setText(texte);
    }
    
    private void afficherDrapeau(){
        URL url = getClass().getResource("/images/drapeau.jpeg");
        /*permet daller a la raicne des classe java ou les images sont chargées*/
        ImageIcon icone = new ImageIcon(url);
        this.setIcon(icone);
        
    }
    
    private void afficherMine(){
        URL url = getClass().getResource("/images/minee.jpeg");
        /*permet daller a la raicne des classe java ou les images sont chargées*/
        ImageIcon icone = new ImageIcon(url);
        this.setIcon(icone);
    }
    public Plateau getPlateau() {
        return plateau;
    }

}
