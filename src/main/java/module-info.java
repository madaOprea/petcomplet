module com.app.petcomplet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires spring.beans;
    requires spring.boot.starter.web;
    requires spring.boot.starter.data.jpa;
    requires spring.boot.autoconfigure;
    requires jakarta.persistence;
    requires lombok;
    requires spring.data.jpa;
    requires spring.context;
    requires spring.web;
    requires spring.boot;
    requires net.rgielen.fxweaver.core;
    requires java.validation;

    opens com.app.petcomplet;
    opens com.app.petcomplet.controller to javafx.fxml;
    opens com.app.petcomplet.model to javafx.fxml;
    opens com.app.petcomplet.service to javafx.fxml;
    opens com.app.petcomplet.utils to javafx.fxml;

    exports com.app.petcomplet;
    exports com.app.petcomplet.controller;
    exports com.app.petcomplet.configuration;
    exports com.app.petcomplet.utils;
}