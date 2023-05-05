package com.samsung.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import java.awt.*;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

    static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setWindowedMode((int) (dimension.width / 1.5), (int) (dimension.height / 1.5));
        config.setTitle("Game");
        new Lwjgl3Application(new Game(), config);
    }
}
