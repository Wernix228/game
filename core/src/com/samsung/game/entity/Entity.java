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
    protected int worldX,worldY;

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
}
