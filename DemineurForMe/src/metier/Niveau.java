/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author DELL
 */
public class Niveau {
    /*car apres tous es attributs ne seront plus modifiés*/
    private final String libelle;
    private final int nombreLignes;
    private final int nombreColonnes;
    private final int nombreMines;
    
    public Niveau(){ /*ici si user ne précise rien comme niveau, on peut l'attribuer ce niveau par default*/
//        this.nombreLignes = 9;
//        this.nombreColonnes= 9;
//        this.nombreMines = 10;

           this("Débutant",9, 9, 10); //ici est meme plus élegant
    }
    public Niveau(String libelle, int nombreLignes, int nombreColonnes, int nombreMines){
        this.libelle = libelle;
        this.nombreLignes = nombreLignes;
        this.nombreColonnes= nombreColonnes;
        this.nombreMines = nombreMines; 
    }
    /*methode pour faire le calcul de nombreLignes  nombreClonnes*/
    
    public int getNombreCases(){
        return this.nombreLignes * this.nombreColonnes;
    }

    public int getNombreLignes() {
        return nombreLignes;
    }

    public int getNombreColonnes() {
        return nombreColonnes;
    }

    public int getNombreMines() {
        return nombreMines;
    }

    public String getLibelle() {
        return libelle;
    }
    
    
    
}
