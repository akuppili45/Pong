package com.gameobjects;

import com.company.GameObject;
import com.company.ObjectId;

import java.awt.*;
import java.util.LinkedList;
import com.company.GameObject;
import com.company.Handler;

/**
 * Created by akupp_000 on 6/4/2017.
 */
public class Ball extends GameObject {
    int velocity = -5;
    public Ball(double x, double y, ObjectId id,Handler handler) {
        super(x, y, id, handler);
    }



    @Override
    public void tick(LinkedList<GameObject> object) {
        setVelX(velocity);
        setX(getX()+getVelX());
        setY(getY()+getVelY());
        collision(getHandler().getObjects());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval((int)getX(),(int)getY(), 30,30);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.MAGENTA);
        //g2D.draw(getBoundsLeft());
//        g2D.draw(getBoundsRight());
//        g2D.draw(getBoundsTop());
//        g2D.draw(getBoundsBottom());

    }
    @Override
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)getX(), (int)getY() + 7, 2,15);
    }

    @Override
    public Rectangle getBoundsTop() {
        return null;
    }

    @Override
    public Rectangle getBoundsRight() {
        return new Rectangle((int)getX() +25, (int)getY() + 9, 5,15);
    }

    @Override
    public Rectangle getBoundsBottom() {
        return null;
    }

    @Override
    public void collision(LinkedList<GameObject> a) {
        for(int i = 0; i < a.size(); i++){
            GameObject tempObject = a.get(i);
            if(tempObject.getId() == ObjectId.PlayerOne){
                if(getBoundsLeft().intersects(tempObject.getBoundsRight())){
                   velocity = 5;
                }
            }
            if(tempObject.getId() == ObjectId.PlayerTwo){
                if(getBoundsRight().intersects(tempObject.getBoundsLeft())){
                    velocity = -5;
                }
            }
            if(tempObject.getId() == ObjectId.PlayerOnePlatform){
                if(getBoundsLeft().intersects(tempObject.getBoundsRight())){
                    velocity = 0;
                }
            }
            if(tempObject.getId() == ObjectId.PlayerTwoPlatform){
                if(getBoundsRight().intersects(tempObject.getBoundsLeft())){
                    velocity = 0;
                }
            }

        }
    }
}
