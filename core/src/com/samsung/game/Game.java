package com.samsung.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.samsung.game.entity.Player;
import com.samsung.game.world.CollisionChecker;
import com.samsung.game.world.TileManager;

public class Game extends ApplicationAdapter {

    OrthographicCamera camera;
    SpriteBatch batch;
    KeyHandler keyHandler;
    Player player;
    TileManager tileManager;
    CollisionChecker checker;

    private int time = 0;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 512, 288);
        batch = new SpriteBatch();
        keyHandler = new KeyHandler();
        player = new Player();
        tileManager = new TileManager("maps/map.txt");
        checker = new CollisionChecker(player,tileManager);
    }

    @Override
    public void render() {
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        keyHandler.update();
        checker.update();
        player.update();
        draw();
        time++;
        if (time >= 60 * 10) System.gc();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void draw() {
        ScreenUtils.clear(0, 1, 0.2f, 1);
        batch.begin();
        tileManager.draw(batch,player);
        player.draw(batch);
        keyHandler.draw(batch);
        batch.end();
    }
}
