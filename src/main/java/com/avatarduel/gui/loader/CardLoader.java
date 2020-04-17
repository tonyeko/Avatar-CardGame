package com.avatarduel.gui.loader;

import com.avatarduel.AvatarDuel;
import com.avatarduel.gui.controller.CardController;
import com.avatarduel.model.card.Card;
import com.avatarduel.model.card.Skill;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import com.avatarduel.util.Constants;
import java.util.List;

public class CardLoader implements Loader {
    Pane card;
    CardController controller;

    public CardLoader(Card card) throws IOException {
        // init loader
        FXMLLoader loader = new FXMLLoader(AvatarDuel.class.getResource(Constants.cardFxml));
        CardController controller = new CardController(card);
        loader.setController(controller);
        // make stage
        this.card = loader.load();

    }

    public Pane getPane() {
        return card;
    }

    public void render() {
        Stage stage = new Stage();
        Scene scene = new Scene(card, 480, 640);
        stage.setScene(scene);
        stage.show();
    }

    public void setSkillAttached(List<Skill> skillAttached) {
        controller.addSkillAttached(skillAttached);
    }
}
