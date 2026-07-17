/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nom", length=60 , nullable = false)
    private String nom;
    
    @Column(name = "prenom" , length = 60, nullable = true)
    private String prenom;
    
    @Column(name = "identifiant" , length = 60, nullable = false)
    private String identifiant;
    
    @Column(name = "mot_de_passe" , length = 60, nullable= true)
    private String motDePasse;
    
    /*Many utilisateur to one groupe c'est ca l'explication de ManyToOne*/
    @ManyToOne(cascade = CascadeType.PERSIST) /*j'enregistre un user, et il sera rattacher aua groupe crée*/
    @JoinColumn(name= "id_group")
    private Groupe groupe;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String identifiant, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }
    
    

    public Utilisateur(String nom, String prenom, String identifiant, String motDePasse, Groupe groupe) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.groupe = groupe;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", identifiant=" + identifiant + ", motDePasse=" + motDePasse + ", groupe=" + groupe + '}';
    }

    
    
    
}
