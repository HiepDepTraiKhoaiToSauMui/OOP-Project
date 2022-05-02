package Main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp= gp;
    }
    //set position of object
    public void setObject(){
        //key 1
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 16 * gp.tileSize;
        gp.obj[0].worldY = 26 * gp.tileSize;

        //key 2
        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 16 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;

        //door 3
        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 13 * gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;

        //chest 4
        gp.obj[3] = new OBJ_Chest();
        gp.obj[3].worldX = 16 * gp.tileSize;
        gp.obj[3].worldY = 17 * gp.tileSize;

    }
}
