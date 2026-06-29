/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.UtilisateurService;
import entite.Utilisateur;

/**
 *
 * @author DELL
 */
public class UtilisateurUI extends JFrame{
    //private final UtilisateurService service; //ici la classe a besoin d'un objet de type service a qui il faut envoyer des instructions
    private JTextField identifiant ;
    private final Utilisateur utilisateur;
    private JPasswordField motDePasse;
    private JButton boutonEnregistrer;
    
    
    public UtilisateurUI(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        //service = new UtilisateurService();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        layout.setConstraints(this, c);
        
        this.setLayout(layout);
        
        identifiant = new JTextField(25);
        motDePasse = new JPasswordField(25);
        boutonEnregistrer = new JButton("Enregistrer");
        
        c.gridwidth =1;
        c.gridx =0;
        c.gridy = 0;
        this.add(new JLabel("Identifiant: "), c);
        
        c.gridx = 1;
        this.add(identifiant, c);
        
        c.gridx =0;
        c.gridy = 1;
        this.add(new JLabel("Mot de passes:"), c);
        
        
        c.gridx = 1;
        this.add(motDePasse, c);
        
        c.gridx = 1;
        c.gridy = 2;
        this.add(boutonEnregistrer, c);
        this.afficher();
        
//        this.setVisible(true);
    }
    
    public void modifierUtilisteur(){
        this.utilisateur.setIdentifiant(identifiant.getText());
        this.utilisateur.setMotDePasse(motDePasse.getText());
    }
    
    public Utilisateur getUtilisateur(){
        return utilisateur;
    }
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
        
    }
    
    private void afficher(){
        this.identifiant.setText(this.utilisateur.getIdentifiant());
    }
    
    
}
