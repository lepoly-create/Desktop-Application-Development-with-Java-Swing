/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facture;

import gestionvente.Article;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Facture {
    private String reference;
    private Date date;
    private Client client;
    private List<LigneFacture> lignes;

    public Facture(String reference, Client client) {
        this.reference = reference;
        this.date = new Date(); // date courante
        this.client = client;
        this.lignes = new ArrayList<>();
    }

    public void ajouterLigne(Article article, int quantite, double remise) {
        // vérifier que remise <= 10
        if (remise > 10) remise = 10;
        lignes.add(new LigneFacture(article, quantite, remise));
    }

    public double getTotal() {
        double total = 0;
        for (LigneFacture ligne : lignes) {
            total += ligne.getMontant();
        }
        return total;
    }

    @Override
    public String toString() {
        // afficher les infos de la facture
        return "La reference de votre facture est: "+ this.reference
                + "\tVotre facture a été établi a: " + this.date
                + "\tClient: " + this.client
                + "\tLa facture posséde au total: "+this.lignes
                ;
    }
    
}
