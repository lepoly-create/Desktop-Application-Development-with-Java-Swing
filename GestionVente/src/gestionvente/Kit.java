/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionvente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Kit extends Article{
    private List<LigneKit> composants; // LigneKit = article + quantité

    public Kit(String reference, String libelle, Categorie categorie) {
        super(reference, libelle, categorie);
        composants = new ArrayList<>();
    }

    public void ajouterComposant(Article article, int quantite) {
        composants.add(new LigneKit(article, quantite));
    }

    @Override
    public double getPrix() {
        double total = 0;
        for (LigneKit ligne : composants) {
            // remise systématique de 5% sur chaque composant
            total += ligne.getQuantite() * ligne.getArticle().getPrix() * 0.95;
        }
        return total;
    }

    // getters pour composants
    public List<LigneKit> getComposants() { return composants; }
    
}
