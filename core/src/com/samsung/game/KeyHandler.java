package com.samsung.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class KeyHandler {

    public static boolean upPressed, downPressed, leftPressed, rightPressed;
    private static Rectangle joystick;
    private final String platform;

    public KeyHandler(String platform) {
        joystick = new Rectangle(0, 0, (float) Gdx.graphics.getWidth() / 4, (float) Gdx.graphics.getHeight() / 3);
        this.platform = platform;
    }

    public void update() {
        if (platform.equals("PC")) {
            upPressed = Gdx.input.isKeyPressed(Input.Keys.W);
            downPressed = Gdx.input.isKeyPressed(Input.Keys.S);
            leftPressed = Gdx.input.isKeyPressed(Input.Keys.A);
            rightPressed = Gdx.input.isKeyPressed(Input.Keys.D);
        } else if (platform.equals("Android")) {
            if (Gdx.input.isTouched()) {
                leftPressed = leftTouched();
                rightPressed = rightTouch();
                downPressed = downTouch();
                upPressed = upTouch();
            }
        }

    }

    public void draw(SpriteBatch batch) {
        batch.draw(new Texture("joystick.png"), joystick.getX(), joystick.getY(), 128, 128);
    }

    public static boolean upTouch() {
        return (Gdx.input.getY() * -1 + Gdx.graphics.getHeight() >= joystick.getHeight() && Gdx.input.getX() <= joystick.getWidth() && Gdx.input.getY() * -1 + Gdx.graphics.getHeight() <= Gdx.graphics.getWidth() / 4);
    }

    public static boolean downTouch() {
        return (Gdx.input.getY() * -1 + Gdx.graphics.getHeight() <= joystick.getHeight() / 3 && Gdx.input.getX() <= joystick.getWidth());
    }

    public static boolean rightTouch() {
        return (Gdx.input.getX() >= joystick.getWidth() - joystick.getWidth() / 3 && Gdx.input.getX() <= joystick.getWidth() && Gdx.input.getY() * -1 + Gdx.graphics.getHeight() - (float) Gdx.graphics.getHeight() / 9 <= joystick.getHeight());
    }

    public static boolean leftTouched() {
        return (Gdx.input.getX() <= joystick.getWidth() / 3 && Gdx.input.getY() * -1 + Gdx.graphics.getHeight() - (float) Gdx.graphics.getHeight() / 9 <= joystick.getHeight());
    }

}
