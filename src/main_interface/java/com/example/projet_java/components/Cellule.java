package com.example.projet_java.components;

public class Cellule {
    boolean murHaut;
    boolean murDroit;
    boolean murBas;
    boolean murGauche;


    public void setMurHaut(boolean murHaut) {
        this.murHaut = murHaut;
    }

    public void setMurDroit(boolean murDroit) {
        this.murDroit = murDroit;
    }

    public void setMurBas(boolean murBas) {
        this.murBas = murBas;
    }

    public void setMurGauche(boolean murGauche) {
        this.murGauche = murGauche;
    }


    public boolean isMurHaut() {
        return murHaut;
    }

    public boolean isMurDroit() {
        return murDroit;
    }

    public boolean isMurBas() {
        return murBas;
    }

    public boolean isMurGauche() {
        return murGauche;
    }



}
