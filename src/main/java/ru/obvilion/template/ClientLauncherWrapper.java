package ru.obvilion.template;

import ru.obvilion.template.gui.Gui;
import ru.obvilion.template.utils.Log;

public class ClientLauncherWrapper {
    public static void main(String[] args) {
        Log.info("Starting example UI application...");
        Gui.load();
    }
}
