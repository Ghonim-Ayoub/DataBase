package com.mycompany.tennis.core;

import java.sql.*;

public class TestDeConnection {
    public static void main(String... args) {
        // pour connecter notre projet Java avec une BDD on doit suivre 4 étapes
        // 1 chargement de driver
        // 2 Connection
        Connection conn = null;
        try {
            //MySQL driver MySQL Connector
            // Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "COURSEDB", "coursedb");
            // Création d'une requete
            PreparedStatement ps = conn.prepareStatement("SELECT NOM, PRENOM, ID FROM JOUEUR WHERE ID= ?");
            // l'exécution de la requete
            long identifiant = 14L;
            ps.setLong(1, identifiant);
            ResultSet rs = ps.executeQuery();
            // lire la ligne en mettant le curseur sur la ligne
            while (rs.next()) {
                final String nomDuJoueur = rs.getString("NOM");
                final String prenomDuJoueur = rs.getString("PRENOM");
                System.out.printf("Le joueur qu'il a l'ID numero : %d  est %s %s",
                        identifiant,
                        prenomDuJoueur,
                        nomDuJoueur+ "\n");
            }


            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // la déconnection quelque soit le déroulement de la connecxion
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


