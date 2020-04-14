package com.avatarduel.gui.loader;

import com.avatarduel.AvatarDuel;
import com.avatarduel.gui.controller.FieldPlayer2Controller;
import com.avatarduel.model.field.CardField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FieldPlayer2Loader implements Loader{
    Pane field;

    public FieldPlayer2Loader(CardField cards) throws Exception {
        // init loader
        FXMLLoader loader = new FXMLLoader(AvatarDuel.class.getResource("fxml/fieldPlayer2.fxml"));

        FieldPlayer2Controller controller = new FieldPlayer2Controller(cards);
        loader.setController(controller);
        // make stage
        this.field = loader.load();

    }

    public Pane getPane() {
        return field;
    }

    public void render() {
        Stage stage = new Stage();
        Scene scene = new Scene(field, 717, 180);
        stage.setScene(scene);
        stage.setTitle("Avatar Card Game");
        stage.show();
    }
    
}

