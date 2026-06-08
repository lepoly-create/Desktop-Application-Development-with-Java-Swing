/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import metier.Partie;

/**
 *
 * @author DELL
 */
public class Plateau extends JFrame {
    
    private Partie partie;
    
    private JPanel champ = new JPanel();
    public Plateau(Partie partie){
        this.partie = partie;
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        this.initialiserChamp();
        this.add(champ, BorderLayout.CENTER);
        
        
    }
    
    
    private void initialiserChamp(){
        int nombreLignes = this.partie.getNiveau().getNombreLignes();
        int nombreColonnes = this.partie.getNiveau().getNombreColonnes();
        
        champ.setLayout(new GridLayout(nombreLignes, nombreColonnes));
        for (Case _case : this.partie.getCases()) {
            CaseUI caseUI = new CaseUI(_case);
            this.champ.add(caseUI);
        }
    }
}
