package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//Aceasta este clasa pentru obiectul-uranium mostenita din clasa SuperObject
public class OBJ_uranium extends SuperObject{
    public OBJ_uranium(){
        name="uranium";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/mazga.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
