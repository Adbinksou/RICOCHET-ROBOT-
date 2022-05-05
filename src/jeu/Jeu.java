package jeu;

import com.example.projet_java.HelloApplication;
import components.Cellule;
import entities.DestinationJeton;
import entities.Joueur;
import entities.Robot;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Jeu {


    static Input input;
    static Joueur joueur1;
    static Joueur joueur2;
    static int taillePlateau = 16;

    public static Cellule[][] plateau;
    public static Robot[] robots;
    public static List<DestinationJeton> destinationJetons;


    public static void main(String[] args) {

//        genererMenu();


        genererRobots();
        genererPlateau();
        destinationJeton();



        HelloApplication.main(args);
    }

    private static void destinationJeton() {
        DestinationJeton destinationJetonJauneCercle = new DestinationJeton(1,11,6);
        DestinationJeton destinationJetonJauneTriangle = new DestinationJeton(2,1,6);
        DestinationJeton destinationJetonJauneCarre = new DestinationJeton(3,6,14);
        DestinationJeton destinationJetonJaunePenta = new DestinationJeton(4,9,12);
        DestinationJeton destinationJetonBleuCercle = new DestinationJeton(5,5,1);
        DestinationJeton destinationJetonBleuTriangle = new DestinationJeton(6,9,1);
        DestinationJeton destinationJetonBleuCarre = new DestinationJeton(7,11,9);
        DestinationJeton destinationJetonBleuPenta = new DestinationJeton(8,2,10);
        DestinationJeton destinationJetonVertCercle = new DestinationJeton(9,4,13);
        DestinationJeton destinationJetonVertTriangle = new DestinationJeton(10,12,14);
        DestinationJeton destinationJetonVertCarre = new DestinationJeton(11,6,5);
        DestinationJeton destinationJetonVertPenta = new DestinationJeton(12,14,5);
        DestinationJeton destinationJetonRougeCercle = new DestinationJeton(13,14,11);
        DestinationJeton destinationJetonRougeTriangle = new DestinationJeton(14,5,8);
        DestinationJeton destinationJetonRougeCarre = new DestinationJeton(15,13,1);
        DestinationJeton destinationJetonRougePenta = new DestinationJeton(16,3,4);

        destinationJetons = List.of(destinationJetonJauneCercle,
                destinationJetonJauneTriangle,
                destinationJetonJauneCarre,
                destinationJetonJaunePenta,
                destinationJetonBleuCercle,
                destinationJetonBleuTriangle,
                destinationJetonBleuCarre,
                destinationJetonBleuPenta,
                destinationJetonVertCercle,
                destinationJetonVertTriangle,
                destinationJetonVertCarre,
                destinationJetonVertPenta,
                destinationJetonRougeCercle,
                destinationJetonRougeTriangle,
                destinationJetonRougeCarre,
                destinationJetonRougePenta);

    }

    public static int[] deplacement(Robot robot,int choix){
        int positionXBase = robot.getPositionX();
        int positionYBase = robot.getPositionY();


        System.out.println("choix : " + choix);
        if(choix==1){

            while(!plateau[positionYBase][positionXBase].isMurGauche() && !plateau[positionYBase][positionXBase-1].isMurDroit()){
                positionXBase-=1;;
            }
        }

        else if(choix==2){

            while(!plateau[positionYBase][positionXBase].isMurHaut() && !plateau[positionYBase-1][positionXBase].isMurBas()){
                positionYBase-=1;
            }
        }
        else if (choix==3){
            while(!plateau[positionYBase][positionXBase].isMurDroit() && !plateau[positionYBase][positionXBase+1].isMurGauche()){
                positionXBase+=1;
            }

        }
        else if (choix==4){
            while(!plateau[positionYBase][positionXBase].isMurBas() && !plateau[positionYBase+1][positionXBase].isMurHaut()){
                positionYBase+=1;
            }
        }

        int[] listPosition = {positionXBase,positionYBase};
        return listPosition;
    }









    private static void genererRobots() {
        robots = new Robot[4];
        Random random = new Random();
        int x;
        int y;

        List<String> couleurs = List.of("r","v","b","j");

        for (int i=0; i<4;i++){
            x = random.nextInt(0,taillePlateau-1);
            y = random.nextInt(0,taillePlateau-1);
            robots[i] = new Robot(x,y,couleurs.get(i));
        }
    }


    public static void genererPlateau(){
        plateau = new Cellule[taillePlateau][taillePlateau];

        for(int i =0;i<taillePlateau;i++){
            for(int j =0;j<taillePlateau;j++){
                plateau[i][j]=new Cellule();
            }
        }



//      MURS CONTOUR
        for (int i=0;i<taillePlateau;i++){
            int dernierePosition = taillePlateau-1;

            plateau[0][i].setMurHaut(true);
            plateau[dernierePosition][i].setMurBas(true);

            plateau[i][0].setMurGauche(true);
            plateau[i][dernierePosition].setMurDroit(true);
        }

//      MURS PRES DU CONTOUR

        //        Murs du haut
        plateau[0][2].setMurDroit(true);
        plateau[0][11].setMurDroit(true);

        //        Murs à droite
        plateau[3][taillePlateau-1].setMurBas(true);
        plateau[8][taillePlateau-1].setMurBas(true);

        //        Murs en bas
        plateau[taillePlateau-1][4].setMurDroit(true);
        plateau[taillePlateau-1][13].setMurDroit(true);

        //        Murs à gauche
        plateau[3][0].setMurBas(true);
        plateau[11][0].setMurBas(true);

        //        Murs RICHARD

        plateau[1][5].setMurBas(true);
        plateau[1][5].setMurGauche(true);

        plateau[1][13].setMurHaut(true);
        plateau[1][13].setMurGauche(true);

        plateau[2][7].setMurBas(true);
        plateau[2][7].setMurDroit(true);

        plateau[1][9].setMurBas(true);
        plateau[1][9].setMurDroit(true);

        plateau[4][3].setMurBas(true);
        plateau[4][3].setMurDroit(true);

        plateau[5][6].setMurHaut(true);
        plateau[5][6].setMurGauche(true);

        plateau[5][14].setMurBas(true);
        plateau[5][14].setMurGauche(true);

        plateau[6][1].setMurHaut(true);
        plateau[6][1].setMurDroit(true);

        plateau[6][11].setMurHaut(true);
        plateau[6][11].setMurDroit(true);

        //      CELLULES CENTRALES

        plateau[7][7].setMurHaut(true);
        plateau[7][7].setMurDroit(true);
        plateau[7][7].setMurBas(true);
        plateau[7][7].setMurGauche(true);

        plateau[7][8].setMurHaut(true);
        plateau[7][8].setMurDroit(true);
        plateau[7][8].setMurBas(true);
        plateau[7][8].setMurGauche(true);

        plateau[8][8].setMurHaut(true);
        plateau[8][8].setMurDroit(true);
        plateau[8][8].setMurBas(true);
        plateau[8][8].setMurGauche(true);

        plateau[8][7].setMurHaut(true);
        plateau[8][7].setMurDroit(true);
        plateau[8][7].setMurBas(true);
        plateau[8][7].setMurGauche(true);

        //      Murs AD

        plateau[8][5].setMurBas(true);
        plateau[8][5].setMurDroit(true);

        plateau[9][11].setMurBas(true);
        plateau[9][11].setMurGauche(true);

        plateau[10][2].setMurHaut(true);
        plateau[10][2].setMurDroit(true);

        plateau[11][14].setMurHaut(true);
        plateau[11][14].setMurDroit(true);

        plateau[12][9].setMurHaut(true);
        plateau[12][9].setMurGauche(true);

        plateau[13][4].setMurHaut(true);
        plateau[13][4].setMurGauche(true);

        plateau[14][6].setMurBas(true);
        plateau[14][6].setMurGauche(true);

        plateau[14][12].setMurBas(true);
        plateau[14][12].setMurDroit(true);



    }



}
