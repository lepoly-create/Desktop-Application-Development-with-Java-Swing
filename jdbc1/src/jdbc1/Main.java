/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc1;

import entite.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import presentation.UtilisateurUI;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ajouter(); 
//        trouver();
//        connexionUtilisateurV3();
//          Utilisateur u1 = new Utilisateur("user6", "123123");
//          ajouter(u1);
//            Utilisateur utilisateurTrouve = trouver("user1");
//            System.out.println(utilisateurTrouve);

            UtilisateurUI utilisateurUI = new UtilisateurUI();
            utilisateurUI.setVisible(true);
    }
    
private static void connexionUtilisateurV3(){
        Utilisateur utilisateur = new Utilisateur("user1", "123123");
        Connection connexion = getConnection();
        
        String sql = "SELECT * FROM utilisateurs WHERE identifiant = ? "
                       + "AND mot_de_passe = ? ;";
        System.out.println(sql);
        try {
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setString(1, utilisateur.getIdentifiant());
            etat.setString(2, utilisateur.getMotDePasse());
            
            
            ResultSet resultat = etat.executeQuery();
            
            if (resultat.next()){
                System.out.println("Connexion effectuée avec succes");
                
//                resultat.getString(0);
            }  else{
                System.out.println("Identifiant ou mot de psse incorrecte");
            }
            etat.close();
            connexion.close();
        } catch(SQLException e){
            System.out.println(e.getMessage()); 
        } finally {
        }
    }
    
private static void connexionUtilisateurV2(){
        String login = "user1";
        String motDePasse = "123123";
//        String motDePasse = "1 ' OR '1' = '1";
        Connection connexion = getConnection();
        
        String sql = "SELECT * FROM utilisateurs WHERE identifiant = ? "
                       + "AND mot_de_passe = ? ;";
        System.out.println(sql);
        try {
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setString(1, login);
            etat.setString(2, motDePasse);
            
            
            ResultSet resultat = etat.executeQuery();
            
            if (resultat.next()){
                System.out.println("Connexion effectuée avec succes");
                
//                resultat.getString(0);
            }  else{
                System.out.println("Identifiant ou mot de psse incorrecte");
            }
            etat.close();
            connexion.close();
        } catch(SQLException e){
            System.out.println(e.getMessage()); 
        } finally {
        }
    }
    
    private static void connexionUtilisateur(){
        String login = "user1";
        String motDePasse = "123123";
//        String motDePasse = "1 ' OR '1' = '1";
        Connection connexion = getConnection();
        
        String sql = "SELECT * FROM utilisateurs WHERE identifiant = '" + login +"' "
                       + "AND mot_de_passe = '" + motDePasse + "'";
        try {
            Statement etat = connexion.createStatement();/*Pour obtenir une instance de type Statement, il faut invoquer la méthode createStatement() sur un objet
de type Connection :*/
            /* Statement permet lui meme d'Encapsuler la requête SQL et la transmettre pour exécution à la base
de données ces interfaces filles sont createStatement, preparedStatement ...*/
            ResultSet resultat = etat.executeQuery(sql); /*ResultSet permet de Parcourir les informations retournées par la base de données dans le
cas d'une sélection de données*/
            
            if (resultat.next()){
                System.out.println("Connexion effectuée avec succes");
                
//                resultat.getString(0);
            }  else{
                System.out.println("Identifiant ou mot de psse incorrecte");
            }
            etat.close();
            connexion.close();
        } catch(SQLException e){
            System.out.println(e.getMessage()); 
        } finally {
        }
    }
    
    
    private static Utilisateur trouver(String identifiant){
        Connection connexion = getConnection();
        
        String sql = "SELECT * FROM utilisateurs WHERE identifiant = ?;";
        try {
            Utilisateur utilisateur = new Utilisateur();
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setString(1, identifiant); //remplacer cette premier place reserver par un identifiant
            ResultSet resultat = etat.executeQuery();
            
            if (resultat.next()){
                utilisateur.setId(resultat.getInt(1));
                utilisateur.setIdentifiant(resultat.getString(2));
            }  
            etat.close();
            connexion.close();
            return utilisateur;
        } catch(SQLException e){
            System.out.println(e.getMessage()); 
            return null;
        } finally {
        }
    }
    
    private static Utilisateur trouver(int id){
        Connection connexion = getConnection();
        
        String sql = "SELECT * FROM utilisateurs WHERE id = ?;";
        try {
            Utilisateur utilisateur = new Utilisateur();
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setInt(1, id);
            ResultSet resultat = etat.executeQuery(sql);
            
            if (resultat.next()){
                utilisateur.setId(resultat.getInt(1));
                utilisateur.setIdentifiant(resultat.getString(2));
            }  
            etat.close();
            connexion.close();
            return utilisateur;
        } catch(SQLException e){
            System.out.println(e.getMessage()); 
            return null;
        } finally {
        }
    }
    
    private static void trouver(){
        Connection connexion = getConnection();
        
        String sql = "SELECT * FROM utilisateurs WHERE id = 1;";
        try {
            Statement etat = connexion.createStatement();
            ResultSet resultat = etat.executeQuery(sql);
            
            if (resultat.next()){
                System.out.println("id est: " + resultat.getString(1));
                System.out.println("identifiant est: " + resultat.getString(2));
//                resultat.getString(0);
            }  
            etat.close();
            connexion.close();
        } catch(SQLException e){
            System.out.println(e.getMessage()); 
        } finally {
        }
    }
    
    private static void ajouter(Utilisateur utilisateur){
        Connection connexion = getConnection();
        String sql = "INSERT INTO utilisateurs(identifiant, mot_de_passe)"
                + " VALUES(? , ?);" ;
        try{
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setString(1, utilisateur.getIdentifiant());
            etat.setString(2, utilisateur.getMotDePasse());
            int nombresLignes = etat.executeUpdate(); /*La méthode executeUpdate() retourne le nombre d'enregistrements qui ont été mis à jou*/
            System.out.println("Opération effectué avec succes: " + nombresLignes + " ligne(s) ajoutée(s)");
            
            etat.close();
            connexion.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        
        }
        
    }
    private static void ajouter(){
        Connection connexion = getConnection();
        String sql = "INSERT INTO utilisateurs(identifiant, mot_de_passe)"
                + " VALUES('user3' , '123123');" ;
        try{
            Statement etat = connexion.createStatement();
            etat.execute(sql);
            etat.close();
            connexion.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        
        }
        
    }
    private static Connection getConnection(){
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String login = "jdbc";
        String motDePasse = "123456789";
        
        try {
            Connection connexion = DriverManager.getConnection(url, login, motDePasse);
//            System.out.println("Connexion éffectuée avec succes");
            return connexion ;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
            
        }
    }
}
