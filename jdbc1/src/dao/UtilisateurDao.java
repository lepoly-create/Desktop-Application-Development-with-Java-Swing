/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import entite.Utilisateur;

/**
 *
 * @author DELL
 */
public class UtilisateurDao {
    private Connection connexion;
    
    public UtilisateurDao(){
        connexion = Connexion.getConnexion();
    }
    
    
    public void ajouter(Utilisateur utilisateur){
        String sql = "INSERT INTO utilisateurs(identifiant, mot_de_passe)"
                + " VALUES(? , ?);" ;
        try{
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setString(1, utilisateur.getIdentifiant());
            etat.setString(2, utilisateur.getMotDePasse());
            int nombresLignes = etat.executeUpdate();
            
            etat.close();
            connexion.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        
        }
        
    }
    
    public Utilisateur trouver(int id){
        return null;
        
    }
    public Utilisateur trouver(String identifiant){
        return null;
    }
    
    public Utilisateur modifier(Utilisateur utilisateur){
        return null;
    }
    
    public List<Utilisateur> lister(){
        return null;
    }
    
    public void supprimer(Utilisateur utilisateur){
    }
    public void supprimer(int id){
    }
    public void supprimer(String identifiant){
    }
    
}
