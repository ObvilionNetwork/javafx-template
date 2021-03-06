package ru.obvilion.template.utils;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.obvilion.template.gui.Gui;

public class WindowMoveUtil {
    public static void addMoveListener(Node node) {
        final WindowMoveUtil.MoveListener moveListener = new WindowMoveUtil.MoveListener();

        node.addEventHandler(MouseEvent.MOUSE_PRESSED, moveListener);
        node.addEventHandler(MouseEvent.MOUSE_DRAGGED, moveListener);
        node.addEventHandler(MouseEvent.MOUSE_RELEASED, moveListener);
    }

    private static class MoveListener implements EventHandler<MouseEvent> {
        private double clickX = 0;
        private double clickY = 0;

        public MoveListener() {

        }

        @Override
        public void handle(MouseEvent event) {
            final EventType<? extends MouseEvent> eventType = event.getEventType();
            final Stage stage = Gui.getStage();

            if (WindowResizeUtil.isResize) return;

            if (MouseEvent.MOUSE_DRAGGED.equals(eventType)) {
                stage.setX(event.getScreenX() - clickX);
                stage.setY(event.getScreenY() - clickY);
            }
            else if (MouseEvent.MOUSE_RELEASED.equals(eventType)) {
                StyleUtil.createFadeAnimation(stage, 200, 1);
            }
            else if (MouseEvent.MOUSE_PRESSED.equals(eventType)) {
                clickX = event.getSceneX();
                clickY = event.getSceneY();

                StyleUtil.createFadeAnimation(stage, 200, 0.85f);
            }
        }
    }
}
