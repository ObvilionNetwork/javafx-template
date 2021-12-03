package ru.obvilion.template.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import ru.obvilion.template.Vars;
import ru.obvilion.template.gui.Gui;
import ru.obvilion.template.utils.WindowMoveUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class FrameController implements Initializable {
    @FXML public AnchorPane root;
    @FXML public Pane
            TOP_BAR, CLOSE_BUTTON, MAXIMISE_BUTTON, HIDE_BUTTON,
            CONTENT, WINDOW;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Vars.frameController = this;
        
        // Top bar logic
        CLOSE_BUTTON.setOnMouseClicked(e -> Runtime.getRuntime().exit(0));
        MAXIMISE_BUTTON.setOnMouseClicked(e -> Gui.maximise());
        HIDE_BUTTON.setOnMouseClicked(e -> Gui.getStage().setIconified(true));
        WindowMoveUtil.addMoveListener(TOP_BAR);

        // Load Content.fxml and his controller
        try {
            final ClassLoader loader = getClass().getClassLoader();
            final FXMLLoader fxmlLoader = new FXMLLoader(loader.getResource("Content.fxml"));
            final Pane root = fxmlLoader.load();
            CONTENT.getChildren().add(root);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Content auto-size and ContentController#onResize event
        CONTENT.widthProperty().addListener((o, oldX, newX) -> {
            int x = (int) Math.round((Double) newX);

            Vars.contentController.root.setPrefWidth(x);
            Vars.contentController.onResize(x, (int) Math.round(CONTENT.getHeight()));
        });
        CONTENT.heightProperty().addListener((o, oldY, newY) -> {
            int y = (int) Math.round((Double) newY);

            Vars.contentController.root.setPrefHeight(y);
            Vars.contentController.onResize((int) Math.round(CONTENT.getWidth()), y);
        });
    }
}