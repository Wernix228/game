package com.samsung.game.world;

import com.samsung.game.KeyHandler;
import com.samsung.game.entity.Entity;

public class CollisionChecker {
    Entity entity;
    TileManager tileManager;

    public CollisionChecker(Entity entity, TileManager tileManager) {
        this.entity = entity;
        this.tileManager = tileManager;
    }

    public void update() {
        for (int i = 2; i < 30; i++) {
            if (upCollision(i)) KeyHandler.upPressed = false;
            if (downCollision(i)) KeyHandler.downPressed = false;
            if (leftCollision(i)) KeyHandler.leftPressed = false;
            if (rightCollision(i)) KeyHandler.rightPressed = false;
        }

    }

    private boolean upCollision(int i) {
        return checkTile(tileManager.getTileNum()[(entity.getWorldY()) / 32][(entity.getWorldX() + i) / 32]);

    }

    private boolean downCollision(int i) {
        return checkTile(tileManager.getTileNum()[(entity.getWorldY() + 32) / 32][(entity.getWorldX() + i) / 32]);
    }

    private boolean leftCollision(int i) {
        return checkTile(tileManager.getTileNum()[(entity.getWorldY() + i) / 32][(entity.getWorldX()) / 32]);
    }

    private boolean rightCollision(int i) {
        return checkTile(tileManager.getTileNum()[(entity.getWorldY() + i) / 32][(entity.getWorldX() + 32) / 32]);
    }

    private boolean checkTile(int tileNum) {
        return tileNum == 1 || tileNum == 2 || tileNum == 3;
    }

}
