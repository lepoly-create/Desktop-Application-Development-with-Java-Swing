/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.JPAutil;
import entite.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.eclipse.persistence.exceptions.TransactionException;

/**
 *
 * @author DELL
 */
public class UtilisateurDao {
    
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur){
        EntityManager em = JPAutil.getEntityManager();
        EntityTransaction transanction = em.getTransaction();
        
        try {
            transanction.begin();
            em.persist(utilisateur);
            transanction.commit();
            
            return utilisateur;
        } catch (Exception e) {
            transanction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
        
    }
    
    public Utilisateur modifierUtilisateur(Utilisateur utilisateur){
        EntityManager em = JPAutil.getEntityManager();
        EntityTransaction transanction = em.getTransaction();
        
        try {
            transanction.begin();
            Utilisateur mergeUser = em.merge(utilisateur);
            transanction.commit();
            
            return mergeUser;
        } catch (Exception e) {
            transanction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    public void supprimerUtilisateur(Utilisateur utilisateur){
        EntityManager em = JPAutil.getEntityManager();
        EntityTransaction transanction = em.getTransaction();
        
        try {
            transanction.begin();
            Utilisateur managed = new Utilisateur();
            if(em.contains(utilisateur)){
                managed = utilisateur;
            } else{
                managed = em.merge(utilisateur);
            }
            
            em.remove(managed);
            transanction.commit();
        } catch (Exception e) {
            transanction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    public Utilisateur trouverUtilisateur(Integer id){
        EntityManager em = JPAutil.getEntityManager();
        
        try {
            return em.find(Utilisateur.class, id);
        } finally {
            em.close();
        }
        
    }
    
    public List<Utilisateur> lister(){
        EntityManager em = JPAutil.getEntityManager();
        
        try {
            TypedQuery<Utilisateur> query = em.createQuery("SELECT user  FROM Utilisateur user ", Utilisateur.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
