package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp=gp;
        this.keyHandler=keyH;
        setDefaultValues();
        getPlayerImage();
        direction = "down";
    }

    public void setDefaultValues() {
        x= 100;
        y=100;
        speed =4;
    }
    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/detective/detective_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/detective/detective_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/detective/detective_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/detective/detective_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/detective/detective_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/detective/detective_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/detective/detective_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/detective/detective_left_2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.upPressed==true || keyHandler.downPressed==true
                || keyHandler.leftPressed == true || keyHandler.rightPressed==true) {

            if (keyHandler.upPressed == true) {
                direction = "up";
                y -= speed;
            }

            if (keyHandler.downPressed == true) {
                direction = "down";
                y += speed;
            }

            if (keyHandler.rightPressed == true) {
                direction = "right";
                x += speed;
            }

            if (keyHandler.leftPressed == true) {
                direction = "left";
                x -= speed;
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(direction) {
            case "up":
                if (spriteNum==1) {
                    image = up1;
                }
                if(spriteNum==2) {
                    image =up2;
                }
                break;

            case "down":
                if (spriteNum==1) {
                    image = down1;
                }
                if(spriteNum==2) {
                    image =down2;
                }
                break;

            case "right":
                if (spriteNum==1) {
                    image = right1;
                }
                if(spriteNum==2) {
                    image =right2;
                }
                break;
            case "left":
                if (spriteNum==1) {
                    image = left1;
                }
                if(spriteNum==2) {
                    image =left2;
                }
                break;
        }
        g2.drawImage(image,x,y,gp.tileSize, gp.tileSize,null,null);
    }
}
