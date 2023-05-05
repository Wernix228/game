package com.samsung.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.world.CollisionChecker;

public class KeyHandler {

    public static boolean upPressed, downPressed, leftPressed, rightPressed;

    private Rectangle joystick;

    public KeyHandler() {
        joystick = new Rectangle(0, 0, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 3);
    }

    public void update() {

        upPressed = Gdx.input.isKeyPressed(Input.Keys.W);
        downPressed = Gdx.input.isKeyPressed(Input.Keys.S);
        leftPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        rightPressed = Gdx.input.isKeyPressed(Input.Keys.D);

        if (Gdx.input.isTouched()) {
            leftPressed = (Gdx.input.getX() <= joystick.getWidth() / 3 && Gdx.input.getY() * -1 + Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 9 <= joystick.getHeight());
            rightPressed = (Gdx.input.getX() >= joystick.getWidth() - joystick.getWidth() / 3 && Gdx.input.getX() <= joystick.getWidth() && Gdx.input.getY() * -1 + Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 9 <= joystick.getHeight());
            downPressed = (Gdx.input.getY() * -1 + Gdx.graphics.getHeight() <= joystick.getHeight() / 3 && Gdx.input.getX() <= joystick.getWidth());
            upPressed = (Gdx.input.getY() * -1 + Gdx.graphics.getHeight() >= joystick.getHeight() && Gdx.input.getX() <= joystick.getWidth() && Gdx.input.getY() * -1 + Gdx.graphics.getHeight() <= Gdx.graphics.getWidth()/4);
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(new Texture("joystick.png"), joystick.getX(), joystick.getY(), 512 / 4, 512 / 4);
    }
}
