package com.app.petcomplet.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseScreenController implements Initializable, BeanNameAware {

    protected String screenId;
    @Autowired
    protected ScreensController sc;
    protected Parent root;


    @FXML
    protected Label screenName;

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    @Override
    public void setBeanName(String name) {
        this.screenId = name;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }
}