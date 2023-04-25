package com.samsung.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.entity.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class TileManager {

    private Tile[] tiles;
    private int[][] tileNum;

    public TileManager(String map) {
        loadTile();
        loadMap(map);
    }

    private void loadTile() {
        tiles = new Tile[5];
        tiles[0] = new Tile("tiles/grass.png");
        tiles[1] = new Tile("tiles/tree.png");
    }

    private void loadMap(String map) {
        tileNum = new int[20][20];
        FileHandle fileHandle = Gdx.files.internal(map);
        BufferedReader reader = new BufferedReader(fileHandle.reader());
        //BufferedReader не робит на андроид
        for (int i = 0; i < tileNum.length; i++) {

            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] tileNumbers = line.split(" ");

            for (int j = 0; j < tileNum[i].length; j++) {
                tileNum[i][j] = Integer.parseInt(tileNumbers[j]);
            }
        }
        for (int i = 0; i < tileNum.length; i++) {
            System.out.println(Arrays.toString(tileNum[i]));
        }
    }

    public void draw(SpriteBatch batch, Player player) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < tileNum.length && worldRow < tileNum[0].length) {

            int mapTileNum = tileNum[worldRow][worldCol];

            int worldX = worldCol * 32;
            int worldY = worldRow * 32;
            int screenX = worldX - player.getWorldX() + player.getScreenX();
            int screenY = worldY - player.getWorldY() + player.getScreenY();

//            if (worldX + 32 > player.getWorldX() - player.getScreenX() &&
//                    worldX - 32 < player.getWorldX() + player.getScreenX() &&
//                    worldY + 32 > player.getWorldY() - player.getScreenY() &&
//                    worldY - 32 < player.getWorldY() + player.getScreenY()) {

                batch.draw(tiles[mapTileNum].getTexture(), screenX, -screenY+256, 32, 32);
//            }

            worldCol++;

            if (worldCol == tileNum.length) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public int[][] getTileNum() {
        return tileNum;
    }
}
