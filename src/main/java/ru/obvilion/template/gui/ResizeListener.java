package ru.obvilion.template.gui;

import javafx.application.Platform;
import ru.obvilion.template.Vars;

public class ResizeListener {
    public static void onHeightResize() {
        sizeUpdate();
    }

    public static void onWidthResize() {
        sizeUpdate();
    }

    public static void sizeUpdate() {
        Platform.runLater(() -> {
            int m = Gui.maximized() ? 0 : 10;

            Vars.frameController.WINDOW.setPrefWidth(Gui.getStage().getWidth() - m);
            Vars.frameController.WINDOW.setPrefHeight(Gui.getStage().getHeight() - m);
        });
    }
}
