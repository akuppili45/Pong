package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by akupp_000 on 6/4/2017.
 */
public class KeyInput extends KeyAdapter
{
    Handler handler;
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if(tempObject.getId() == ObjectId.PlayerOne) {
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                }
               else if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                }
            }
            if(tempObject.getId() == ObjectId.PlayerTwo) {
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelY(-5);
                }
                else if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(5);
                }
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if(tempObject.getId() == ObjectId.PlayerOne) {
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(0);
                }
                else if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(0);
                }
            }
            else if(tempObject.getId() == ObjectId.PlayerTwo) {
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelY(0);
                }
                else if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(0);
                }
            }
        }
    }

}
