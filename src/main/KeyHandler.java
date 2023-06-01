package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed,downPressed,leftPressed,rightPressed;
    GamePanel gp;
    public KeyHandler(GamePanel gp){
        this.gp=gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        //TITLE STATE
        if(gp.gameState==gp.titleState){
            //MENIU MARE
            if(gp.ui.TtileScreenState==0){
                if(code==KeyEvent.VK_UP){
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum<0){
                        gp.ui.commandNum=2;
                    }
                }
                if(code==KeyEvent.VK_DOWN){
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum>2){
                        gp.ui.commandNum=0;
                    }
                }
                if(code==KeyEvent.VK_ENTER){
                    if(gp.ui.commandNum==0){//NEW GAME
                        gp.ui.TtileScreenState=1;
                    }
                    if(gp.ui.commandNum==1){//LOAD GAME
                        gp.saveLoad.load();
                        gp.gameState=gp.playState;
                    }
                    if(gp.ui.commandNum==2){//QUIT
                        System.exit(0);
                    }
                }
            }
            else {
                //SUBMENIU
                if (gp.ui.TtileScreenState == 1) {
                    if (code == KeyEvent.VK_UP) {
                        gp.ui.commandNum--;
                        if (gp.ui.commandNum < 0) {
                            gp.ui.commandNum = 4;
                        }
                    }
                    if (code == KeyEvent.VK_DOWN) {
                        gp.ui.commandNum++;
                        if (gp.ui.commandNum > 4) {
                            gp.ui.commandNum = 0;
                        }
                    }
                    //aici iti alegi culoarea pisicii si in functie de asta player ul primeste getImage("Culoarea aleasa")
                    if (code == KeyEvent.VK_ENTER) {
                        if (gp.ui.commandNum == 0) {
                            gp.player.getPlayerImage("white");
                            gp.gameState = gp.playState;
                            gp.currentMap=0;
                            gp.restart();
                        }
                        if (gp.ui.commandNum == 1) {
                            gp.player.getPlayerImage("ginger");
                            gp.gameState = gp.playState;
                            gp.currentMap=0;
                            gp.restart();
                        }
                        if (gp.ui.commandNum == 2) {
                            gp.player.getPlayerImage("black");
                            gp.gameState = gp.playState;
                            gp.currentMap=0;
                            gp.restart();
                        }
                        if (gp.ui.commandNum == 3) {
                            gp.player.getPlayerImage("brown");
                            gp.gameState = gp.playState;
                            gp.currentMap=0;
                            gp.restart();
                        }
                        if (gp.ui.commandNum == 4) {
                            gp.ui.TtileScreenState = 0;
                            gp.ui.commandNum=0;
                        }
                    }
                }
            }
        }
        else{
            if(gp.gameState==gp.gameOverState){
                gp.ui.commandNum=0;
                if(code==KeyEvent.VK_UP){
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum<0){
                        gp.ui.commandNum=1;
                    }
                }
                if(code==KeyEvent.VK_DOWN){
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum>1){
                        gp.ui.commandNum=0;
                    }
                }
                if(code==KeyEvent.VK_ENTER){
                    if(gp.ui.commandNum==0){
                        gp.ui.TtileScreenState=0;
                        gp.gameState=gp.titleState;
                        gp.restart();
                    }
                    if(gp.ui.commandNum==1){
                        System.exit(0);
                    }
                }
            }
        }
        if(gp.gameState==gp.playState) {
            if (code == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            //daca apasam esc se salveaza jocul si se revine la meniu
            if(code==KeyEvent.VK_ESCAPE){
                gp.saveLoad.save();
                gp.ui.TtileScreenState=0;
                gp.gameState=gp.titleState;
            }
        }
        if (gp.gameState==gp.youWonState){
            if(code==KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }
            if(code==KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>1){
                    gp.ui.commandNum=0;
                }
            }
            if(code==KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    if(gp.currentMap==0) {//daca suntem la primul nivel si trecem la al doilea
                        gp.currentMap = 1;
                        gp.player.positionsLevel2();
                        gp.gameState = gp.playState;
                    }
                    else {
                        if (gp.currentMap == 1) {//daca suntem la al doilea nivel si trecem la al treilea
                            gp.currentMap = 2;
                            gp.player.positionsLevel3();
                            gp.gameState = gp.playState;
                        }
                    }
                }
                if(gp.ui.commandNum==1){
                    System.exit(0);
                }
            }
        }
        if(gp.currentMap==2 &&gp.player.youWin){//daca am terminat al treilea nivel se adauga scorul in baza de date si se afiseaza mesajul de final
            gp.insertB("data","SCORE",gp.player.life,gp.player.hasFish);
            gp.gameState=gp.finalState;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_UP){
            upPressed=false;
        }
        if(code==KeyEvent.VK_DOWN){
            downPressed=false;
        }
        if(code==KeyEvent.VK_LEFT){
            leftPressed=false;
        }
        if(code==KeyEvent.VK_RIGHT){
            rightPressed=false;
        }
    }
}
