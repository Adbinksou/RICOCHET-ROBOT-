package com.example.projet_java.entities;

public class DestinationJeton extends Jeton {

    int posx;
    int posy;
    String couleur;

    public DestinationJeton(int id, int posx, int posy, String path,String couleur) {

        this.id = id;
        this.posx = posx;
        this.posy = posy;
        this.path = path;
        this.couleur = couleur;

    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public String getCouleur() {
        return couleur;
    }

}
