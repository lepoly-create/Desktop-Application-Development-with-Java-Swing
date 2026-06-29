/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionvente;

/**
 *
 * @author DELL
 */
public class ArticleSimple extends Article {
     private double prixUnitaire;

    public ArticleSimple(String reference, String libelle, Categorie categorie, double prixUnitaire) {
        super(reference, libelle, categorie);
        this.prixUnitaire = prixUnitaire;
    }

    @Override
    public double getPrix() {
        return prixUnitaire;
    }
    
}
