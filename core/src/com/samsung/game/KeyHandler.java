package com.samsung.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.world.CollisionChecker;

public class KeyHandler {

    public static boolean upPressed, downPressed, leftPressed, rightPressed;

    private Rectangle joyStick;

    public KeyHandler() {
        joyStick = new Rectangle(0,0,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/3);
    }

    public void update() {

        upPressed = Gdx.input.isKeyPressed(Input.Keys.W);
        downPressed = Gdx.input.isKeyPressed(Input.Keys.S);
        leftPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        rightPressed = Gdx.input.isKeyPressed(Input.Keys.D);

        if (Gdx.input.isTouched()) {
            leftPressed = (Gdx.input.getX() <= joyStick.getWidth() / 3 && Gdx.input.getY() * -1 + Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 9 <= joyStick.getHeight());
            rightPressed = (Gdx.input.getX() >= joyStick.getWidth() - joyStick.getWidth() / 3 && Gdx.input.getX() <= joyStick.getWidth() && Gdx.input.getY() * -1 + Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 9 <= joyStick.getHeight());
        }
    }
    public void draw(SpriteBatch batch){
        batch.draw(new Texture("joystick.png"),joyStick.getX(),joyStick.getY(),512/4,512/4);
    }
}
