/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Connexion {
        private static Connection connexion;
    static{
        String url = "jdbc:postgresql://localhost:5432/dbjpa";
        String login = "jpa";
        String motDePasse = "123456789";
        
        try {
             connexion = DriverManager.getConnection(url, login, motDePasse);
             System.out.println("Vous etes connecté");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            
        }
    }
    
    public static Connection getConnexion(){
        return connexion;
    }
    
}
