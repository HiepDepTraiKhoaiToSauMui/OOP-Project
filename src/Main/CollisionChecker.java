package Main;

import Entity.Entity;

public class CollisionChecker {
<<<<<<< HEAD
=======

>>>>>>> e11503682170d8f2941a041c1dddc7743bfcb97e
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp=gp;
    }
    public void checkTile (Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tilesM.getMapTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = gp.tilesM.getMapTileNum()[entityRightCol][entityTopRow];
                if (gp.tilesM.getMap()[tileNum1].collision == true || gp.tilesM.getMap()[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tilesM.getMapTileNum()[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tilesM.getMapTileNum()[entityRightCol][entityBottomRow];
                if (gp.tilesM.getMap()[tileNum1].collision == true || gp.tilesM.getMap()[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tilesM.getMapTileNum()[entityRightCol][entityTopRow];
                tileNum2 = gp.tilesM.getMapTileNum()[entityRightCol][entityBottomRow];
                if (gp.tilesM.getMap()[tileNum1].collision == true || gp.tilesM.getMap()[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tilesM.getMapTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = gp.tilesM.getMapTileNum()[entityLeftCol][entityBottomRow];
                if (gp.tilesM.getMap()[tileNum1].collision == true || gp.tilesM.getMap()[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
