package com.app.petcomplet.utils;

import com.app.petcomplet.controller.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

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

            AdminController adminController = fxmlLoader.getController();
            //adminController.saveNewAppointment();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}
