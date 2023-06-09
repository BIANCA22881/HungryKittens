package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;//in acest vector vom insera toate tile-urile folosite
    public int[][][] mapTileNum;//aceasta variabila pastreaza mapa pentru cele 3 nivele
    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[25];
        mapTileNum=new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/mapnivel1.txt",0);
        loadMap("/maps/mapnivel2.txt",1);
        loadMap("/maps/mapnivel3.txt",2);
    }
    //aceasta metoda citeste imaginile pentru tile-uri
    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].image=ImageIO.read(getClass().getResourceAsStream("/tiles/parchet.png"));

            tile[1]=new Tile();
            tile[1].image=ImageIO.read(getClass().getResourceAsStream("/tiles/GresieBaie.png"));

            tile[2]=new Tile();
            tile[2].image=ImageIO.read(getClass().getResourceAsStream("/tiles/iarba.png"));

            tile[3]=new Tile();
            tile[3].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tufis.png"));
            tile[3].collision=true;

            tile[4]=new Tile();
            tile[4].image=ImageIO.read(getClass().getResourceAsStream("/tiles/caramida.png"));
            tile[4].collision=true;

            tile[5]=new Tile();
            tile[5].image=ImageIO.read(getClass().getResourceAsStream("/tiles/bed_up.png"));
            tile[5].collision=true;

            tile[6]=new Tile();
            tile[6].image=ImageIO.read(getClass().getResourceAsStream("/tiles/bed_down.png"));
            tile[6].collision=true;

            tile[7]=new Tile();
            tile[7].image=ImageIO.read(getClass().getResourceAsStream("/tiles/dulap.png"));
            tile[7].collision=true;

            tile[8]=new Tile();
            tile[8].image=ImageIO.read(getClass().getResourceAsStream("/tiles/kcounter.png"));
            tile[8].collision=true;

            tile[9]=new Tile();
            tile[9].image=ImageIO.read(getClass().getResourceAsStream("/tiles/toilet.png"));
            tile[9].collision=true;

            tile[10]=new Tile();
            tile[10].image=ImageIO.read(getClass().getResourceAsStream("/tiles/shower.png"));
            tile[10].collision=true;

            tile[11]=new Tile();
            tile[11].image=ImageIO.read(getClass().getResourceAsStream("/tiles/sink.png"));
            tile[11].collision=true;

            tile[12]=new Tile();
            tile[12].image=ImageIO.read(getClass().getResourceAsStream("/tiles/col1.png"));
            tile[12].collision=true;

            tile[13]=new Tile();
            tile[13].image=ImageIO.read(getClass().getResourceAsStream("/tiles/masa.png"));
            tile[13].collision=true;

            tile[14]=new Tile();
            tile[14].image=ImageIO.read(getClass().getResourceAsStream("/tiles/fridge.png"));
            tile[14].collision=true;

            tile[15]=new Tile();
            tile[15].image=ImageIO.read(getClass().getResourceAsStream("/tiles/cuptor.png"));
            tile[15].collision=true;

            tile[16]=new Tile();
            tile[16].image=ImageIO.read(getClass().getResourceAsStream("/tiles/col2.png"));
            tile[16].collision=true;

            tile[17]=new Tile();
            tile[17].image=ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[17].collision=true;

            tile[18]=new Tile();
            tile[18].image=ImageIO.read(getClass().getResourceAsStream("/tiles/floor.png"));

            tile[19]=new Tile();
            tile[19].image=ImageIO.read(getClass().getResourceAsStream("/tiles/hay.png"));
            tile[19].collision=true;

            tile[20]=new Tile();
            tile[20].image=ImageIO.read(getClass().getResourceAsStream("/tiles/floor3.png"));


            tile[21]=new Tile();
            tile[21].image=ImageIO.read(getClass().getResourceAsStream("/tiles/wall3.png"));
            tile[21].collision=true;

            tile[22]=new Tile();
            tile[22].image=ImageIO.read(getClass().getResourceAsStream("/tiles/watero.png"));
            tile[22].collision=true;

            tile[23]=new Tile();
            tile[23].image=ImageIO.read(getClass().getResourceAsStream("/tiles/waterv.png"));
            tile[23].collision=true;

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //aceasta metoda creaza mapa in functie de un fisier .txt
    //(codul de pe fiecare linie si fiecare coloana se potriveste cu nr tile-ului in vector si se vor incarca in matrice)
    public void loadMap(String filepath,int map){
        try{
            InputStream is=getClass().getResourceAsStream(filepath);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row=0;
            while(col<gp.maxWorldCol&& row < gp.maxWorldRow) {
                String line=br.readLine();
                while(col<gp.maxWorldCol){
                    String numbers[]=line.split(" ");
                    int num=Integer.parseInt(numbers[col]);
                    mapTileNum[map][col][row]=num;
                    col++;
                }
                if(col==gp.maxWorldCol)
                {
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch (IOException e){

        }
    }
    //aceasta metoda deseneaza mapa in functie de valoare de pe fiecare linie si coloana
    public void draw(Graphics2D g2){
        int worldCol=0;
        int worldRow=0;
        while (worldCol<gp.maxWorldCol && worldRow <gp.maxWorldRow)
        {
            int tileNum=mapTileNum[gp.currentMap][worldCol][worldRow];
            int worldX=worldCol*gp.tileSize;
            int worldY=worldRow*gp.tileSize;
            int screenX=worldX-gp.player.worldX+gp.player.screenX;
            int screenY=worldY-gp.player.worldY+gp.player.screenY;
            if (worldX+gp.tileSize>gp.player.worldX-gp.player.screenX &&
                    worldX-gp.tileSize<gp.player.worldX+gp.player.screenX &&
                    worldY+gp.tileSize>gp.player.worldY-gp.player.screenY &&
                    worldY-gp.tileSize<gp.player.worldY+gp.player.screenY) {
                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            }
            worldCol++;
            if(worldCol==gp.maxWorldCol)
            {
                worldCol=0;
                worldRow++;
            }
        }
    }
}
