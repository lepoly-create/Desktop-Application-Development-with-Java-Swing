/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package swing01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;

/**
 *
 * @author LePoly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
         //creerJDialog();
       // JOptionPane.showConfirmDialog(null, "Opération bien terminé");
        //JOptionPane.showMessageDialog(null, "Opération bien terminé");
        
//        creerJDialog();
//        creerJWindow();
//        creerJPanel2();
//        creerJPanel_old();
//        creerInterfaceGUI();
//           creerJScrollPane();
//           creerJFrame();
        gererEvenements();
    }
    
    public static void gererEvenements(){
        MaFenetre fenetre04 = new MaFenetre();
        JButton boutonAjouter = new JButton("Ajouter");
        JButton boutonModifier = new JButton("Modifier");
        
        //ajout d'écouteurs
        EcouteurBoutonAjouter ec1 = new EcouteurBoutonAjouter();
        boutonAjouter.addActionListener(ec1);/*ici j'ai un écouteur 
        de sélection en 1er lieur ec1 est juste 
        un objet mais pas un objet d'écouteur 
        d'action ou de sélection, là pour corriger 
        celà il faut que la classe implémente 
        linterface actionListener et là les object 
        de la classe peuvent écouter des lors*/
        
        //boutonModifier.addActionListener(ec1);
        
        /*on ne peu pas instancier une classe abstraite
        de même pour une interface car : 
        lorsque qu'on essayait de faire apelle à une méthode qui n'a pas de corps */
        ActionListener ec2 = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                System.out.println(" Bouton 'Modifier' sélectionné");
            }
        };
        
        //ActionListener ec3 = event -> {System.out.println(" Bouton 'Modifier' sélectionné");}; //autre façon de faire 
        ActionListener ec3 = event -> {System.out.println(event.getActionCommand());};
        
        boutonModifier.addActionListener(event -> {System.out.println(event.getActionCommand());});
        
        JPanel panel04 = new JPanel();
        
        panel04.add(boutonAjouter);
        panel04.add(boutonModifier);
        
        fenetre04.add(panel04);
        
        fenetre04.setVisible(true);
        
    }
    
    
    
    
    //exo de monsieur concernant l'interface à représenté 
    
    public static void creerInterfaceGUI(){
        
        JFrame fenetre01 = new JFrame("Application Swing");
        fenetre01.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetre01.setSize(800, 500);
        
        //je veux l'objet se positionne au centre
        fenetre01.setLocationRelativeTo(null);
        //ici je crée un container dans lequel je pourai mieux mettre les élements
        Container conteneurPrincipal = fenetre01.getContentPane();/*je recu^ère le conatainer 
        pour pouvoir y ajputer des éléments*/
        conteneurPrincipal.setLayout(new BorderLayout());/*je lui applique le borderLayout qui me permettra de diver la surface en 5 zones
        (nord, sud, est , ouest et centre) */
        
        
        /*ici on crée le panel on l'assigne un gestion de placement 
        et on lui donne sa postion avec les espaces horizontales et verticales */
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        
        topPanel.setBackground(new Color(24, 43, 114));

        JLabel utilisateurInfo = new JLabel("Connecté: username");
        utilisateurInfo.setFont(new Font("Arial", Font.BOLD, 16));
        utilisateurInfo.setForeground(Color.WHITE);
        topPanel.add(utilisateurInfo);

        conteneurPrincipal.add(topPanel, BorderLayout.NORTH);
        
      
        
        
        JPanel partieOuest = new JPanel(new BorderLayout());
        partieOuest.setBackground(new Color(224, 224, 224));
        partieOuest.setPreferredSize(new Dimension(150, 0));
        
        JPanel monMenu = new JPanel(new GridLayout(6, 1, 0, 5));
        /*ici gridlayout(6,1,0,5) veit dire que on crée un grilles de 6 lignes 
        avec un colonne, et 0 pour espace horizontale et 5 pour verticale*/
        monMenu.setBackground(new Color(224, 224, 224));
        monMenu.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 0));
        
        JLabel titreMenu = new JLabel("Menu");
        titreMenu.setFont(new Font("SansSerif", Font.BOLD, 20));
        monMenu.add(titreMenu);
        monMenu.add(new JLabel("Page 1"));
        monMenu.add(new JLabel("Page 2"));
        monMenu.add(new JLabel("Page 3"));
        monMenu.add(new JLabel("Page 4"));
        monMenu.add(new JLabel("Page 5"));
        
        partieOuest.add(monMenu, BorderLayout.NORTH);
        conteneurPrincipal.add(partieOuest, BorderLayout.WEST);

        JPanel panneauCentre = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panneauCentre.setBackground(new Color(242, 242, 242));
        
        JLabel titrePage = new JLabel("Titre de page 1");
        titrePage.setFont(new Font("SansSerif", Font.PLAIN, 16));
        panneauCentre.add(titrePage);
        
        conteneurPrincipal.add(panneauCentre, BorderLayout.CENTER);

        JPanel panneauSud = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
        panneauSud.setBackground(new Color(201, 219, 246));
        
        JLabel labelCopyright = new JLabel("© copyright ...");
        labelCopyright.setForeground(Color.DARK_GRAY);
        panneauSud.add(labelCopyright);
        
        conteneurPrincipal.add(panneauSud, BorderLayout.SOUTH);

        fenetre01.setVisible(true);
        
      
        
    }
    
    public static void creerJPanel_old(){
        JFrame fenêtre = new JFrame("Application Swing");
        fenêtre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenêtre.setSize(400, 300);
        
        JPanel panel3 = new JPanel();
        /*on crée un gestionnaire de déplacement et o
        à l'éxécution on remarque que c'était le gestionnaire
        par defaut*/
//        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
//        BorderLayout borderLayout = new BorderLayout();
        
        GridLayout gridLayout = new GridLayout(3, 2);
        panel3.setLayout(gridLayout);
        
        
        panel3.setBackground(Color.red);
//        JButton boutonNord = new JButton("Bouton Nordd");
//        JButton boutonSud = new JButton("Bouton Sud");
//        JButton boutonEst= new JButton("Bouton Est");
//        JButton boutonOuest = new JButton("Bouton Ouest");
//        JButton boutonCentre = new JButton("Bouton Centre");
        for (int i =1; i<=6; i++){
            panel3.add(new JButton("Bouton - " +i));
        }
        
//        panel3.add(boutonCentre);
//        panel3.add(boutonEst, BorderLayout.EAST);
//        panel3.add(boutonNord, BorderLayout.NORTH);
//        panel3.add(boutonOuest, BorderLayout.WEST);
//        panel3.add(boutonSud, BorderLayout.SOUTH);
//        panel3.add(boutonEst, BorderLayout.EAST);
        
//        JScrollPane jScrollPane = new JScrollPane(panel3);
//        fenêtre.add(jScrollPane);
        fenêtre.add(panel3);
        fenêtre.setVisible(true);
    }
    
    public static void creerJPanel2(){
        MaFenetre fenetre = new MaFenetre();
        
        MonPanneau panel2 = new MonPanneau();
        
        for (int i =1 ; i<=80; i++){
            panel2.add(new JButton("Bouton - " +i));
        }
        
        fenetre.add(panel2);
//        JLabel label = new JLabel("Ceci est une étiquette");
//        panel2.add(label);
        fenetre.setVisible(true);
    }
    
    public static void creerJPanel1(){
        MaFenetre fenetre = new MaFenetre();
        fenetre.setSize(400, 300); /*ici permet de donner une largeur et hauteur
        par defaut qu'on aura la fenêtre à la première affichage après compilation
        et à éxécution*/
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel1 = new JPanel();  /*ici nous allons crée un JPanel
        qui est  en faite ici lebody on va dire ainsi comme c'est juste un 
        JPannel on veut */
        // mettre  la nouvelle classe ici
        
        panel1.setBackground(Color.RED);//on lui donne un bg red
        /*ici dans le JPannel on ajoute des Jbouton avec notre boucle for*/
        for(int i = 1; i <= 10; i++){
            panel1.add(new JButton("Bouton - " + i));
        }
        
        /*Ici nous ajoutons un barre de déroulement qui permettra de 
        dérouler pour voir l'autre zone de la largeur si il arrivait que 
        le nombre de boutton désiré affiché est nombreux et qui dépasse la largeur
        de notre écran personnelle*/
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
    
    public static void creerJScrollPane(){
        MaFenetre c = new MaFenetre();
        JScrollPane scrollpane;
        String categories[] = { "Ahmed", "Aboubakr", "Meriem",
                                "Kamel", "Aicha", "Badr", "Josue",
                                "Charlotte", "Fidèle", "Delphine", "Gabriel",
                                "Massé" , "Robert" , "Emmanuel", "Komlan" , "Prince"
        };
        
        JList list = new JList(categories);
        scrollpane = new JScrollPane(list);
        c.add(scrollpane, BorderLayout.CENTER);
    }
    
}
