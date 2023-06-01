package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//Aceasta este clasa pentru obiectul-peste mostenita din clasa SuperObject
public class OBJ_fish extends SuperObject {
    public OBJ_fish(){
        name="fish";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/fish1.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
