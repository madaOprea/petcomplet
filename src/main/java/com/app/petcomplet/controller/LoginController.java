package com.app.petcomplet.controller;

import com.app.petcomplet.utils.ViewUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class LoginController {

    @FXML private Label wrongLoginLabel;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordPasswordField;
    @FXML private Button loginButton;

    private AdminController adminController;
    private Scene adminScene;
    String username, password;

    @FXML
    public void userLogin(ActionEvent actionEvent) throws IOException {
        username = usernameTextField.getText();
        password = passwordPasswordField.getText();

        ViewUtils viewUtils = new ViewUtils();

        if(isValidCredentials(username, password)) {
            loginButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
//                    URL fxmlLocation = this.getClass().getResource("admin-view.fxml");
                    viewUtils.changeScene(actionEvent, "admin-view.fxml");
                }
            });
        } else if(username.isEmpty() && password.isEmpty()) {
                wrongLoginLabel.setText("Please enter your data.");
        } else {
            clearFields();
            wrongLoginLabel.setText("Wrong username or password!");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals("test") && password.equals("test");
    }

    public void clearFields() {
        usernameTextField.setText("");
        passwordPasswordField.setText("");
    }
}