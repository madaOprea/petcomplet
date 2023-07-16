package com.app.petcomplet.controller;

import com.app.petcomplet.model.*;
import com.app.petcomplet.service.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @FXML private Button logoutButton;
    @FXML private Button saveButton;
    @FXML private TextField ownerNameTextField;
    @FXML private TextField petNameTextField;
    @FXML private TextField breedTextField;
    @FXML private TextArea issuesBoxTextArea;

    @FXML private BorderPane adminBorderPane;

    private final PetService petService;
    private static LoginController loginController;

    @Autowired
    public AdminController(PetService petService) {
        this.petService = petService;
    }

    public static void setLoginController(LoginController loginController) {
        AdminController.loginController = loginController;
    }

    @FXML
    public void userLogout() {

    }

    @FXML
    @PostMapping("/save")
    public void saveNewAppointment() {
        Pet pet = new Pet();
        pet.setName("testttt");
        pet.setBreed("testttt");
        petService.save(pet);
    }
}
