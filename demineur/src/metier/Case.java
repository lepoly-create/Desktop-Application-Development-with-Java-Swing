/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author DELL
 */
public class Case {
    
    private boolean minee = false;
    private final Partie partie;
    private EtatCaseEnum etat = EtatCaseEnum.INITIAL;
    
    public Case(Partie partie){
        this.partie = partie;
    }
    
    public void marquer(){
        switch (this.etat) {
            case EtatCaseEnum.INITIAL:
                this.etat = EtatCaseEnum.MARQUE;
                break;
            case EtatCaseEnum.DEVOILE:
                this.etat = EtatCaseEnum.INITIAL;
                break;
        }
    }
    
    public void devoiler(){
        if(this.etat == EtatCaseEnum.INITIAL){
            this.etat = EtatCaseEnum.DEVOILE;
            this.devoilerVoisines();
        }
    }
    
    public String getContenu(){
        List<Case> voisines = this.getVoisines();
        int nombreMines = this.getNombresMines(voisines);
        return nombreMines == 0 ? "" : String.valueOf(nombreMines);
    }
    
    private void devoilerVoisines(){
        List<Case> voisines = this.getVoisines();
        int nombreMines = this.getNombresMines(voisines);
        if(nombreMines == 0){
            for(Case _case: voisines){
                _case.devoiler();
            }
        }
    }
    
    private int getNombresMines(List<Case> cases){
        int nombreMines = 0;
        for(Case _case : cases){
            if(_case.isMinee()){
                nombreMines ++;
            }
        }
        return nombreMines;
    }
    
    private List<Case> getVoisines(){
        List<Case> voisines = new ArrayList();
        int ligne = this.getLigne();
        int colonne = this.getColonne();
        
        this.ajouterVoisine(voisines, ligne-1, colonne-1);
        this.ajouterVoisine(voisines, ligne-1, colonne);
        this.ajouterVoisine(voisines, ligne-1, colonne+1);
        
        this.ajouterVoisine(voisines, ligne, colonne-1);
//        this.ajouterVoisine(voisines, ligne, colonne);
        this.ajouterVoisine(voisines, ligne, colonne+1);
        
        this.ajouterVoisine(voisines, ligne+1, colonne-1);
        this.ajouterVoisine(voisines, ligne+1, colonne);
        this.ajouterVoisine(voisines, ligne+1, colonne+1);
        
        return voisines;
    }
    
    private void ajouterVoisine (List<Case> voisines, int x, int y){
        try {
            voisines.add(this.partie.getCase(x, y));
        } catch (Exception ex) {
            
        }
    }
    
    private int getLigne(){
        int nombreColonnes = this.partie.getNiveau().getNombreColonnes();
        int position = this.partie.getCases().indexOf(this);
        return position / nombreColonnes;
    }
    
    private int getColonne(){
        int nombreColonnes = this.partie.getNiveau().getNombreColonnes();
        int position = this.partie.getCases().indexOf(this);
        return position % nombreColonnes;
    }

    public Partie getPartie() {
        return partie;
    }
    
    public void setMine(){
        this.minee = true;
    }
    
    public boolean isMinee(){
        return this.minee;
    }

    public EtatCaseEnum getEtat() {
        return etat;
    }

    public void setEtat(EtatCaseEnum etat) {
        this.etat = etat;
    }
    
}
