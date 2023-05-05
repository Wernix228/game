package com.samsung.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Entity {

    protected int screenX;
    protected int screenY;
    protected int speed;
    protected Rectangle rectangle;
    protected Texture texture;
    protected int tileSize = 32;
    protected int worldX, worldY;
    protected String direction = "down";
    protected Texture up1, up2, down1, down2, left1, left2, right1, right2;
    protected int time;
    protected int spiteNum;

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
