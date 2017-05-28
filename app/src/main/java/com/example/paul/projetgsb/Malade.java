package com.example.paul.projetgsb;

/**
 * Created by Paul on 10/11/2016.
 */
//Création de la classe Malade
public class
Malade {
    private int id;
    private String nom;
    private String prenom;
    private double glycemie;

    //Création du constructeur Malade
    public Malade(String unNom, String unPrenom, double uneGlycemie){
        this.nom = unNom;
        this.prenom = unPrenom;
        this.glycemie = uneGlycemie;
    }
    //Création des accesseurs et mutateurs
    public int getId() {
        return this.id;
    }
    public void setId(int unId){
        this.id = unId;
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public double getGlycemie() {
        return this.glycemie;
    }

}
