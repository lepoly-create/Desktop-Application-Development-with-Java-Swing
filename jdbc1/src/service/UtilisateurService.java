/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UtilisateurDao;
import entite.Utilisateur;
import java.sql.SQLException;
import java.util.List;
import util.ObjetNonTrouveException;

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
        
        this.dao.ajouter(utilisateur);
    }
    
    public Utilisateur trouver(int id) throws ObjetNonTrouveException, SQLException{
        return dao.trouver(id);
        
    }
    public Utilisateur trouver(String identifiant){
        return null;
    }
    
    public Utilisateur modifier(Utilisateur utilisateur){
        return dao.modifier(utilisateur);
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
