package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//Aceasta este clasa pentru soarece mostenita din clasa Entity
public class NPC_mouse extends Entity {
    public NPC_mouse(GamePanel gp){
        super(gp);
        direction="down";
        speed=1;
        solidArea=new Rectangle(15,10,34,49);
        solidAreaDefaultX=15;
        solidAreaDefaultY=10;
        getImage();
        type=1;
    }
    public void getImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/npc/mouseu1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/npc/mouseu2.png"));
            up3= ImageIO.read(getClass().getResourceAsStream("/npc/mouseu3.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/npc/moused1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/npc/moused2.png"));
            down3= ImageIO.read(getClass().getResourceAsStream("/npc/moused3.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/npc/mousel1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/npc/mousel2.png"));
            left3= ImageIO.read(getClass().getResourceAsStream("/npc/mousel3.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/npc/mouser1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/npc/mouser2.png"));
            right3= ImageIO.read(getClass().getResourceAsStream("/npc/mouser3.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //aceasta functie face ca soarecele sa se plimbe sus-jos in 240 frame-uri
    public void setAction(){
        actionLockCounter++;
        if(actionLockCounter==240){
            if(!checkDirection){
                checkDirection=true;
                direction="up";
            }
            else{
                checkDirection=false;
                direction="down";
            }
            actionLockCounter=0;
        }
    }
}
