package com.example.projet_java;

import com.example.projet_java.components.Cellule;
import com.example.projet_java.entities.Robot;
import com.example.projet_java.jeu.Jeu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JeuTests {

    /**
     * Test qui vérifie si le déplacement en haut fonctionne comme il faut
     */
    @Test
    public void deplacementHautTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(15,15,"v","");

        int[] posExpected = {15,9};


        int[] posExperimentale = Jeu.deplacement(robot,2);

        Assertions.assertArrayEquals(posExperimentale,posExpected);
    }


    /**
     * Test qui vérifie si le déplacement en bas fonctionne comme il faut
     */
    @Test
    public void deplacementBasTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(0,0,"v","");

        int[] posExpected = {0,3};


        int[] posExperimentale = Jeu.deplacement(robot,4);

        Assertions.assertArrayEquals(posExperimentale,posExpected);
    }

    /**
     * Test qui vérifie si le déplacement à gauche fonctionne comme il faut
     */
    @Test
    public void deplacementGaucheTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(15,7,"v","");

        int[] posExpected = {9,7};

        int[] posExperimentale = Jeu.deplacement(robot,1);

        Assertions.assertArrayEquals(posExperimentale,posExpected);
    }

    /**
     * Test qui vérifie si le déplacement à droite fonctionne comme il faut
     */
    @Test
    public void deplacementDroitTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(10,2,"v","");

        int[] posExpected = {15,2};

        int[] posExperimentale = Jeu.deplacement(robot,3);

        Assertions.assertArrayEquals(posExperimentale,posExpected);
    }



}
