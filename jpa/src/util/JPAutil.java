/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 *
 * @author DELL
 */
public class JPAutil {
    
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public static void fermer(){
        emf.close();
    }
}
