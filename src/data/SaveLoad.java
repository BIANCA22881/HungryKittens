package data;

import main.GamePanel;
import object.*;

import java.io.*;

public class SaveLoad {
    GamePanel gp;
    public SaveLoad(GamePanel gp){
        this.gp=gp;
    }
    public void save(){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            DataStorage ds=new DataStorage();
            ds.worldX=gp.player.worldX;
            ds.worldY=gp.player.worldY;
            ds.maxLife=gp.player.maxLife;
            ds.life=gp.player.life;
            ds.hasFish=gp.player.hasFish;
            ds.hasMilk=gp.player.hasMilk;
            ds.colorCat=gp.player.colorCat;
            ds.currentMap=gp.currentMap;
            //Objects
            ds.mapObjectNames=new String[gp.maxMap][gp.obj[1].length];
            ds.mapObjectWorldX=new int[gp.maxMap][gp.obj[1].length];
            ds.mapObjectWorldY=new int[gp.maxMap][gp.obj[1].length];

            for(int mapNum=0;mapNum<gp.maxMap;mapNum++){
                for(int i=0;i<gp.obj[1].length;i++){
                    if(gp.obj[mapNum][i]==null){
                        ds.mapObjectNames[mapNum][i]="No obj";
                    }
                    else{
                        ds.mapObjectNames[mapNum][i]=gp.obj[mapNum][i].name;
                        ds.mapObjectWorldX[mapNum][i]=gp.obj[mapNum][i].worldX;
                        ds.mapObjectWorldY[mapNum][i]=gp.obj[mapNum][i].worldY;
                    }
                }
            }
            oos.writeObject(ds);
        } catch (IOException e) {
            System.out.println("Save Exception!");
        }
    }
    public void load(){
        try{
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("save.dat")));
            DataStorage ds=(DataStorage)ois.readObject();
            gp.player.worldX=ds.worldX;
            gp.player.worldY=ds.worldY;
            gp.player.maxLife=ds.maxLife;
            gp.player.life=ds.life;
            gp.player.hasFish=ds.hasFish;
            gp.player.hasMilk=ds.hasMilk;
            gp.player.getPlayerImage(ds.colorCat);
            gp.currentMap=ds.currentMap;
            //Objects
            for(int mapNum=0;mapNum<gp.maxMap;mapNum++){
                for(int i=0;i<gp.obj[1].length;i++){
                    if(ds.mapObjectNames[mapNum][i].equals("No obj")){
                        gp.obj[mapNum][i]=null;
                    }
                    else{
                        gp.obj[mapNum][i]=getObject(ds.mapObjectNames[mapNum][i]);
                        gp.obj[mapNum][i].worldX=ds.mapObjectWorldX[mapNum][i];
                        gp.obj[mapNum][i].worldY=ds.mapObjectWorldY[mapNum][i];
                    }
                }
            }
        } catch(Exception e){
            System.out.println("Load Exception!");
        }
    }

    public SuperObject getObject(String objName) {
        SuperObject obj=new SuperObject();
        switch (objName){
            case "fish" -> {
                obj=new OBJ_fish();
            }
            case "door" -> {
                obj=new OBJ_door();
            }
            case "milk" -> {
                obj=new OBJ_milk();
            }
            case "finalfish" ->{
                obj=new OBJ_finalfish();
            }
            case "uranium"->{
                obj=new OBJ_uranium();
            }
        }
        return obj;
    }
}
