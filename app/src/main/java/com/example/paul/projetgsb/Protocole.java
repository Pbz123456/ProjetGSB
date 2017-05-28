package com.example.paul.projetgsb;

import java.util.ArrayList;

/**
 * Created by Paul on 10/11/2016.
 */
//Création de la classe protocole
public class Protocole {

    private int numeroProtocole;
    private ArrayList<GlycemieInsuline> lesGlycemieInsuline;


//Création du constructeur Protocole
    public Protocole(int unNumero)	{
        this.numeroProtocole = unNumero;
        lesGlycemieInsuline = new ArrayList<GlycemieInsuline>();
    }
//Accesseur du numero Protocole
    public int getNumeroProtocole()	{
        return this.numeroProtocole;
    }

// Création de la fonction ajouter
    public void ajouter(GlycemieInsuline uneGlycemieInsuline)	{
        this.lesGlycemieInsuline.add(uneGlycemieInsuline);
    }
    //Renvoie le nombre d'unités d'insuline en fonction de la glycémie
    public int insuline(double uneGlycemie)	{
        int retour=0;
        for  (GlycemieInsuline a : lesGlycemieInsuline){
            if (uneGlycemie>=a.getGlycemieInf()&& uneGlycemie<=a.getGlycemieSup())
               retour=a.getInsuline() ;
        }
        return retour;

    }

}
