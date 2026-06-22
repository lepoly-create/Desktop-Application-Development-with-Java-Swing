/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.UtilisateurService;

/**
 *
 * @author DELL
 */
public class UtilisateurUI extends JFrame{
    private final UtilisateurService service;
    private JTextField identifiant ;
    private JTextField motDePasse;
    
    
    public UtilisateurUI() {
        service = new UtilisateurService();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        layout.setConstraints(this, c);
        
        this.setLayout(layout);
        
        identifiant = new JTextField(25);
        motDePasse = new JTextField(25);
        
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
        
        this.setVisible(true);
    }
    
    
    
}
