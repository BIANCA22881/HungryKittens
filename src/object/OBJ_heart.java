package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

//Aceasta este clasa pentru obiectul-inima mostenita din clasa SuperObject
public class OBJ_heart extends SuperObject{
    GamePanel gp;
    public OBJ_heart(GamePanel gp){
        this.gp=gp;
        name="heart";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/heartf.png"));
            image2= ImageIO.read(getClass().getResourceAsStream("/objects/hearth.png"));
            image3= ImageIO.read(getClass().getResourceAsStream("/objects/hearte.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
