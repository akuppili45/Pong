package com.gameobjects;

import com.company.GameObject;
import com.company.ObjectId;
import com.company.Handler;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 6/4/2017.
 */
public class PlayerTwo extends GameObject {
    int h = 27;
    public PlayerTwo(double x, double y, ObjectId id, Handler handler) {
        super(x, y, id, handler);
    }



    @Override
    public void tick(LinkedList<GameObject> object) {
        setY(getY() + getVelY());
        collision(getHandler().getObjects());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)getX(),(int)getY(), 25,80);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.BLUE);
//        g2D.draw(new Rectangle((int)getX(), (int)getY(), 2, h));
//        g2D.draw(new Rectangle((int)getX(), (int)getY() + h, 2, h));
//        g2D.draw(new Rectangle((int)getX(), (int)getY() + 2*h, 2, h));
//        g2D.draw(getBoundsLeft());
//        g2D.draw(getBoundsRight());
//        g2D.draw(getBoundsTop());
//        g2D.draw(getBoundsBottom());
    }
    @Override
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)getX(), (int)getY(), 2, 80);
    }

    @Override
    public Rectangle getBoundsTop() {
        return new Rectangle((int)getX(),(int)getY(),25,2);
    }

    @Override
    public Rectangle getBoundsRight() {
        return null;
    }

    @Override
    public Rectangle getBoundsBottom() {
        return new Rectangle((int)getX(),(int)getY() + 78,25,2);
    }

    @Override
    public void collision(LinkedList<GameObject> a) {
        for(int i = 0; i < a.size(); i++){
            GameObject tempObject = a.get(i);
            if(tempObject.getId() == ObjectId.Platform){
                if(getBoundsBottom().intersects(tempObject.getBoundsTop())){
                    setY(getY()-5);
                }
                if(getBoundsTop().intersects(tempObject.getBoundsBottom())){
                    setY(getY()+5);
                }

            }
        }
    }
    public Rectangle[] getLeftAngleBounds(){
        Rectangle[] a = {new Rectangle((int)getX(), (int)getY(), 2, h), new Rectangle((int)getX(), (int)getY() + h, 2, h), new Rectangle((int)getX(), (int)getY() + 2*h, 2, h) };
        return a;
    }
}
