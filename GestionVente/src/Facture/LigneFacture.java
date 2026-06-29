/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facture;

import gestionvente.Article;

/**
 *
 * @author DELL
 */
public class LigneFacture {
    private Article article;
    private int quantite;
    private double remise; // en pourcentage (ex: 10 pour 10%)

    public LigneFacture(Article article, int quantite, double remise) {
        this.article = article;
        this.quantite = quantite;
        this.remise = remise;
    }

    public double getMontant() {
        double prixBase = article.getPrix() * quantite;
        return prixBase * (1 - remise / 100);
    }

    // getters

    public Article getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getRemise() {
        return remise;
    }
    
}
