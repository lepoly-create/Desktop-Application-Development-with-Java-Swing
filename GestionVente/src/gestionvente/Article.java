/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionvente;

/**
 *
 * @author DELL
 */
public abstract class Article {
    protected String reference;
    protected String libelle;
    protected Categorie categorie;

    public Article(String reference, String libelle, Categorie categorie) {
        this.reference = reference;
        this.libelle = libelle;
        this.categorie = categorie;
    }

    public abstract double getPrix(); // prix de base, sans remise

    // getters
    public String getReference() { return reference; }
    public String getLibelle() { return libelle; }
    public Categorie getCategorie() { return categorie; }
    
}
