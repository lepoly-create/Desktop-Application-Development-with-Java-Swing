/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class Partie {

    private LocalDate heureDebut;
    private LocalDate heureFin;
    private boolean gagnee = false;

    private List<Case> cases = new ArrayList<>();

    private Minuteur miniteur;
    private CompteurMine compteurMine;
    private Niveau niveau;
    private EtatJeuEnum etat;

    public Partie(Niveau niveau) {

        this.niveau = niveau;
        this.etat = EtatJeuEnum.ATTENTE;
        int nombreCases = niveau.getNombreCases(); // ici on vient de récupérer le nombre de case

        for (int i = 0; i < nombreCases; i++) {

            Case _case = new Case(this);
            // to do: attribuons la partie a la case
            this.cases.add(_case);
        }

    }

    /* methode permattant de nous renvoyer de coordonnées x ,y */
    public Case getCase(int ligne, int colonne) throws Exception {
        int nombreColonnes = this.niveau.getNombreColonnes();
        int position = ligne * nombreColonnes + colonne;

        if (position < 0 || position >= this.niveau.getNombreCases()) {
            throw new Exception("Coordonnées invalides");

        }
        return this.cases.get(position);
    }

    public void demarrer(Case premiereCase) {
        if (this.etat == EtatJeuEnum.ATTENTE) {
            this.etat = EtatJeuEnum.ENCOURS;
            this.setMines(premiereCase);
        }
    }

    public void setMines(Case caseExceptee) {
        int nombresMines = this.niveau.getNombreMines();
        int nombresCases = this.niveau.getNombreCases();

        int conteur = 0;
        Random random = new Random();
        while (conteur < nombresMines) {
            int position = random.nextInt(nombresCases);

            Case _case = this.cases.get(position);

            if (!_case.isMinee() && _case != caseExceptee) {// je viens de changer == a != si le provient survient apres
                                                            // je vais modifier
                _case.setMine();
                conteur++;
            }
        }
    }

    public void terminerAvecEchec() {
        this.etat = EtatJeuEnum.TERMINEE;
        this.toutDevoiler();

    }
    
    //a implementer apres et discuter avec le prof
    
    public boolean verifierVictoire() {
        for (Case c : this.cases) {
            if (!c.isMinee() && !c.isDevoilee()) {
                return false; // Il reste des cases non-minées non dévoilées
            }
        }
        this.etat = EtatJeuEnum.TERMINEE;
        this.gagnee = true;
        return true;
    }

    public void toutDevoiler() {
        for (Case _case : cases) {
            _case.devoiler();
        }
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

    public boolean isGagnee() {
        return gagnee;
    }

    public void setGagnee(boolean gagnee) {
        this.gagnee = gagnee;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public Minuteur getMiniteur() {
        return miniteur;
    }

    public void setMiniteur(Minuteur miniteur) {
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

    public EtatJeuEnum getEtat() {
        return etat;
    }
    
    

}
