package com.mycompany.tennis.core;

import java.sql.*;

public class TestDeConnection {
    public static void main(String... args){
        // pour connecter notre projet Java avec une BDD on doit suivre 4 étapes
        // 1 chargement de driver
        // 2 Connection
        Connection conn = null;
        try {
            //MySQL driver MySQL Connector
        // Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","COURSEDB","coursedb");
        // Création d'une requete
            Statement statement = conn.createStatement();
        // l'exécution de la requete
            ResultSet rs = statement.executeQuery("SELECT NOM, PRENOM, ID FROM JOUEUR WHERE ID=128");
        // lire la ligne en mettant le curseur sur la ligne
            if (rs.next()){
                final String nom = rs.getString("NOM");
                final String prenom = rs.getString("PRENOM");
                final Long id = rs.getLong("ID");
                System.out.println("Le joueur/ La joueuse représenté(e) par le numéro "+id+ " est "+prenom+" "+nom);
            }else{
                System.out.println("Il n' y a pas d'enregistrement d'ID ");
            }

            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                // la déconnection
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


