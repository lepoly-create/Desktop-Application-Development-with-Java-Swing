/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.java_swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;

/**
 *
 * @author LePoly
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        
         //creerJDialog();
       // JOptionPane.showConfirmDialog(null, "Opération bien terminé");
        //JOptionPane.showMessageDialog(null, "Opération bien terminé");
        
        creerJPanel();
        gererEvenements();
    }
    
    public static void creerJPanel(){
        MaFenetre fenetre = new MaFenetre();
        fenetre.setSize(400, 300);
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel1 = new JPanel(); // mettre  la nouvelle classe ici
        panel1.setBackground(Color.RED);
        for(int i = 1; i <= 40; i++){
            panel1.add(new JButton("Bouton-" + i));
        }
        
        JScrollPane jscrollpane = new JScrollPane(panel1);   
       
        fenetre.add(jscrollpane);
        fenetre.setVisible(true);
    }
    public static void creerJWindow(){
        JWindow w = new JWindow();
        w.setSize(300, 300);
        w.setLocation(500, 100);
        w.setVisible(true);
    }
    
    public static void creerJDialog(){
        JDialog dialogue = new JDialog();
        dialogue.setSize(300, 150);
        dialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialogue.setTitle("Application opérationen cours...");
        dialogue.setVisible(true);
    }
    public static void creerJFrame(){
       /*    System.out.println(new App().getGreeting());
        JFrame fenetre1 = new JFrame();
        fenetre1.setTitle("Fenêtre 1");
        fenetre1.setSize(500, 300);
        fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre1.setVisible(true); */
        
        JButton bouton1 = new JButton("Premier bouton");
        JFrame fenetre2 = new JFrame();
        fenetre2.setTitle("Fenêtre 2");
        fenetre2.setSize(500, 300);
        fenetre2.add(bouton1);
        fenetre2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetre2.setVisible(true); 
    }
    
    
    public static void gererEvenements() {
        MaFenetre fenetre = new MaFenetre();
        JButton boutonAjouter = new JButton("Ajouter");
        JButton boutonModifier = new JButton("Ajouter");
        
        //ajout d'écouteur
        EcouteurBoutonAjouter ec1 = new EcouteurBoutonAjouter();
        boutonAjouter.addActionListener(ec1);
        //boutonModifier.addActionListener(ec1);
        
        ActionListener ec2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Bouton 'Modifier selectionné'");
            }
        };
        boutonModifier.addActionListener(ec2);
        
        
        //boutonAjouter
        JPanel panel = new JPanel();
        
        panel.add(boutonAjouter);
        panel.add(boutonModifier);
        
        fenetre.add(panel);
        fenetre.setVisible(true);
    }
}
