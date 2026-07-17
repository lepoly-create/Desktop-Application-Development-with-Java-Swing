/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.GroupeDao;
import dao.UtilisateurDao;
import entite.Utilisateur;
import entite.Groupe;
import java.util.List;

/**
 *
 * @author DELL
 */
public class UtilisateurService {
    private UtilisateurDao utilisateurdao = new UtilisateurDao();
    private GroupeDao groupedao = new GroupeDao();
    
    public Utilisateur creerUtilisateur(String nom, String prenom, String identifiant, String motDePasse, Integer groupeId){
        
        Groupe groupe = groupedao.trouverGroupe(groupeId);
        
        Utilisateur user = new Utilisateur(nom, prenom, identifiant, motDePasse, groupe);
        return  utilisateurdao.ajouterUtilisateur(user);
    }
    
    public Utilisateur modifierUtilisateur(Utilisateur utilisateur){
        return utilisateurdao.modifierUtilisateur(utilisateur);
    }
    public Utilisateur trouverUtilisateur(Integer id){
        return utilisateurdao.trouverUtilisateur(id);
    }
    
    public List<Utilisateur> listerUtilisateurs(){
        return utilisateurdao.lister();
    }
    
    public void supprimerUser(Utilisateur utilisateur) {
        utilisateurdao.supprimerUtilisateur(utilisateur);
    }
}
