package main;

import data.SaveLoad;
import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final int originalTileSize=32;
    final int scale=2;//ptr a face tiles/personajele mai mari
    public final int tileSize=originalTileSize*scale;//=64
    public final int maxScreenCol=16;
    public final int maxScreenRow=12;
    public final int screenWidth=tileSize*maxScreenCol;
    public final int screenHeight=tileSize*maxScreenRow;
    //world settings
    public final int maxWorldCol=30;
    public final int maxWorldRow=30;
    public final int maxMap=3;
    public int currentMap=0;
    public final int WorldWidth=tileSize*maxWorldCol;
    public final int WorldHeight=tileSize*maxWorldRow;
    int FPS=60;
    KeyHandler keyH=new KeyHandler(this);
    Thread gameThread;///timpul in joc
    public CollisionChecker cChecker=new CollisionChecker(this);
    public AssetSetter aSetter=new AssetSetter(this);
    public UI ui =new UI(this);
    TileManager tileM=new TileManager(this);
    //ENTITY AND OBJECT
    public Player player=new Player(this ,keyH);
    public SuperObject[][] obj =new SuperObject[maxMap][40];//display up to 40 objects at a time
    public Entity[][] npc =new Entity[maxMap][15];
    //public EventHandler eHandler=new EventHandler(this);
    SaveLoad saveLoad=new SaveLoad(this);
    //GAME STATE-URI
    public int gameState;
    public final int titleState=0;
    public final int playState=1;
    public final int gameOverState=2;
    public final int youWonState=3;
    public final int finalState=4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);//if true==game rendering is improved
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        gameState=titleState;
    }
    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){///creating game loop
        double drawInterval=1000000000/FPS;
        double nextDrawTime= System.nanoTime()+drawInterval;
        while(gameThread!=null){
            if (!player.hasMilk){
                update();// 1.UPDATE (update inf such as character position)
                // 2.DRAW (draw the screen with the updated inf)
                repaint();//that's how you call paintComponent();
            }
            else {
                //atunci cand player-ul are hasMilk==true se modifica viteza pentru cateva secunde
                player.speed=5;
                update();
                repaint();
                player.milkExpire= (long) (player.milkExpire-drawInterval/5);
                if(player.milkExpire<0){
                    player.hasMilk=false;
                    player.speed=3;
                    player.milkExpire=1000000000;
                }
            }
            try {
                double remainingTime=nextDrawTime-System.nanoTime();
                remainingTime=remainingTime/1000000;//transformam in milisecunde
                if(remainingTime<0){
                    remainingTime=0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime+=drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(){
        //PLAYER
        player.update();
        //INAMICI
        for(int i=0;i<npc[1].length;i++){
            if(npc[currentMap][i]!=null){
                npc[currentMap][i].update();
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        if(gameState==titleState){
            try {
                ui.draw(g2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //others
        else{
            //tiles
            tileM.draw(g2);//important sa fie desenat primul
            //objects
            for(int i=0;i<obj[1].length;i++){
                if(obj[currentMap][i]!=null){
                    obj[currentMap][i].draw(g2,this);
                }
            }
            //inamici
            for(int i=0;i<npc[1].length;i++){
                if(npc[currentMap][i]!=null){
                    npc[currentMap][i].draw(g2);
                }
            }
            //player
            player.draw(g2);
            try {
                ui.draw(g2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g2.dispose();
        }
    }
    //metoda pentru a da restart jocului dupa ce pierzi
    public void restart(){
        player.setDefaultValues();
        player.setDefaultPosition();
        player.restoreLife();
        aSetter.setObject();
        aSetter.setNPC();
    }
    ///Baza de date
    //inserare in tabel a valorilor pentru scor
    public static void insertB(String fileName,String chartName,int life,int fish){
        Connection c=null;
        Statement stmt=null;
        try{
            Class.forName("org.sqlite.JDBC");
            c= DriverManager.getConnection("jdbc:sqlite:"+fileName+".db");
            c.setAutoCommit(false);
            stmt=c.createStatement();

            String sql="INSERT INTO SCORE(LIFE,FISH)"+
                    "VALUES("+life+","+fish+");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+":"+ e.getMessage());
            System.exit(0);
        }
    }
}
