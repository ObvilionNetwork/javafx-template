package ru.obvilion.template.utils;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StyleUtil {
    public static void createFadeAnimation(Node node, int fadeDuration, float to) {
        FadeTransition ft = new FadeTransition(Duration.millis(fadeDuration), node);

        ft.setFromValue(node.getOpacity());
        ft.setToValue(to);
        ft.play();
    }

    public static void createFadeAnimation(Stage stage, int fadeDuration, float to) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(fadeDuration));
            }

            final float ansOpasity = (float) stage.getOpacity();
            protected void interpolate(double f) {
                float op = (float) (to * f + ansOpasity * (1 - f));

                stage.setOpacity(op);
            }
        };

        animation.play();
    }

    public static void changePosition(Node element, double toX, double toY, int durationAnimation) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(durationAnimation));
            }

            final float ansLayoutX = (float) element.getLayoutX();
            final float ansLayoutY = (float) element.getLayoutY();
            protected void interpolate(double f) {
                float x = (float) (toX * f + ansLayoutX * (1 - f));
                float y = (float) (toY * f + ansLayoutY * (1 - f));

                element.setLayoutX(x);
                element.setLayoutY(y);
            }
        };
        animation.play();
    }
}
