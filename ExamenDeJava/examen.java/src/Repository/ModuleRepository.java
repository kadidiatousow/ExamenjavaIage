package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Module;


public class ModuleRepository {
        public  List<Module> selectAll(){
            List<Module> modules=new ArrayList<>();
          try {
             
             Class.forName("com.mysql.cj.jdbc.Driver");
             
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                       , "root", "");
             
              Statement statement = conn.createStatement();
              
              ResultSet rs=   statement.executeQuery("select * from module");
                while (rs.next()) {
                  //Une ligne du ResultSet ==> Une Agence
                    Module md=new Module();
                    md.setId(rs.getInt("id"));
                    md.setNom(rs.getString("nom"));
                    
                }
                rs.close();
                conn.close();
           } catch (ClassNotFoundException e) {
             System.out.println("Erreur de chargement de Driver");
           }
          catch (SQLException e) {
           System.out.println("Erreur de Connexion a la BD");
         }
           return  modules;
       }
       public  Module selectById(int id){
           Module md=null;
        try {
           //1-Chargement du Driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           //2-Se Connecter a une BD
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                     , "root", "");
           //3-Execution et Recuperation
            Statement statement = conn.createStatement();
            ResultSet rs=   statement.executeQuery("select * from agence where numero_ag like '"+id+"'");
              if (rs.next()) {
                  //Une ligne du ResultSet ==> Une Agence
                    md=new Module();
                    md.setId(rs.getInt("id"));
                    md.setNom(rs.getString("nom"));
                   
              }
              rs.close();
              conn.close();
         } catch (ClassNotFoundException e) {
             System.out.println("Erreur de chargement de Driver");
         }
        catch (SQLException e) {
           System.out.println("Erreur de Connexion a la BD");
       }
         return  md;
        }
      
       public  void insert(Module module){
        try {
            
             Class.forName("com.mysql.cj.jdbc.Driver");
             
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                       , "root", " ");
               
                Statement statement = conn.createStatement();
               
                int nbreLigne=statement.executeUpdate("INSERT INTO module (id, nom) VALUES ('"+module.getId()+"', '"+module.getNom()+"')");
                conn.close();
           } catch (ClassNotFoundException e) {
               System.out.println("Erreur de chargement de Driver");
           }
          catch (SQLException e) {
             System.out.println("Erreur de Connexion a la BD");
         }
        }
}
