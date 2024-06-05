package Entities;

import java.util.ArrayList;
import java.util.List;

public class Module {
    private int id;
    private String Nom;
    private List<Cours> cour =new ArrayList<>();
    public List<Cours> getCour() {
        return cour;
    }
    public void setCour(List<Cours> cour) {
        this.cour = cour;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    } 
   
}
