package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Module;

public class ModuleRepository {
    public List<Module> selectAll() {
        List<Module> modules = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java\r\n" + //
                                "", "root", "");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM module");
            while (rs.next()) {
                Module module = new Module();
                module.setId(rs.getInt("id"));
                module.setNom(rs.getString("nom"));
                modules.add(module);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
        }
        return modules;
    }

    public void insert(Module module) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java\r\n" + //
                                "", "root", "");
            Statement statement = conn.createStatement();

            String sql = String.format("INSERT INTO module (nom) " +
                    "VALUES ('%s')",
                    module.getNom());

            int nbreLigne = statement.executeUpdate(sql);
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
        }
    }

   
}
