package com.example.paul.projetgsb;

/**
 * Created by Paul on 10/11/2016.
 */
//Création de la classe GlycemieInsuline
public class GlycemieInsuline {
    private double glycemieInf;
    private double glycemieSup;
    private int insuline;

    //Constructeur de la glycemieInsuline
    public GlycemieInsuline(double uneGlycemieInf, double uneGlycemieSup, int uneInsuline)
    {
        this.glycemieInf = uneGlycemieInf;
        this.glycemieSup = uneGlycemieSup;
        this.insuline = uneInsuline;
    }
    //Accesseurs
    public double getGlycemieInf()	{return this.glycemieInf;}
    public double getGlycemieSup()	{return this.glycemieSup;}
    public int getInsuline()	{return this.insuline;}
}
