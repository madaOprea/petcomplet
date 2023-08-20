package com.app.petcomplet.controller;

import com.app.petcomplet.PetcompletApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/com.app.petcomplet.login-view.fxml")
public class LoginController extends BaseScreenController implements Initializable {

    @FXML private Label wrongLoginLabel;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordPasswordField;
    @FXML private Button loginButton;

    private AdminController adminController;
    private Scene adminScene;
    String username, password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.screenName.setText("Screen1");
    }

    @FXML
    public void userLogin() {
        username = usernameTextField.getText();
        password = passwordPasswordField.getText();
        loginButton.setOnAction(event -> {
            if(isValidCredentials(username, password)) {
                PetcompletApplication app = new PetcompletApplication();
                    this.sc.loadScreen("/fxml/login-view.fxml");
            } else if(username.isEmpty() && password.isEmpty()) {
                wrongLoginLabel.setText("Please enter your data.");
            } else {
                clearFields();
                wrongLoginLabel.setText("Wrong username or password!");
            }
        });
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals("test") && password.equals("test");
    }

    public void clearFields() {
        usernameTextField.setText("");
        passwordPasswordField.setText("");
    }
}