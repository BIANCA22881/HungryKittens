package object;

import javax.imageio.ImageIO;
import java.io.IOException;
//Aceasta este clasa pentru obiectul-usa mostenita din clasa SuperObject
public class OBJ_door extends SuperObject{
    public OBJ_door(){
        collision=true;//pisica nu poate trece prin ea
        name="door";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
