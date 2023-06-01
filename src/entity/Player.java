package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
//Aceasta este clasa pentru player mostenita din clasa Entity
public class Player extends Entity {
    KeyHandler keyH;
    public  int screenX;
    public  int screenY;
    public int hasFish=0;
    public boolean hasMilk=false;
    public long milkExpire;
    public boolean youWin=false;
    public String colorCat;

    public Player(GamePanel gp,KeyHandler keyH){
        super(gp);
        this.keyH=keyH;
        setDefaultValues();
    }
    public void setDefaultValues(){
        //coordonatele initiale ale pisicii
        worldX=gp.tileSize*3;
        worldY=gp.tileSize*4;
        //pentru ca pisica sa fie mereu in mijlocul ecranuluiin timp ce ne plimbam pe mapa
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);
        //valorile cu care incepe pisica
        speed=3;//viteza
        milkExpire=1000000000;
        direction="down";
        solidArea=new Rectangle(20,30,24,24);
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        //player life
        maxLife=6;
        life=maxLife;
    }
    //pentru a da restart la joc in caz de pierdere a vietii
    public void setDefaultPosition(){
        worldX=gp.tileSize*4;
        worldY=gp.tileSize*4;
        direction="down";
        hasFish=0;
    }
    //pentru a reseta viata
    public void restoreLife(){
        life=maxLife;
        invincible=false;
    }
    //pozitiile pisicii pentru level 2
    public void positionsLevel2(){
        worldX=gp.tileSize*4;
        worldY=gp.tileSize*2;
        direction="left";
        youWin=false;
    }
    //pozitiile pisicii pentru level 3
    public void positionsLevel3(){
        worldX=gp.tileSize*3;
        worldY=gp.tileSize*27;
        direction="right";
        youWin=false;
    }
    //metoda care citeste imaginilie pentru pisica in functie de culoarea pe care o alegi din meniu
    public void getPlayerImage(String color){
        switch(color) {
            case "white"-> {
                colorCat="white";
                try {
                    up1 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whiteu1.png"));
                    up2 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whiteu2.png"));
                    up3 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whiteu3.png"));
                    down1 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whited1.png"));
                    down2 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whited2.png"));
                    down3 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whited3.png"));
                    left1 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whitel1.png"));
                    left2 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whitel2.png"));
                    left3 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whitel3.png"));
                    right1 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whiter1.png"));
                    right2 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whiter2.png"));
                    right3 = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whiter3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case"ginger"->{
                colorCat="ginger";
                try {
                    up1 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile020.png"));
                    up2 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile021.png"));
                    up3 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile022.png"));
                    down1 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile036.png"));
                    down2 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile037.png"));
                    down3 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile038.png"));
                    left1 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile052.png"));
                    left2 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile053.png"));
                    left3 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile054.png"));
                    right1 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile004.png"));
                    right2 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile005.png"));
                    right3 = ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile006.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case"brown"->{
                colorCat="brown";
                try {
                    up1 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile024.png"));
                    up2 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile025.png"));
                    up3 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile026.png"));
                    down1 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile040.png"));
                    down2 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile041.png"));
                    down3 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile042.png"));
                    left1 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile056.png"));
                    left2 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile057.png"));
                    left3 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile058.png"));
                    right1 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile008.png"));
                    right2 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile009.png"));
                    right3 = ImageIO.read(getClass().getResourceAsStream("/player/brown/tile010.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case"black"->{
                colorCat="black";
                try {
                    up1 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile028.png"));
                    up2 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile029.png"));
                    up3 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile030.png"));
                    down1 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile044.png"));
                    down2 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile045.png"));
                    down3 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile046.png"));
                    left1 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile060.png"));
                    left2 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile061.png"));
                    left3 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile062.png"));
                    right1 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile012.png"));
                    right2 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile013.png"));
                    right3 = ImageIO.read(getClass().getResourceAsStream("/player/black/tile014.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void update(){
        //modifica directia pisicii in functie de butoanele pe care le apas
        if (keyH.upPressed|| keyH.downPressed||keyH.leftPressed|| keyH.rightPressed){
            if(keyH.upPressed){
                direction="up";
            } else if (keyH.downPressed) {
                direction="down";
            } else if (keyH.leftPressed) {
                direction="left";
            } else if (keyH.rightPressed) {
                direction="right";
            }
            //verifica coliziunea cu tile-urile(mapa)
            collisionOn=false;
            gp.cChecker.checkTile(this);
            //verifica coliziunea cu obiecte
            int objIndex=gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);
            //verifica coliziunea cu inamicii
            int npcIndex=gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex,gp.npc);
            // daca collisionOn ramane false=>se poate misca
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
        //dupa ce pisica a fost lovita ii dam invincibilitate pentru 60 secunde(pentru a nu muri din prima)
        if(invincible){
            invincibleCounter++;
            if(invincibleCounter>60){
                invincible=false;
                invincibleCounter=0;
            }
        }
        //daca pisica a murit apare ecranul de GAMEOVER
        if(life<=0){
            gp.gameState=gp.gameOverState;
        }
    }
    //metoda pentru a vedea interactiunea cu anumite obiecte
    public void pickUpObject(int i){
        if(i!=999){
            String objectName=gp.obj[gp.currentMap][i].name;
            switch (objectName) {
                case "fish" -> {
                    hasFish++;//creste numarul de pesti
                    gp.obj[gp.currentMap][i] = null;//dispare de pe ecran
                }
                case "door" -> {
                    if (hasFish >=5) {
                        gp.obj[gp.currentMap][i] = null;//se "deschide" numai cand avem 5 sau mai multi pesti
                    }
                }
                case "milk" -> {//ii creste viata cu jumatate de inima si primeste viteza pentru cateva secunde
                    gp.obj[gp.currentMap][i] = null;
                    hasMilk = true;
                    life++;
                    if(life>maxLife){
                        life=maxLife;
                    }
                }
                case "finalfish" ->{//treci la nivelul urmator
                    youWin=true;
                    if(gp.currentMap!=2) {
                        gp.gameState = gp.youWonState;
                    }
                }
                case "uranium"->{//pisica moare din prima
                    life=0;
                }
            }
        }
    }
    //interactiunea cu diferitii inamici
    public void interactNPC(int i, Entity[][] entity) {
        for(int j=0;j<entity[1].length;j++) {
            if (i != 999) {
                if (invincible == false) {
                    if (entity[gp.currentMap][i].type == 1) {//daca e soarece ii scade jumatate de inima
                        life--;
                        invincible = true;
                    } else {
                        if (entity[gp.currentMap][i].type == 2) {//daca e sobolan ii scade o inima
                            life -= 2;
                            invincible = true;
                        }
                    }
                }
            }
        }
    }
}
