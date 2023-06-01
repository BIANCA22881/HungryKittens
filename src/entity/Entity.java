package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
//Aceasta este clasa de baza pe care o vom folosi pentru toate personajele
public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public BufferedImage up1,up2,up3,down1,down2,down3,left1,left2,left3,right1,right2,right3;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    public Rectangle solidArea;//pentru coliziuni
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    public boolean collisionOn=false;
    public int actionLockCounter=0;
    public boolean checkDirection=false;
    public int maxLife;
    public int life;
    public boolean invincible =false;
    public int invincibleCounter=0;
    public int type;//0=player,1//mouse,2//rat//ptr a sti cat damage primeste pisica in functie de tipul inamicului
    public Entity(GamePanel gp){
        this.gp=gp;
    }
    public void setAction(){}
    public void update(){
        setAction();
        collisionOn=false;
        //verificam coliziunea unei entitati cu alte tile-uri/obiecte/entitati
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this,false);
        gp.cChecker.checkEntity(this, gp.npc);
        boolean contactPlayer=gp.cChecker.checkPlayer(this);
        if(this.type==1 && contactPlayer){
            if(!gp.player.invincible){
                gp.player.life--;
                gp.player.invincible=true;
            }
        }
        else {
            if (this.type == 2 && contactPlayer) {
                if (!gp.player.invincible) {
                    gp.player.life -= 2;
                    gp.player.invincible = true;
                }
            }
        }
        // daca collisionOn a ramas false=>personajul se poate misca
        if (!collisionOn) {
            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }
        }
        spriteCounter++;
        if(spriteCounter>15){
            if(spriteNum==1)
                spriteNum=2;
            else if (spriteNum==2)
                spriteNum=3;
            else if (spriteNum==3)
                spriteNum=1;
            spriteCounter=0;
        }
    }
    //aici desenam personajul
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            //schimbam imaginea pentru a se crea animatia
            switch (direction) {
                case "up" -> {
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    if (spriteNum == 3) {
                        image = up3;
                    }
                }
                case "down" -> {
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    if (spriteNum == 3) {
                        image = down3;
                    }
                }
                case "left" -> {
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    if (spriteNum == 3) {
                        image = left3;
                    }
                }
                case "right" -> {
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    if (spriteNum == 3) {
                        image = right3;
                    }
                }
            }
            //aici desenam imaginea
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            //Bounding box
//            g2.drawRect(screenX+solidArea.x,
//                screenY+solidArea.y,
//                solidArea.width,
//                solidArea.height);
        }
    }
}
