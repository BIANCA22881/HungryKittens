package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//Aceasta este clasa pentru obiectul-finalfish mostenita din clasa SuperObject
public class OBJ_finalfish extends SuperObject{
    public OBJ_finalfish(){
        name="finalfish";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/fish2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
