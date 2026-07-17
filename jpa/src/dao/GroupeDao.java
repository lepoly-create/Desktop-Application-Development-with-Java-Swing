/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entite.Groupe;
import util.JPAutil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author DELL
 */
public class GroupeDao {
    public Groupe ajouterGroupe(Groupe groupe){
        EntityManager em = JPAutil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            em.persist(groupe);
            transaction.commit();
            
            return groupe;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally{
            em.close();
        }
    }
    
    public Groupe modifierGroupe(Groupe groupe){
        EntityManager em = JPAutil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            Groupe mergegr = em.merge(groupe);
            transaction.commit();
            
            return mergegr;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
            
        } finally{
            em.close();
        }
    }
    
    public Groupe trouverGroupe(Integer id){
        EntityManager em = JPAutil.getEntityManager();
        
        try {
            return em.find(Groupe.class, id);
        } finally {
            em.close();
        }
    }
    
    public void supprimerGroupe(Groupe groupe){
        EntityManager em = JPAutil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            Groupe managed = new Groupe();
            if (em.contains(groupe)){
                managed = groupe;
            } else{
                managed = em.merge(groupe);
            }
            
            em.remove(managed);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            
        } finally {
            em.close();
        }
    }
    public void supprimerGroupe(Integer id){
        Groupe gr = trouverGroupe(id);
        
        if(gr != null){
            supprimerGroupe(gr);
        }
    }
    
    public List<Groupe> lister(){
        EntityManager em = JPAutil.getEntityManager();
        
        try {
            TypedQuery<Groupe> query = em.createQuery("SELECT gr FROM Groupe gr" , Groupe.class);
            return query.getResultList();
        } finally {
            em.close();
        }
        
    }
}
