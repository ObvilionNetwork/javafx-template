package ru.obvilion.template.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import ru.obvilion.template.Vars;

import java.net.URL;
import java.util.ResourceBundle;

public class ContentController implements Initializable {
    @FXML public Pane root;
    @FXML public Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Vars.contentController = this;
    }

    public void onResize(int x, int y) {
        label.setText(x + " x " + y);
    }
}
