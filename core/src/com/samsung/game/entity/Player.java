package com.samsung.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
        worldX = 32 * 23;
        worldY = 32 * 21;
        speed = 2;
        loadTexture();
        texture = down1;
        rectangle = new Rectangle(0, 0, 32, 32);
        direction = "down";
        time = 0;
        spiteNum = 0;
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || Gdx.input.isTouched()) {
            time++;
            if (KeyHandler.upPressed){
                direction = "up";
                worldY -= speed;
            }
            if (KeyHandler.downPressed){
                direction = "down";
                worldY += speed;
            }
            if (KeyHandler.leftPressed){
                direction = "left";
                worldX -= speed;
            }
            if (KeyHandler.rightPressed){
                direction = "right";
                worldX += speed;
            }

            switch (direction){
                case "up":
                    if (spiteNum == 1) texture = up1;
                    else texture = up2;
                    break;
                case "down":
                    if (spiteNum == 1) texture = down1;
                    else texture = down2;
                    break;
                case "left":
                    if (spiteNum == 1) texture = left1;
                    else texture = left2;
                    break;
                case "right":
                    if (spiteNum == 1) texture = right1;
                    else texture = right2;
                    break;
            }
            if (time >= 20){
                time = 0;
                spiteNum++;
            }
            if (spiteNum >= 2) spiteNum = 0;

        }

//        System.out.println("Player: X:" + worldX + "  Y:" + worldY);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, screenX, screenY, tileSize, tileSize);
    }
    private void loadTexture(){
        up1 = new Texture("player/boy_up_1.png");
        down1 = new Texture("player/boy_down_1.png");
        left1 = new Texture("player/boy_left_1.png");
        right1 = new Texture("player/boy_right_1.png");

        up2 = new Texture("player/boy_up_2.png");
        down2 = new Texture("player/boy_down_2.png");
        left2 = new Texture("player/boy_left_2.png");
        right2 = new Texture("player/boy_right_2.png");
    }


}
