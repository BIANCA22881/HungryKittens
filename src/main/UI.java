package main;

import object.OBJ_fish;
import object.OBJ_heart;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
//Aceasta clasa deseneaza pe ecran
public class UI {
    GamePanel gp;
    Font arial_40;
    Font arial_80;
    BufferedImage fishImage;
    BufferedImage heartF,heartH,heartE;
    int[] tx;
    int []ty;
    double []tr;
    public boolean gameFinished=false;
    Graphics2D g2;
    public int commandNum=0;
    public int TtileScreenState=0;//0=first menu screen 1=second menu screen


    public UI(GamePanel gp){
        this.gp=gp;
        arial_40=new Font("Arial",Font.PLAIN,40);
        arial_80=new Font("Arial",Font.BOLD,80);
        OBJ_fish fish=new OBJ_fish();
        fishImage=fish.image;
        tx=new int[7];
        ty=new int[7];
        tr=new double[7];
        {
            tx[0] = 16;
            ty[0] = 16;
            tr[0] = Math.PI - Math.PI / 4;

            tx[1] = 114;//g
            ty[1] = 288;
            tr[1] = Math.PI / 8;

            tx[2] = 32;//g
            ty[2] = 544;
            tr[2] = Math.PI - Math.PI / 6;

            tx[3] = 818;
            ty[3] = 32;
            tr[3] = Math.PI / 8;

            tx[4] = 700;//g;
            ty[4] = 288;
            tr[4] = -Math.PI / 8;

            tx[5] = 800;
            ty[5] = 567;
            tr[5] = Math.PI - Math.PI / 3;

            tx[6] = 400;//g;
            ty[6] = -32;
            tr[6] = 0;
        }
        //heart
        SuperObject heart=new OBJ_heart(gp);
        heartF=heart.image;
        heartH=heart.image2;
        heartE=heart.image3;
    }
    public void draw(Graphics2D g2) throws IOException {
        this.g2=g2;
        //aici avem cate o metoda care deseneaza pe ecran pentru fiecare stare a jocului
        if (gp.gameState==gp.titleState){
            drawTitleScreen();
        }
        if(gp.gameState==gp.playState) {
            drawPlayerLife();
            drawFish();
        }
        if(gp.gameState==gp.youWonState){
            drawGameFinished();
        }
        if(gp.gameState==gp.gameOverState){
            drawGameOverScreen();
        }
        if(gp.gameState==gp.finalState){
            drawFinalScreen();
        }
    }

    public void drawFinalScreen(){
        g2.setColor(new Color(0,0,0,200));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(arial_80);
        g2.setColor(Color.black);
        String text;
        int x, y;
        text = "GAME COMPLETED";
        x = getXforCenteredText(text);
        y = gp.screenHeight / 2 - gp.tileSize * 2;
        g2.drawString(text, x, y);
        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);
        x=gp.screenWidth/2-(32*5);
        y+=gp.tileSize;
        BufferedImage img;
        try {
            img= ImageIO.read(getClass().getResourceAsStream("/player/cat_whiteMain.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g2.drawImage(img,x,y,gp.tileSize*5,gp.tileSize*5,null);


    }
    public void drawGameFinished() {
        g2.setColor(new Color(0,0,0,200));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(arial_80);
        g2.setColor(Color.black);
        String text;
        int x, y;
        text = "LEVEL COMPLETED";
        x = getXforCenteredText(text);
        y = gp.screenHeight / 2 - gp.tileSize * 2;
        g2.drawString(text, x, y);
        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        text="NEXT LEVEL";
        x= getXforCenteredText(text);
        y+=gp.tileSize*5;
        g2.drawString(text,x,y);
        if(commandNum==0){
            g2.drawString(">",x-gp.tileSize,y);
        }
        text="QUIT";
        x= getXforCenteredText(text);
        y+=gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum==1){
            g2.drawString(">",x-gp.tileSize,y);
        }
    }

    public void drawPlayerLife() {
        int x=gp.screenWidth-gp.tileSize*5/4;
        int y=gp.tileSize/4;
        int i=0;
        while(i<gp.player.maxLife/2){
            g2.drawImage(heartE,x,y,gp.tileSize,gp.tileSize,null);
            i++;
            x-=gp.tileSize;
        }
        x=gp.screenWidth-gp.tileSize*5/4;
        y=gp.tileSize/4;
        i=0;
        while(i<gp.player.life){
            g2.drawImage(heartH,x,y,gp.tileSize,gp.tileSize,null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heartF,x,y,gp.tileSize,gp.tileSize,null);
            }
            i++;
            x-= gp.tileSize;
        }
    }
    public void drawFish(){
        g2.setFont(arial_40);
        g2.setColor(Color.black);
        g2.drawImage(fishImage, 0, 0, gp.tileSize * 2, gp.tileSize * 2, null);
        g2.drawString("x " + gp.player.hasFish, 100, 80);
    }

    public void drawTitleScreen() throws IOException {
        if(TtileScreenState==0){
            g2.setColor(new Color(50,0,25));
            g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);
            //aici deseneaza pestii in functie de coordonatele din vectorii tx,ty si ii roteste in fuctie de radianii din tr
            BufferedImage img;
            img= ImageIO.read(getClass().getResourceAsStream("/objects/fish1.png"));
            for(int i=0;i<tx.length;i++){
                AffineTransform t=new AffineTransform();
                t.translate(tx[i],ty[i]);
                t.scale(7,7);
                t.rotate(tr[i],16,16);
                g2.drawRenderedImage(img,t);
            }
            //TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
            String text="Hungry Kittens";
            int x=getXforCenteredText(text);
            int y=gp.tileSize*3;

            //SHADOW
            g2.setColor(Color.black);
            g2.drawString(text,x+10,y+10);

            g2.setColor(Color.pink);
            g2.drawString(text,x,y);
            //Aici deseneam pisica
            x=gp.screenWidth/2-(32*4);
            y+=gp.tileSize/2;
            try {
                img= ImageIO.read(getClass().getResourceAsStream("/player/cat_whiteMain.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g2.drawImage(img,x,y,gp.tileSize*4,gp.tileSize*4,null);

            //MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
            //NEW GAME
            text="NEW GAME";
            x= getXforCenteredText(text);
            y+=gp.tileSize*5;
            g2.drawString(text,x,y);
            if(commandNum==0){
                g2.drawString(">",x-gp.tileSize,y);
            }
            //LOAD GAME
            text="LOAD GAME";
            x= getXforCenteredText(text);
            y+=gp.tileSize;
            g2.drawString(text,x,y);
            if(commandNum==1){
                g2.drawString(">",x-gp.tileSize,y);
            }
            //QUIT
            text="QUIT";
            x= getXforCenteredText(text);
            y+=gp.tileSize;
            g2.drawString(text,x,y);
            if(commandNum==2){
                g2.drawString(">",x-gp.tileSize,y);
            }
        }
        else{
            if(TtileScreenState==1){
                g2.setColor(new Color(50,0,25));
                g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);
                g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
                g2.setColor(Color.white);
                String text="SELECT YOUR CAT";
                int x= getXforCenteredText(text);
                int y=gp.tileSize*2;
                g2.drawString(text,x,y);
                //SUBMENIU
                text="WHITE";
                x= getXforCenteredText(text)/2;
                y+=gp.tileSize*4;
                g2.drawString(text,x,y);
                BufferedImage catimg;
                catimg = ImageIO.read(getClass().getResourceAsStream("/player/white/cat_whited1.png"));
                g2.drawImage(catimg,x,y- gp.tileSize*3,gp.tileSize*2,gp.tileSize*2,null);
                if(commandNum==0) {
                    g2.drawString(">", x - gp.tileSize, y);
                }
                text="GINGER";
                x= getXforCenteredText(text)/2+getXforCenteredText(text);
                g2.drawString(text,x,y);
                catimg =ImageIO.read(getClass().getResourceAsStream("/player/ginger/tile036.png"));
                g2.drawImage(catimg,x,y- gp.tileSize*3,gp.tileSize*2,gp.tileSize*2,null);
                if(commandNum==1){
                    g2.drawString(">",x-gp.tileSize,y);
                }
                text="BLACK";
                x= getXforCenteredText(text)/2;
                y+=gp.tileSize*4;
                g2.drawString(text,x,y);
                catimg = ImageIO.read(getClass().getResourceAsStream("/player/black/tile044.png"));
                g2.drawImage(catimg,x,y- gp.tileSize*3,gp.tileSize*2,gp.tileSize*2,null);
                if(commandNum==2){
                    g2.drawString(">",x-gp.tileSize,y);
                }
                text="BROWN";
                x= getXforCenteredText(text)/2+getXforCenteredText(text);
                g2.drawString(text,x,y);
                catimg =ImageIO.read(getClass().getResourceAsStream("/player/brown/tile040.png"));
                g2.drawImage(catimg,x,y- gp.tileSize*3,gp.tileSize*2,gp.tileSize*2,null);
                if(commandNum==3){
                    g2.drawString(">",x-gp.tileSize,y);
                }
                text="BACK";
                x= getXforCenteredText(text);
                y+=gp.tileSize*3/2;
                g2.drawString(text,x,y);
                if(commandNum==4){
                    g2.drawString(">",x-gp.tileSize,y);
                }
            }
        }
    }
    public void drawGameOverScreen(){
        g2.setColor(new Color(0,0,0,200));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));
        text="GAME OVER";
        g2.setColor(Color.black);
        x=getXforCenteredText(text);
        y= gp.tileSize*5;
        g2.drawString(text,x,y);
        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        text="MENU";
        x= getXforCenteredText(text);
        y+=gp.tileSize*4;
        g2.drawString(text,x,y);
        if(commandNum==0){
            g2.drawString(">",x-gp.tileSize,y);
        }
        text="QUIT";
        x= getXforCenteredText(text);
        y+=gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum==1){
            g2.drawString(">",x-gp.tileSize,y);
        }
    }
    public int getXforCenteredText(String text){
        int length=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        return gp.screenWidth/2-length/2;
    }
}
