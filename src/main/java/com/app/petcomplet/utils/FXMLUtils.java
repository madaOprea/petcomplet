package com.app.petcomplet.utils;

import com.app.petcomplet.controller.*;
import javafx.fxml.FXMLLoader;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.net.*;
import java.util.logging.*;

public class FXMLUtils {
    public static Class getControllerClass(String fxmlPath) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            URL location = FXMLUtils.class.getResource(fxmlPath);
            Document document = builder.parse(location.openStream());
            NamedNodeMap attributes = document.getDocumentElement().getAttributes();
            String fxControllerClassName=null;
            for (int i = 0; i < attributes.getLength(); i++) {
                Node item = attributes.item(i);
                if(item.getNodeName().equals(FXMLLoader.FX_NAMESPACE_PREFIX+":"+FXMLLoader.CONTROLLER_KEYWORD)){
                    fxControllerClassName = item.getNodeValue();
                }
            }
            if(fxControllerClassName!=null)
                return ClassLoader.getSystemClassLoader().loadClass(fxControllerClassName);
        } catch (ParserConfigurationException | SAXException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(ScreensController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}


