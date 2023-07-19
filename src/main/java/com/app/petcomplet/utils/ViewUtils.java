package com.app.petcomplet.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewUtils {

    public void changeScene(ActionEvent event, String fxml) {

        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ViewUtils.class.getResource(fxml));
            root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
