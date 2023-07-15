package com.app.petcomplet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetcompletApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/app/petcomplet/login-view.fxml"));

			Parent root = fxmlLoader.load();
//			LoginController loginController = fxmlLoader.getController();
			Scene scene = new Scene(root);
			scene.setFill(Color.TRANSPARENT);

			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			primaryStage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
