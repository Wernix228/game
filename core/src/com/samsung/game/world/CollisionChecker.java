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
    public void update(){
        if (upCollision()) KeyHandler.upPressed = false;
        if (downCollision()) KeyHandler.downPressed = false;
        if (leftCollision()) KeyHandler.leftPressed = false;
        if (rightCollision()) KeyHandler.rightPressed = false;
    }
    private boolean upCollision(){
        return checkTile(tileManager.getTileNum()[(entity.getWorldY())/32][(entity.getWorldX())/32]);
    }
    private boolean downCollision(){
        return checkTile(tileManager.getTileNum()[(entity.getWorldY() + 32 )/32][(entity.getWorldX())/32]);
    }
    private boolean leftCollision(){
        return checkTile(tileManager.getTileNum()[entity.getWorldY()/32][(entity.getWorldX())/32]);
    }
    private boolean rightCollision(){
        return checkTile(tileManager.getTileNum()[entity.getWorldY()/32][(entity.getWorldX() + 32 )/32]);
    }
    private boolean checkTile(int tileNum){
        return tileNum == 1 || tileNum == 2 || tileNum == 3;
    }

}
