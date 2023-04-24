package com.samsung.game.world;

import com.badlogic.gdx.graphics.Texture;

public class Tile {

    private Texture texture;

    public Tile(String texture){
        this.texture = new Texture(texture);
    }

    public Texture getTexture() {
        return texture;
    }
}
