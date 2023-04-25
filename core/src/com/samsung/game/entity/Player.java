package com.samsung.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.samsung.game.KeyHandler;

public class Player extends Entity {

    public Player() {
        setDefaultValues();
    }

    private void setDefaultValues() {
        screenX = tileSize * 8 - tileSize / 2;
        screenY = (int) (tileSize * 4.5f - tileSize / 2);
        worldX = screenX;
        worldY = screenY;
        speed = 2;
        texture = new Texture("player/player.png");
        rectangle = new Rectangle(0, 0, 32, 32);
    }

    public void update() {
        if (KeyHandler.upPressed) worldY -= speed;
        if (KeyHandler.downPressed) worldY += speed;
        if (KeyHandler.leftPressed) worldX -= speed;
        if (KeyHandler.rightPressed) worldX += speed;

//        System.out.println("Player: X:" + worldX + "  Y:" + worldY);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, screenX, screenY, tileSize, tileSize);
    }


}
