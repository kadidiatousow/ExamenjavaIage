package Entities;


import java.time.LocalDate;
import java.time.LocalTime;

public class Cours {
    private int id;
    private LocalDate date;
    private LocalTime heuredebut;
    private LocalTime heurefin;
    private String professeur;
    private String module;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getHeuredebut() {
        return heuredebut;
    }
    public void setHeuredebut(LocalTime heuredebut) {
        this.heuredebut = heuredebut;
    }
    public LocalTime getHeurefin() {
        return heurefin;
    }
    public void setHeurefin(LocalTime heurefin) {
        this.heurefin = heurefin;
    }
    public String getProfesseur() {
        return professeur;
    }
    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    
    
    
}
