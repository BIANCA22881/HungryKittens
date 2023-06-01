package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

//Aceasta este clasa pentru sobolan mostenita din clasa Entity
public class NPC_rat extends Entity{

    public NPC_rat(GamePanel gp){
        super(gp);
        direction="right";
        speed=2;
        solidArea=new Rectangle(5,32,54,30);
        solidAreaDefaultX=5;
        solidAreaDefaultY=32;
        getImage();
        type=2;
    }
    public void getImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/npc/tile000.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/npc/tile001.png"));
            up3= ImageIO.read(getClass().getResourceAsStream("/npc/tile002.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/npc/tile006.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/npc/tile007.png"));
            down3= ImageIO.read(getClass().getResourceAsStream("/npc/tile008.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/npc/tile009.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/npc/tile010.png"));
            left3= ImageIO.read(getClass().getResourceAsStream("/npc/tile011.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/npc/tile003.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/npc/tile004.png"));
            right3= ImageIO.read(getClass().getResourceAsStream("/npc/tile005.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //aceasta functie face ca sobolanul sa se miste stanga-dreapta in 240 frame=uri
    public void setAction(){
        actionLockCounter++;
        if(actionLockCounter==240){
            if(!checkDirection){
                checkDirection=true;
                direction="left";
            }
            else{
                checkDirection=false;
                direction="right";
            }
            actionLockCounter=0;
        }
    }
}
