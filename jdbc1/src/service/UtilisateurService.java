/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.Connexion;
import dao.UtilisateurDao;
import entite.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class UtilisateurService {
    private final UtilisateurDao dao ;

    public UtilisateurService() {
        this.dao = new UtilisateurDao();
    }
    
    
    public void ajouter(Utilisateur utilisateur){
        
        dao.ajouter(utilisateur);
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
