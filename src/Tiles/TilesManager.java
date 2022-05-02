package Tiles;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TilesManager {
    GamePanel gp;
    Tile[] map;
    int mapTileNum[][];

    public TilesManager(GamePanel gp){
        this.gp= gp;
        map = new Tile[20];
        mapTileNum= new int[gp.maxWorldCol][gp.maxWorldRow];
         getTileImage();
        loadMap();
    }
    public void getTileImage(){
        try{
            map[0]= new Tile();
            map[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/path.png"));
            map[1]= new Tile();
            map[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall_up.png"));
            map[2]= new Tile();
            map[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/outter_path.png"));
            map[3]= new Tile();
            map[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/blank.png"));
            map[4]= new Tile();
            map[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/blank2.png"));
            map[5]= new Tile();
            map[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall_right.png"));
            map[6]= new Tile();
            map[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/door.png"));
            map[7]= new Tile();
            map[7].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile0.png"));
            map[8]= new Tile();
            map[8].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile1.png"));
            map[9]= new Tile();
            map[9].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile2.png"));
            map[10]= new Tile();
            map[10].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile3.png"));
            map[11]= new Tile();
            map[11].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile5.png"));
            map[12]= new Tile();
            map[12].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile6.png"));
            map[13]= new Tile();
            map[13].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile7.png"));
            map[14]= new Tile();
            map[14].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile8.png"));
            map[14]= new Tile();
            map[14].image= ImageIO.read(getClass().getResourceAsStream("/tiles/midtile8.png"));



        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(){
        try{
            InputStream is=  getClass().getResourceAsStream("/maps/1st_floor_map.txt");
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row =0;
            while(col<gp.maxWorldCol && row<gp.maxWorldRow){
                String line = br.readLine();
                while(col< gp.maxWorldCol){
                    String number[]   = line.split(" ");
                    int num =Integer.parseInt(number[col]);
                    mapTileNum[col][row]= num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e){
        }
    }

    public void draw(Graphics2D g2){
         int worldCol=0;
         int worldRow=0;

         while(worldCol<gp.maxWorldCol &&  worldRow<gp.maxWorldRow){
             int tileNum= mapTileNum[worldCol][worldRow];
             int worldX= worldCol*gp.tileSize;
             int worldY= worldRow*gp.tileSize;
             int screenX= worldX- gp.player.worldX+gp.player.screenX;
             int screenY= worldY- gp.player.worldY+gp.player.screenY ;

             //Stop moving camera at the edge
             if(gp.player.screenX>gp.player.worldX){
                 screenX=worldX;
             }
             if(gp.player.screenY>gp.player.worldY){
                 screenY=worldY;
             }
             int rightOffset=gp.screenWidth-gp.player.screenX;
             if(rightOffset>gp.worldWidth-gp.player.worldX){
                 screenX= gp.screenWidth-(gp.worldWidth-worldX);
             }
             int bottomOffset=gp.screenHeight-gp.player.screenY;
             if(bottomOffset> gp.worldHeight-gp.player.worldY){
                 screenY= gp.screenHeight-(gp.worldWidth-worldY);
             }

             if(        worldX+gp.tileSize>gp.player.worldX-gp.player.screenX
                     && worldX-gp.tileSize<gp.player.worldX+gp.player.screenX
                     && worldY+gp.tileSize>gp.player.worldY-gp.player.screenY
                     && worldY-gp.tileSize<gp.player.worldY+gp.player.screenY){
                 //g2.drawImage(map[tileNum].image, screenX, screenY, null );
                 g2.drawImage(map[tileNum].image, screenX, screenY,gp.tileSize, gp.tileSize,null);
             }else{
                 if(gp.player.screenX>gp.player.worldX ||
                    gp.player.screenY>gp.player.worldY||
                    rightOffset>gp.worldWidth-gp.player.worldX||
                    bottomOffset>gp.worldHeight-gp.player.worldY){
                        //g2.drawImage(map[tileNum].image, screenX, screenY, null );
                     g2.drawImage(map[tileNum].image, screenX, screenY,gp.tileSize, gp.tileSize,null);
                 }
             }

             g2.drawImage(map[tileNum].image, screenX, screenY,gp.tileSize, gp.tileSize,null);
             worldCol++;
             if(worldCol== gp.maxWorldCol){
                 worldCol=0;
                 worldRow++;
             }
         }
    }
}
