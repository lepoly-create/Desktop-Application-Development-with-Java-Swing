/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Partie {
    
    private LocalDate heureDebut;
    private LocalDate heureFin;
    private boolean gagner = false;
    
    private List<Case> cases = new ArrayList();
    private Miniteur miniteur;
    private CompteurMine compteurMine;
    private Niveau niveau;
    
    public Partie(Niveau niveau){
        this.niveau = niveau;
        int nombereCases = niveau.getNombreCases();
        for(int i = 0; i < nombereCases; i++){
            Case _case = new Case(this);
            this.cases.add(_case);
        }
    }
    
    public Case getCase(int ligne, int colonne) throws Exception {
        int nombreColonnes = this.niveau.getNombreColonnes();
        int position = ligne * nombreColonnes + colonne;
        if(position < 0 || position >= this.niveau.getNombreCases()){
            throw new Exception("Coordonnées invalides");
        }
        return this.cases.get(position);
    }

    public LocalDate getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalDate heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalDate getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalDate heureFin) {
        this.heureFin = heureFin;
    }

    public boolean isGagner() {
        return gagner;
    }

    public void setGagner(boolean gagner) {
        this.gagner = gagner;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public Miniteur getMiniteur() {
        return miniteur;
    }

    public void setMiniteur(Miniteur miniteur) {
        this.miniteur = miniteur;
    }

    public CompteurMine getCompteurMine() {
        return compteurMine;
    }

    public void setCompteurMine(CompteurMine compteurMine) {
        this.compteurMine = compteurMine;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    
}

