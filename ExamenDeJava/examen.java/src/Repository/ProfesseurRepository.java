package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Professeur;

public class ProfesseurRepository {

     public  List<Professeur> selectAll(){
        List<Professeur> professeur=new ArrayList<>();
      try {
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                   , "root", "");
         
          Statement statement = conn.createStatement();
          
          ResultSet rs=   statement.executeQuery("select * from professeur");
            while (rs.next()) {
              
                Professeur pr=new Professeur();
                pr.setId(rs.getInt("id"));
                pr.setNom(rs.getString("nom"));
                pr.setPrenom(rs.getString("prenom"));
                pr.setTel(rs.getString("tel"));
                
                
            }
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
         System.out.println("Erreur de chargement de Driver");
       }
      catch (SQLException e) {
       System.out.println("Erreur de Connexion a la BD");
     }
       return  professeur;
   }    


   
}
   