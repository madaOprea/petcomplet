package com.app.petcomplet.controller;

import com.app.petcomplet.configuration.*;
import com.app.petcomplet.utils.FXMLUtils;
import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import javafx.util.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;

import java.io.IOException;
import java.util.*;

public class ScreensController implements ApplicationContextAware {

    @Autowired
    ScreenScope screenScope;

    private ApplicationContext applicationContext;
    private Stage stage;
    private String currentScreenId;
    private final Map<String, BaseScreenController> screens = Collections.synchronizedMap(new HashMap<String, BaseScreenController>());

    public void init(Stage stage) {
        this.stage = stage;
        Group root = new Group();
        this.stage.setScene(new Scene(root));

    }

    public void loadScreen(String fxml) {
        BaseScreenController oldScreenController = this.getCurrentController();
        try {

            Class controllerClass = FXMLUtils.getControllerClass(fxml);
            final BaseScreenController fxmlController = (BaseScreenController) applicationContext.getBean(controllerClass);

            if (this.screens.get(fxmlController.getScreenId()) == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
                loader.setControllerFactory(new Callback<Class<?>, Object>() {
                    @Override
                    public Object call(Class<?> aClass) {
                        return fxmlController;
                    }
                });
                Parent root = loader.load();
                fxmlController.setRoot(root);
                this.screens.put(fxmlController.getScreenId(), fxmlController);
            }

            this.currentScreenId = fxmlController.getScreenId();
            swapScreen(getCurrentController().getRoot());
            if (oldScreenController != null) {
                if (oldScreenController.getClass().isAnnotationPresent(ScreenScoped.class)) {
                    this.screens.remove(oldScreenController.getScreenId());
                    this.screenScope.remove(oldScreenController.getScreenId());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean swapScreen(final Parent root) {
        final Group rootGroup = getScreenRoot();
        final DoubleProperty opacity = rootGroup.opacityProperty();
        if (!isScreenEmpty()) {

            Timeline fade = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                    new KeyFrame(new Duration(250), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            rootGroup.getChildren().remove(0);

                            rootGroup.getChildren().add(0, root);
                            Timeline fadeIn = new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                    new KeyFrame(new Duration(350), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        }
                    }, new KeyValue(opacity, 0.0)));
            fade.play();
            return true;
        } else {
            opacity.set(0.0);
            rootGroup.getChildren().add(0, root);
            Timeline fadeIn = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                    new KeyFrame(new Duration(350), new KeyValue(opacity, 1.0)));
            fadeIn.play();
        }

        if (!this.stage.isShowing()) {
            this.stage.show();
        }
        return true;
    }

    private Group getScreenRoot() {
        return (Group) this.stage.getScene().getRoot();
    }

    private boolean isScreenEmpty() {
        return getScreenRoot().getChildren().isEmpty();
    }

    public BaseScreenController getCurrentController() {
        return screens.get(getCurrentScreenId());
    }

    public String getCurrentScreenId() {
        return currentScreenId;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
