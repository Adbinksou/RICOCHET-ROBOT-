package com.example.projet_java;

import com.example.projet_java.components.Cellule;
import com.example.projet_java.entities.DestinationJeton;
import com.example.projet_java.entities.JetonTirage;
import com.example.projet_java.entities.Robot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.example.projet_java.jeu.Jeu;

import static java.lang.Math.abs;
import static com.example.projet_java.jeu.Jeu.choisirJeton;


public class HelloController {
    @FXML
    int nombreJoueurs=1;
    public static final int WIDTH = 16;

    public static final int SCREEN_SIZE = 760;


    GridPane root;


    Label labelJoueurs;

    Robot robotSelected;

    ImageView imageSelectionnee;



    Image pionDefaut = new Image(getClass().getResourceAsStream("/img/pion_bleu.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);


    Image caseVide = new Image(getClass().getResourceAsStream("/img/case_vide.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur1 = new Image(getClass().getResourceAsStream("/img/case_mur1.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur2 = new Image(getClass().getResourceAsStream("/img/case_mur2.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur3 = new Image(getClass().getResourceAsStream("/img/case_mur3.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur4 = new Image(getClass().getResourceAsStream("/img/case_mur4.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);


    Image caseMur12 = new Image(getClass().getResourceAsStream("/img/case_mur12.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);

    Image caseMur14 = new Image(getClass().getResourceAsStream("/img/case_mur14.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);

    Image caseMur23 = new Image(getClass().getResourceAsStream("/img/case_mur23.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);

    Image caseMur34 = new Image(getClass().getResourceAsStream("/img/case_mur34.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur1234 = new Image(getClass().getResourceAsStream("/img/case_mur1234.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);





    @FXML
    private Label nombreJoueur;

    @FXML
    protected void onPlayButtonClick(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();


        Stage stage = new Stage();

        root = new GridPane();

        root.setHgap(1);
        root.setVgap(1);



        Cellule[][] plateau = Jeu.plateau;
        ImageView image;
        Cellule celluleActuelle;


        for (int k = 0; k < WIDTH; k++) {
            for (int j = 0; j < WIDTH; j++) {

                celluleActuelle = plateau[j][k];

                if (!celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseVide);
                } else if (celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur4);
                } else if (celluleActuelle.isMurHaut() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur2);
                } else if (celluleActuelle.isMurGauche() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurHaut()) {
                    image = new ImageView(caseMur1);
                } else if (celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur3);
                } else if (celluleActuelle.isMurGauche() && celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas()) {
                    image = new ImageView(caseMur12);
                } else if (celluleActuelle.isMurGauche() && celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurHaut()) {
                    image = new ImageView(caseMur14);
                } else if (celluleActuelle.isMurHaut() && celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur23);
                } else if (celluleActuelle.isMurDroit() && celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur34);
                } else {
                    image = new ImageView(caseMur1234);
                }

                root.add(image, k, j);
            }
        }


        JetonTirage jetonActuel;
        jetonActuel = choisirJeton();
        System.out.println(jetonActuel.getPath());

        Image jeton = new Image(getClass().getResourceAsStream("/img/"+ jetonActuel.getPath() + ".png"), (SCREEN_SIZE / 17), (SCREEN_SIZE / 17), false, false);
        image = new ImageView(jeton);
        root.add(image,0 , 17);



            // CREER
            for (Robot robot : Jeu.robots) {

                ImageView imageRobots = new ImageView(new Image(getClass().getResourceAsStream("/img/"+robot.getPath()+".png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false));


                imageRobots.setOnMouseClicked(mouseEvent -> {
                    robotSelected = robot;
                    imageSelectionnee = imageRobots;
                    int i =0;
                });

                root.add(imageRobots,robot.getPositionX(),robot.getPositionY());
            }
//

            for (DestinationJeton destinationJeton : Jeu.destinationJetons) {

                image = new ImageView(new Image(getClass().getResourceAsStream("/img/"+destinationJeton.getPath()+".png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false)); // TODO : CHANGER PAR PATH

                root.add(image,destinationJeton.getPosx(),destinationJeton.getPosy());
            }


//            animate(player,0, 0, 2, 0);
//            root.add(this.player, 0, 0);

            System.out.println(root.getScene());

            Scene scene = new Scene(root, SCREEN_SIZE, SCREEN_SIZE);

            stage.setTitle("Ricochet Robots!");
            scene.setFill(Color.web("#006AF9"));
            stage.setScene(scene);

            stage.show();



            scene.setOnKeyPressed(keyEvent -> {

                if (robotSelected != null) {
                    int[] nouvellePosition;

                    switch (keyEvent.getCode()) {
                        case UP:
                            nouvellePosition = Jeu.deplacement(robotSelected,2);
                            Jeu.nbrCoup +=1;
                            System.out.println("Nombre de coup :" +Jeu.nbrCoup);
                            break;

                        case DOWN:
                            nouvellePosition = Jeu.deplacement(robotSelected,4);
                            Jeu.nbrCoup +=1;
                            System.out.println("Nombre de coup :" +Jeu.nbrCoup);
                            break;


                        case LEFT:
                            nouvellePosition = Jeu.deplacement(robotSelected,1);
                            Jeu.nbrCoup +=1;
                            System.out.println("Nombre de coup :" +Jeu.nbrCoup);
                            break;

                        case RIGHT:
                            nouvellePosition = Jeu.deplacement(robotSelected,3);
                            Jeu.nbrCoup +=1;
                            System.out.println("Nombre de coup :" +Jeu.nbrCoup);
                            break;
                        default:
                            nouvellePosition = new int[]{0, 0};
                            Jeu.nbrCoup +=1;
                            System.out.println("Nombre de coup :" + Jeu.nbrCoup);
                            break;
                    }


                    System.out.println("Position actuelle : "+robotSelected.getPositionX()+" "+robotSelected.getPositionY());
                    System.out.println("Nouvelle position : "+nouvellePosition[0]+ " "+ nouvellePosition[1]);


                    animate(imageSelectionnee,robotSelected.getPositionX(),robotSelected.getPositionY(),nouvellePosition[0],nouvellePosition[1]);
                    robotSelected.setPositionX(nouvellePosition[0]);
                    robotSelected.setPositionY(nouvellePosition[1]);

                    Jeu.verifJeton(robotSelected);
                }


            });

        }



    @FXML
    protected void onAddButtonClick(){
        nombreJoueurs++;
        nombreJoueur.setText("Nombre de joueurs : " +nombreJoueurs);
    }

    @FXML
    protected void onDecreaseButtonClick(){
        nombreJoueurs = nombreJoueurs>1 ? nombreJoueurs-1 : 1;
        nombreJoueur.setText("Nombre de joueurs : " +nombreJoueurs);
    }

    private void animate(ImageView entite ,int posxDebut,int posyDebut,int posx, int posy) {

//        double xDebut = entite.getLayoutX(); double yDebut = entite.getLayoutY(); //measure new location
//
//        root.getChildren().remove(entite);
//
//        root.add(entite, abs(posx), abs(posy));
//        root.layout();
//
//        double x = entite.getLayoutX();
//        double y = entite.getLayoutY();
//
//
//
//
//        root.getChildren().remove(entite);
//        root.add(entite, posxDebut, posyDebut);
//        entite.setVisible(true);
//
//
//        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1),entite);
//
//        if (posx == posxDebut){
//            translateTransition.setToY(posy-posyDebut>0 ? y : -y);
//        }
//        else if(posy == posyDebut){
//            translateTransition.setToX(posx-posxDebut>0 ?  x : -x);
//        }
//
//
//
//        translateTransition.play();
//
//        translateTransition.setOnFinished(e->{
//            root.getChildren().remove(entite);
//            entite.setTranslateX(0);
//            entite.setTranslateY(0);
//            root.add(entite, posx, posy);
//        });

        root.getChildren().remove(entite);

        root.add(entite, posx, posy);
    }

}
