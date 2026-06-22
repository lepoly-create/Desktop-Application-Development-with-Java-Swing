/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author DELL
 */
public class Utilisateur {
    private int id;
    private String identifiant;
    private String motDePasse;
    
    public Utilisateur(){
        
    }
    public Utilisateur(String identifiant,String motDePasse ){
        
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", identifiant=" + identifiant + '}';
    }
    
    
    
    
}
