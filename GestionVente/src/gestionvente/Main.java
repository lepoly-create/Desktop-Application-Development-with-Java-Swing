/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionvente;

import Facture.Client;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Créer les catégories
        Categorie pc = new Categorie("PC", "PC portable");
        Categorie tel = new Categorie("TEL", "Téléphone portable");
        Categorie mem = new Categorie("MEM", "Carte mémoire");
        Categorie disk = new Categorie("DISK", "Disque dur");
        Categorie kitCat = new Categorie("KIT", "Kit");

        // Créer les articles simples
        ArticleSimple pc1 = new ArticleSimple("5SS50EA", "HP ELITEBOOK X360 830 G5", pc, 450000);
        ArticleSimple pc2 = new ArticleSimple("7GY98EA", "HP ENVY X360 13-AR0007NF", pc, 490000);
        ArticleSimple tel1 = new ArticleSimple("TWX4PO", "Téléphone Tecno WX4PO", tel, 65000);
        ArticleSimple mem1 = new ArticleSimple("CASD231", "Carte mémoire sandisk 4 GB", mem, 2000);
        ArticleSimple disk1 = new ArticleSimple("DC1000B", "KINGSTON SSD DC1000B 480 GO", disk, 33000);

        // Créer les kits
        Kit kitOrdi = new Kit("KTORDI", "Kit ordinateur", kitCat);
        kitOrdi.ajouterComposant(pc1, 1);
        kitOrdi.ajouterComposant(disk1, 2);

        Kit kitTel = new Kit("KTTEL", "Kit téléphone", kitCat);
        kitTel.ajouterComposant(tel1, 1);
        kitTel.ajouterComposant(mem1, 1);

        // Afficher le stock (liste des articles simples et quantités)
        // On peut créer une Map pour les quantités en stock (données dans l'énoncé)
        Map<Article, Integer> stock = new HashMap<>();
        stock.put(pc1, 7);
        stock.put(pc2, 6);
        stock.put(tel1, 5);
        stock.put(mem1, 15);
        stock.put(disk1, 10);
        // Les kits ne sont pas en stock en tant que tels, mais on peut les afficher aussi
        System.out.println("Stock :");
        for (Map.Entry<Article, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey().getLibelle() + " : " + entry.getValue());
        }

        // Créer un client
        Client client = new Client("C001", "Dupont", "Jean");

        // Créer une facture
        Facture facture = new Facture("F001", client);
        facture.ajouterLigne(kitOrdi, 1, 0);   // remise 0% (on peut mettre 0 car la remise de 5% est déjà dans le kit)
        facture.ajouterLigne(kitTel, 2, 0);
        facture.ajouterLigne(pc2, 2, 5);       // 5% de remise

        // Afficher la facture
        System.out.println(facture);

        // Mettre à jour le stock (déstockage)
        // On doit décrémenter les quantités des articles composant les kits.
        // On peut écrire une méthode qui parcourt les lignes de facture et pour chaque article,
        // si c'est un kit, on décrémente les composants, sinon on décrémente l'article simple.
        // Je laisse cette partie à faire.
    }
    
    
}
