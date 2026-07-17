/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.GroupeDao;
import entite.Groupe;
import java.util.List;

/**
 *
 * @author DELL
 */
public class GroupeService {
    private GroupeDao groupedao = new GroupeDao();
    
    public Groupe creerGroupe(String nom, String description){
        Groupe gr = new Groupe(nom, description);
        return groupedao.ajouterGroupe(gr);
    }
    
    public Groupe modifierGroupe(Groupe groupe){
        return groupedao.modifierGroupe(groupe);
    }
    
    public Groupe trouverGroupe(Integer id){
        return groupedao.trouverGroupe(id);
    }
    
    public List<Groupe> listerGroupes(){
        return groupedao.lister();
    }
    
    public void supprimerGroupe(Integer id){
        groupedao.supprimerGroupe(id);
    }
}
