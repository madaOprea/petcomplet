package com.app.petcomplet.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewUtils {

    public void changeScene(ActionEvent event, String fxml) {

        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ViewUtils.class.getResource(fxml));
            root = fxmlLoader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}
