package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.avatarduel.Cards;

import com.avatarduel.model.Card;
import com.avatarduel.model.Character;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class AvatarDuel extends Application {
  boolean endGame;

//  private

  public void drawPhase(Player P) {

  }

  public void turn(Player P) {

  }


  @Override
  public void start(Stage stage) throws IOException, URISyntaxException {
    endGame = false;

    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);

    Group root = new Group();

    root.getChildren().add(text);
    Scene scene = new Scene(root, 1280, 720);

    stage.setTitle("Avatar Duel");
    stage.setScene(scene);
    stage.show();


    try {
      Cards c = Cards.getInstance();
      Player P1 = new Player(c.makeDeck());
//      Player P2 = new Player(c.makeDeck());
      P1.takeCardFromDeck();
//      P1.resetPower();
      P1.getCardsInHand().stream().forEach(o -> System.out.println(o.getName() + "\t||\t" + o.getDescription() + "\t||\t" + o.getElement() + "\t||\t" + o.getClass()));
      P1.getCardsInHand().stream().filter(o -> o instanceof com.avatarduel.model.Character).forEach(o-> System.out.println(o.getName() + " ATTACK: "+ o.activate("attack")));

      CharacterField f = new CharacterField();
      for (Card o : P1.getCardsInHand()) {
        if (o instanceof com.avatarduel.model.Character) {
          f.placeCard(1, o, true);
        }
      }
    } catch (Exception e) {
      text.setText("Failed to load cards: " + e);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}