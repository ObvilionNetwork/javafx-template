package ru.obvilion.template.utils;

import javafx.scene.Node;

import java.net.URI;

public class DesktopUtil {
    public static boolean openWebpage(String url) {
        try {
            URI.create(url);
        } catch(Exception wrong) {
            return false;
        }

        Runtime rt = Runtime.getRuntime();

        Thread th = new Thread(() -> {
            try {
                String os = System.getProperty("os.name").toLowerCase();

                if (os.contains("mac")) {
                    rt.exec(new String[]{ "open", url });
                } else if(os.contains("lin") || os.contains("nix") || os.contains("aix")) {
                    rt.exec(new String[]{ "xdg-open", url });
                } else if(os.contains("win")) {
                    rt.exec(new String[]{ "rundll32", "url.dll,FileProtocolHandler", url });
                }
            } catch (Exception e) {
                Log.err("Unable open web browser: {0}", e.getLocalizedMessage());
            }

            Thread.currentThread().interrupt();
        });

        th.setDaemon(true);
        th.start();

        return true;
    }

    public static void setWebpageButton(Node node, String url) {
        node.setOnMouseClicked(event -> openWebpage(url));
    }
}
