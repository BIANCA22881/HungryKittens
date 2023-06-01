package main;
import entity.NPC_mouse;
import entity.NPC_rat;
import main.GamePanel;
import object.*;
//In aceasta clasa alegi coordonatele fiecarui obiect si al fiecarui inamic de pe fiecare harta
public class AssetSetter {
     GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject() {
        int mapNum = 0;
        {
            gp.obj[mapNum][0] = new OBJ_fish();
            gp.obj[mapNum][0].worldX = 4 * gp.tileSize;
            gp.obj[mapNum][0].worldY = 8 * gp.tileSize;

            gp.obj[mapNum][1] = new OBJ_fish();
            gp.obj[mapNum][1].worldX = 11 * gp.tileSize;
            gp.obj[mapNum][1].worldY = 8 * gp.tileSize;

            gp.obj[mapNum][2] = new OBJ_fish();
            gp.obj[mapNum][2].worldX = 17 * gp.tileSize;
            gp.obj[mapNum][2].worldY = 10 * gp.tileSize;

            gp.obj[mapNum][3] = new OBJ_fish();
            gp.obj[mapNum][3].worldX = 4 * gp.tileSize;
            gp.obj[mapNum][3].worldY = 16 * gp.tileSize;

            gp.obj[mapNum][4] = new OBJ_fish();
            gp.obj[mapNum][4].worldX = 5 * gp.tileSize;
            gp.obj[mapNum][4].worldY = 21 * gp.tileSize;

            gp.obj[mapNum][5] = new OBJ_fish();
            gp.obj[mapNum][5].worldX = 15 * gp.tileSize;
            gp.obj[mapNum][5].worldY = 12 * gp.tileSize;

            gp.obj[mapNum][6] = new OBJ_fish();
            gp.obj[mapNum][6].worldX = 16 * gp.tileSize;
            gp.obj[mapNum][6].worldY = 18 * gp.tileSize;

            gp.obj[mapNum][7] = new OBJ_fish();
            gp.obj[mapNum][7].worldX = 15 * gp.tileSize;
            gp.obj[mapNum][7].worldY = 23 * gp.tileSize;

            gp.obj[mapNum][8] = new OBJ_fish();
            gp.obj[mapNum][8].worldX = 23 * gp.tileSize;
            gp.obj[mapNum][8].worldY = 19 * gp.tileSize;

            gp.obj[mapNum][9] = new OBJ_door();
            gp.obj[mapNum][9].worldX = 12 * gp.tileSize;
            gp.obj[mapNum][9].worldY = 21 * gp.tileSize;

            gp.obj[mapNum][10] = new OBJ_milk();
            gp.obj[mapNum][10].worldX = 4 * gp.tileSize;
            gp.obj[mapNum][10].worldY = 20 * gp.tileSize;

            gp.obj[mapNum][11] = new OBJ_milk();
            gp.obj[mapNum][11].worldX = 23 * gp.tileSize;
            gp.obj[mapNum][11].worldY = 21 * gp.tileSize;

            gp.obj[mapNum][12] = new OBJ_finalfish();
            gp.obj[mapNum][12].worldX = 12 * gp.tileSize;
            gp.obj[mapNum][12].worldY = 26 * gp.tileSize;

            gp.obj[mapNum][13] = new OBJ_fish();
            gp.obj[mapNum][13].worldX = 9 * gp.tileSize;
            gp.obj[mapNum][13].worldY = 11 * gp.tileSize;

            gp.obj[mapNum][14] = new OBJ_fish();
            gp.obj[mapNum][14].worldX = 9 * gp.tileSize;
            gp.obj[mapNum][14].worldY = 13 * gp.tileSize;

            gp.obj[mapNum][15] = new OBJ_fish();
            gp.obj[mapNum][15].worldX = 6 * gp.tileSize;
            gp.obj[mapNum][15].worldY = 19 * gp.tileSize;

            gp.obj[mapNum][16] = new OBJ_fish();
            gp.obj[mapNum][16].worldX = 13 * gp.tileSize;
            gp.obj[mapNum][16].worldY = 16 * gp.tileSize;

            gp.obj[mapNum][17] = new OBJ_fish();
            gp.obj[mapNum][17].worldX = 23 * gp.tileSize;
            gp.obj[mapNum][17].worldY = 13 * gp.tileSize;

            gp.obj[mapNum][18] = new OBJ_fish();
            gp.obj[mapNum][18].worldX = 13 * gp.tileSize;
            gp.obj[mapNum][18].worldY = 20 * gp.tileSize;

            gp.obj[mapNum][19] = new OBJ_fish();
            gp.obj[mapNum][19].worldX = 18 * gp.tileSize;
            gp.obj[mapNum][19].worldY = 8 * gp.tileSize;

            gp.obj[mapNum][20] = new OBJ_fish();
            gp.obj[mapNum][20].worldX = 22 * gp.tileSize;
            gp.obj[mapNum][20].worldY = 21 * gp.tileSize;

        }
        mapNum=1;
        {
            gp.obj[mapNum][0] = new OBJ_fish();
            gp.obj[mapNum][0].worldX = 12 * gp.tileSize;
            gp.obj[mapNum][0].worldY = 7 * gp.tileSize;

            gp.obj[mapNum][1] = new OBJ_fish();
            gp.obj[mapNum][1].worldX = 8 * gp.tileSize;
            gp.obj[mapNum][1].worldY = 15 * gp.tileSize;

            gp.obj[mapNum][2] = new OBJ_fish();
            gp.obj[mapNum][2].worldX = 3 * gp.tileSize;
            gp.obj[mapNum][2].worldY = 22 * gp.tileSize;

            gp.obj[mapNum][3] = new OBJ_fish();
            gp.obj[mapNum][3].worldX = 26 * gp.tileSize;
            gp.obj[mapNum][3].worldY = 7 * gp.tileSize;

            gp.obj[mapNum][4] = new OBJ_fish();
            gp.obj[mapNum][4].worldX = 27 * gp.tileSize;
            gp.obj[mapNum][4].worldY = 27 * gp.tileSize;

            gp.obj[mapNum][5] = new OBJ_milk();
            gp.obj[mapNum][5].worldX = 13 * gp.tileSize;
            gp.obj[mapNum][5].worldY = 5 * gp.tileSize;

            gp.obj[mapNum][6] = new OBJ_milk();
            gp.obj[mapNum][6].worldX = 17 * gp.tileSize;
            gp.obj[mapNum][6].worldY = 15 * gp.tileSize;

            gp.obj[mapNum][7] = new OBJ_milk();
            gp.obj[mapNum][7].worldX = 13 * gp.tileSize;
            gp.obj[mapNum][7].worldY = 28 * gp.tileSize;

            gp.obj[mapNum][8] = new OBJ_finalfish();
            gp.obj[mapNum][8].worldX = 17 * gp.tileSize;
            gp.obj[mapNum][8].worldY = 28 * gp.tileSize;

            gp.obj[mapNum][9] = new OBJ_fish();
            gp.obj[mapNum][9].worldX = 6 * gp.tileSize;
            gp.obj[mapNum][9].worldY = gp.tileSize;

            gp.obj[mapNum][10] = new OBJ_fish();
            gp.obj[mapNum][10].worldX = 17 * gp.tileSize;
            gp.obj[mapNum][10].worldY = gp.tileSize;

            gp.obj[mapNum][11] = new OBJ_fish();
            gp.obj[mapNum][11].worldX = 27 * gp.tileSize;
            gp.obj[mapNum][11].worldY = 4 * gp.tileSize;

            gp.obj[mapNum][12] = new OBJ_fish();
            gp.obj[mapNum][12].worldX = 12 * gp.tileSize;
            gp.obj[mapNum][12].worldY = 5 * gp.tileSize;

            gp.obj[mapNum][13] = new OBJ_fish();
            gp.obj[mapNum][13].worldX = 21 * gp.tileSize;
            gp.obj[mapNum][13].worldY = 8 * gp.tileSize;

            gp.obj[mapNum][14] = new OBJ_fish();
            gp.obj[mapNum][14].worldX = 3 * gp.tileSize;
            gp.obj[mapNum][14].worldY = 10 * gp.tileSize;

            gp.obj[mapNum][15] = new OBJ_fish();
            gp.obj[mapNum][15].worldX = 26 * gp.tileSize;
            gp.obj[mapNum][15].worldY = 10 * gp.tileSize;

            gp.obj[mapNum][16] = new OBJ_fish();
            gp.obj[mapNum][16].worldX = 13 * gp.tileSize;
            gp.obj[mapNum][16].worldY = 11 * gp.tileSize;

            gp.obj[mapNum][17] = new OBJ_fish();
            gp.obj[mapNum][17].worldX = 15 * gp.tileSize;
            gp.obj[mapNum][17].worldY = 11 * gp.tileSize;

            gp.obj[mapNum][18] = new OBJ_fish();
            gp.obj[mapNum][18].worldX = 4 * gp.tileSize;
            gp.obj[mapNum][18].worldY = 17 * gp.tileSize;

            gp.obj[mapNum][19] = new OBJ_fish();
            gp.obj[mapNum][19].worldX = 28 * gp.tileSize;
            gp.obj[mapNum][19].worldY = 16 * gp.tileSize;

            gp.obj[mapNum][20] = new OBJ_fish();
            gp.obj[mapNum][20].worldX = 14 * gp.tileSize;
            gp.obj[mapNum][20].worldY = 21 * gp.tileSize;

            gp.obj[mapNum][21] = new OBJ_fish();
            gp.obj[mapNum][21].worldX = 19 * gp.tileSize;
            gp.obj[mapNum][21].worldY = 21 * gp.tileSize;

            gp.obj[mapNum][22] = new OBJ_fish();
            gp.obj[mapNum][22].worldX = 24 * gp.tileSize;
            gp.obj[mapNum][22].worldY = 21 * gp.tileSize;

            gp.obj[mapNum][23] = new OBJ_fish();
            gp.obj[mapNum][23].worldX = 8 * gp.tileSize;
            gp.obj[mapNum][23].worldY = 22 * gp.tileSize;

            gp.obj[mapNum][24] = new OBJ_fish();
            gp.obj[mapNum][24].worldX = 10 * gp.tileSize;
            gp.obj[mapNum][24].worldY = 24 * gp.tileSize;

            gp.obj[mapNum][25] = new OBJ_fish();
            gp.obj[mapNum][25].worldX = 15 * gp.tileSize;
            gp.obj[mapNum][25].worldY = 25 * gp.tileSize;

            gp.obj[mapNum][26] = new OBJ_fish();
            gp.obj[mapNum][26].worldX = 7 * gp.tileSize;
            gp.obj[mapNum][26].worldY = 19 * gp.tileSize;

        }
        mapNum=2;
        {
            gp.obj[mapNum][0] = new OBJ_fish();
            gp.obj[mapNum][0].worldX = 7 * gp.tileSize;
            gp.obj[mapNum][0].worldY = gp.tileSize;

            gp.obj[mapNum][1] = new OBJ_fish();
            gp.obj[mapNum][1].worldX = 10 * gp.tileSize;
            gp.obj[mapNum][1].worldY = gp.tileSize;

            gp.obj[mapNum][2] = new OBJ_fish();
            gp.obj[mapNum][2].worldX = 22 * gp.tileSize;
            gp.obj[mapNum][2].worldY = gp.tileSize;

            gp.obj[mapNum][3] = new OBJ_fish();
            gp.obj[mapNum][3].worldX = 3 * gp.tileSize;
            gp.obj[mapNum][3].worldY = 4 * gp.tileSize;

            gp.obj[mapNum][4] = new OBJ_fish();
            gp.obj[mapNum][4].worldX = 20 * gp.tileSize;
            gp.obj[mapNum][4].worldY = 4 * gp.tileSize;

            gp.obj[mapNum][5] = new OBJ_fish();
            gp.obj[mapNum][5].worldX = 15 * gp.tileSize;
            gp.obj[mapNum][5].worldY = 5 * gp.tileSize;

            gp.obj[mapNum][6] = new OBJ_fish();
            gp.obj[mapNum][6].worldX = 7 * gp.tileSize;
            gp.obj[mapNum][6].worldY = 6 * gp.tileSize;

            gp.obj[mapNum][7] = new OBJ_fish();
            gp.obj[mapNum][7].worldX = 27 * gp.tileSize;
            gp.obj[mapNum][7].worldY = 6 * gp.tileSize;

            gp.obj[mapNum][8] = new OBJ_fish();
            gp.obj[mapNum][8].worldX = 16 * gp.tileSize;
            gp.obj[mapNum][8].worldY = 12* gp.tileSize;

            gp.obj[mapNum][9] = new OBJ_fish();
            gp.obj[mapNum][9].worldX = 24 * gp.tileSize;
            gp.obj[mapNum][9].worldY = 13 * gp.tileSize;

            gp.obj[mapNum][10] = new OBJ_fish();
            gp.obj[mapNum][10].worldX = 4 * gp.tileSize;
            gp.obj[mapNum][10].worldY = 14 * gp.tileSize;

            gp.obj[mapNum][11] = new OBJ_fish();
            gp.obj[mapNum][11].worldX = 15 * gp.tileSize;
            gp.obj[mapNum][11].worldY = 14 * gp.tileSize;

            gp.obj[mapNum][12] = new OBJ_fish();
            gp.obj[mapNum][12].worldX = 19 * gp.tileSize;
            gp.obj[mapNum][12].worldY = 14 * gp.tileSize;

            gp.obj[mapNum][13] = new OBJ_fish();
            gp.obj[mapNum][13].worldX = 5 * gp.tileSize;
            gp.obj[mapNum][13].worldY = 16 * gp.tileSize;

            gp.obj[mapNum][14] = new OBJ_fish();
            gp.obj[mapNum][14].worldX = 13 * gp.tileSize;
            gp.obj[mapNum][14].worldY = 16 * gp.tileSize;

            gp.obj[mapNum][15] = new OBJ_fish();
            gp.obj[mapNum][15].worldX = 22 * gp.tileSize;
            gp.obj[mapNum][15].worldY = 19 * gp.tileSize;

            gp.obj[mapNum][16] = new OBJ_fish();
            gp.obj[mapNum][16].worldX = 25 * gp.tileSize;
            gp.obj[mapNum][16].worldY = 19 * gp.tileSize;

            gp.obj[mapNum][17] = new OBJ_fish();
            gp.obj[mapNum][17].worldX = 17 * gp.tileSize;
            gp.obj[mapNum][17].worldY = 21 * gp.tileSize;

            gp.obj[mapNum][18] = new OBJ_fish();
            gp.obj[mapNum][18].worldX = 13 * gp.tileSize;
            gp.obj[mapNum][18].worldY =22 * gp.tileSize;

            gp.obj[mapNum][19] = new OBJ_fish();
            gp.obj[mapNum][19].worldX = 19 * gp.tileSize;
            gp.obj[mapNum][19].worldY = 23 * gp.tileSize;

            gp.obj[mapNum][20] = new OBJ_fish();
            gp.obj[mapNum][20].worldX = 6 * gp.tileSize;
            gp.obj[mapNum][20].worldY = 24 * gp.tileSize;

            gp.obj[mapNum][21] = new OBJ_fish();
            gp.obj[mapNum][21].worldX = 8 * gp.tileSize;
            gp.obj[mapNum][21].worldY = 24 * gp.tileSize;

            gp.obj[mapNum][22] = new OBJ_fish();
            gp.obj[mapNum][22].worldX = 28 * gp.tileSize;
            gp.obj[mapNum][22].worldY = 26 * gp.tileSize;

            gp.obj[mapNum][23] = new OBJ_fish();
            gp.obj[mapNum][23].worldX = gp.tileSize;
            gp.obj[mapNum][23].worldY = 28 * gp.tileSize;

            gp.obj[mapNum][24] = new OBJ_fish();
            gp.obj[mapNum][24].worldX = 23 * gp.tileSize;
            gp.obj[mapNum][24].worldY = 28 * gp.tileSize;

            gp.obj[mapNum][25] = new OBJ_milk();
            gp.obj[mapNum][25].worldX = 23 * gp.tileSize;
            gp.obj[mapNum][25].worldY = 25 * gp.tileSize;

            gp.obj[mapNum][26] = new OBJ_milk();
            gp.obj[mapNum][26].worldX = 10 * gp.tileSize;
            gp.obj[mapNum][26].worldY = 19 * gp.tileSize;

            gp.obj[mapNum][27] = new OBJ_milk();
            gp.obj[mapNum][27].worldX = 24 * gp.tileSize;
            gp.obj[mapNum][27].worldY = 11 * gp.tileSize;

            gp.obj[mapNum][28] = new OBJ_milk();
            gp.obj[mapNum][28].worldX = 8 * gp.tileSize;
            gp.obj[mapNum][28].worldY = 9 * gp.tileSize;

            gp.obj[mapNum][29] = new OBJ_finalfish();
            gp.obj[mapNum][29].worldX = 14 * gp.tileSize;
            gp.obj[mapNum][29].worldY = 2 * gp.tileSize;

            gp.obj[mapNum][30] = new OBJ_uranium();
            gp.obj[mapNum][30].worldX = 17 * gp.tileSize;
            gp.obj[mapNum][30].worldY = 2 * gp.tileSize;

            gp.obj[mapNum][31] = new OBJ_uranium();
            gp.obj[mapNum][31].worldX = 3 * gp.tileSize;
            gp.obj[mapNum][31].worldY = 25 * gp.tileSize;

            gp.obj[mapNum][32] = new OBJ_uranium();
            gp.obj[mapNum][32].worldX = 28 * gp.tileSize;
            gp.obj[mapNum][32].worldY = 4 * gp.tileSize;

            gp.obj[mapNum][33] = new OBJ_uranium();
            gp.obj[mapNum][33].worldX = 2 * gp.tileSize;
            gp.obj[mapNum][33].worldY = 9 * gp.tileSize;

            gp.obj[mapNum][34] = new OBJ_uranium();
            gp.obj[mapNum][34].worldX = 22 * gp.tileSize;
            gp.obj[mapNum][34].worldY = 13 * gp.tileSize;

            gp.obj[mapNum][35] = new OBJ_uranium();
            gp.obj[mapNum][35].worldX = 27 * gp.tileSize;
            gp.obj[mapNum][35].worldY = 17 * gp.tileSize;

            gp.obj[mapNum][36] = new OBJ_uranium();
            gp.obj[mapNum][36].worldX = 8 * gp.tileSize;
            gp.obj[mapNum][36].worldY = 20 * gp.tileSize;

            gp.obj[mapNum][37] = new OBJ_uranium();
            gp.obj[mapNum][37].worldX = 3 * gp.tileSize;
            gp.obj[mapNum][37].worldY = 21 * gp.tileSize;
        }
    }
    public void setNPC(){
        int mapNum=0;
        {
            gp.npc[mapNum][0] = new NPC_mouse(gp);
            gp.npc[mapNum][0].worldX = gp.tileSize * 8;
            gp.npc[mapNum][0].worldY = gp.tileSize * 13;

            gp.npc[mapNum][1] = new NPC_mouse(gp);
            gp.npc[mapNum][1].worldX = gp.tileSize * 19;
            gp.npc[mapNum][1].worldY = gp.tileSize * 19;

            gp.npc[mapNum][2] = new NPC_mouse(gp);
            gp.npc[mapNum][2].worldX = gp.tileSize * 13;
            gp.npc[mapNum][2].worldY = gp.tileSize * 8;

            gp.npc[mapNum][3] = new NPC_mouse(gp);
            gp.npc[mapNum][3].worldX = gp.tileSize * 15;
            gp.npc[mapNum][3].worldY = gp.tileSize * 12;
        }
        mapNum=1;
        {
            gp.npc[mapNum][0] = new NPC_rat(gp);
            gp.npc[mapNum][0].worldX = gp.tileSize * 2;
            gp.npc[mapNum][0].worldY = gp.tileSize * 7;

            gp.npc[mapNum][1] = new NPC_rat(gp);
            gp.npc[mapNum][1].worldX = gp.tileSize * 13;
            gp.npc[mapNum][1].worldY = gp.tileSize * 13;

            gp.npc[mapNum][2] = new NPC_rat(gp);
            gp.npc[mapNum][2].worldX = gp.tileSize * 4;
            gp.npc[mapNum][2].worldY = gp.tileSize * 27;

            gp.npc[mapNum][3] = new NPC_rat(gp);
            gp.npc[mapNum][3].worldX = gp.tileSize * 17;
            gp.npc[mapNum][3].worldY = gp.tileSize * 27;

        }
        mapNum=2;
        {
            gp.npc[mapNum][0] = new NPC_mouse(gp);
            gp.npc[mapNum][0].worldX = gp.tileSize * 5;
            gp.npc[mapNum][0].worldY = gp.tileSize * 17;

            gp.npc[mapNum][1] = new NPC_mouse(gp);
            gp.npc[mapNum][1].worldX = gp.tileSize * 10;
            gp.npc[mapNum][1].worldY = gp.tileSize ;

            gp.npc[mapNum][2] = new NPC_mouse(gp);
            gp.npc[mapNum][2].worldX = gp.tileSize * 9;
            gp.npc[mapNum][2].worldY = gp.tileSize * 24;

            gp.npc[mapNum][3] = new NPC_mouse(gp);
            gp.npc[mapNum][3].worldX = gp.tileSize * 26;
            gp.npc[mapNum][3].worldY = gp.tileSize * 7;

            gp.npc[mapNum][4] = new NPC_rat(gp);
            gp.npc[mapNum][4].worldX = gp.tileSize * 22;
            gp.npc[mapNum][4].worldY = gp.tileSize * 2;

            gp.npc[mapNum][5] = new NPC_rat(gp);
            gp.npc[mapNum][5].worldX = gp.tileSize * 15;
            gp.npc[mapNum][5].worldY = gp.tileSize * 7;

            gp.npc[mapNum][6] = new NPC_rat(gp);
            gp.npc[mapNum][6].worldX = gp.tileSize * 3;
            gp.npc[mapNum][6].worldY = gp.tileSize * 11;

            gp.npc[mapNum][7] = new NPC_rat(gp);
            gp.npc[mapNum][7].worldX = gp.tileSize * 13;
            gp.npc[mapNum][7].worldY = gp.tileSize * 18;

            gp.npc[mapNum][8] = new NPC_mouse(gp);
            gp.npc[mapNum][8].worldX = gp.tileSize * 27;
            gp.npc[mapNum][8].worldY = gp.tileSize * 21;

            gp.npc[mapNum][9] = new NPC_rat(gp);
            gp.npc[mapNum][9].worldX = gp.tileSize * 16;
            gp.npc[mapNum][9].worldY = gp.tileSize * 26;
        }
    }
}
