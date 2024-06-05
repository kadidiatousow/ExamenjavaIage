package Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Entities.Cours;


public class CoursRepository {
   public void insert(Cours cour){
        try {
    
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                    , "root", " ");
            Statement statement = conn.createStatement();
            
             String sql=String.format("INSERT INTO `cours` (`date`, `heuredebut`, `heurefin`, `professeur`,`module`) "
                      + " VALUES ('%s', '%s', '%s','%s','%s')",
                      cour.getDate(),cour.getHeuredebut(),cour.getHeurefin());
             int nbreLigne=statement.executeUpdate(sql);
             statement.close();
             conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        }
       catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
      }
      }

      
      public  List<Cours> selectAll(){
        List<Cours> cour=new ArrayList<>();
      try {
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                   , "root", "");
         
          Statement statement = conn.createStatement();
          
          ResultSet rs=   statement.executeQuery("select * from cour");
            while (rs.next()) {
              //Une ligne du ResultSet ==> Une Agence
                Cours cr=new Cours();
                cr.setId(rs.getInt("id"));
                cr.setDate(rs.getDate("date").toLocalDate());
                cr.setHeuredebut(rs.getTime("heuredebut").toLocalTime());
                cr.setModule(rs.getString("module"));
                cr.setProfesseur(rs.getString("professeur"));
                
            }
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
         System.out.println("Erreur de chargement de Driver");
       }
      catch (SQLException e) {
       System.out.println("Erreur de Connexion a la BD");
     }
       return  cour;
   }    
      
}
