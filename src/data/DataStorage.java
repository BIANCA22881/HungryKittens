package data;

import java.io.Serializable;
public class DataStorage implements Serializable {
    //PLAYER STATS
    int worldX;
    int worldY;
    int maxLife;
    int life;
    int hasFish;
    boolean hasMilk;
    String colorCat;
    int currentMap;
    //OBJECTS ON MAP
    String[][] mapObjectNames;
    int[][] mapObjectWorldX;
    int[][] mapObjectWorldY;
}
