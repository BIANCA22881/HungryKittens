/*package main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX,eventRectDefaultY;
    public EventHandler(GamePanel gp){
        this.gp=gp;
        eventRect=new Rectangle();
        eventRect.x=31;
        eventRect.y=31;
        eventRect.width=2;
        eventRect.height=2;
        eventRectDefaultX=eventRect.x;
        eventRectDefaultY=eventRect.y;
    }
    public void checkEvent(){

    }
    public boolean hit(int eventCol,int eventRow,String reqDirection){
        boolean hit=false;
        gp.player.solidArea.x=gp.player.worldX+gp.player.solidArea.x;
        gp.player.solidArea.y=gp.player.worldY+gp.player.solidArea.y;
        eventRect.x=eventCol*gp.tileSize+eventRect.x;
        eventRect.y=eventRow*gp.tileSize+eventRect.y;

        if(gp.player.solidArea.intersects(eventRect)){
            if(gp.player.direction.contentEquals(reqDirection)||reqDirection.contentEquals("any")){
                hit=true;
            }
        }
        gp.player.solidArea.x=gp.player.solidAreaDefaultX;
        gp.player.solidArea.y=gp.player.solidAreaDefaultY;
        eventRect.x=eventRectDefaultX;
        eventRect.y=eventRectDefaultY;

        return hit;
    }

}
*/