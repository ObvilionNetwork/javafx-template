package ru.obvilion.template.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
        
        /* Top bar */
        CLOSE_BUTTON.setOnMouseClicked(e -> Runtime.getRuntime().exit(0));
        MAXIMISE_BUTTON.setOnMouseClicked(e -> Gui.maximise());
        HIDE_BUTTON.setOnMouseClicked(e -> Gui.getStage().setIconified(true));
        WindowMoveUtil.addMoveListener(TOP_BAR);
    }
}