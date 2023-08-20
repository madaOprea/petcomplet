package com.app.petcomplet;

import com.app.petcomplet.configuration.AppContextConfig;
import com.app.petcomplet.controller.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.app.petcomplet", "com.app.petcomplet.controller"},
		basePackageClasses={PetcompletApplication.class, LoginController.class})
public class PetcompletApplication extends Application {

	private ConfigurableApplicationContext applicationContext;

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);
		ScreensController bean = context.getBean(ScreensController.class);
		bean.init(primaryStage);

		bean.loadScreen("/fxml/login-view.fxml");
	}

	@Override
	public void stop() throws Exception{
		// Close the Spring context
		applicationContext.close();
	}

	public static void main(String[] args) {
		launch();
	}}
