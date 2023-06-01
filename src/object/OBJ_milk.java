package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//Aceasta este clasa pentru obiectul-lapte mostenita din clasa SuperObject
public class OBJ_milk extends SuperObject{
    public OBJ_milk(){
        name="milk";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/milk.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
