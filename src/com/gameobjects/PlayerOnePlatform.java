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
public class PlayerOnePlatform extends GameObject
{
    public PlayerOnePlatform(double x, double y, ObjectId id,Handler handler) {
        super(x, y, id,handler);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int)getX(), (int)getY(), 32,32);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.MAGENTA);
//        g2D.draw(getBoundsLeft());
//        g2D.draw(getBoundsRight());
//        g2D.draw(getBoundsTop());
//        g2D.draw(getBoundsBottom());
    }

    @Override
    public Rectangle getBoundsLeft() {
        return null;
    }

    @Override
    public Rectangle getBoundsTop() {
        return null;
    }

    @Override
    public Rectangle getBoundsRight() {
        return new Rectangle((int)getX()+30, (int)getY(), 2,80);
    }

    @Override
    public Rectangle getBoundsBottom() {
        return null;
    }

    @Override
    public void collision(LinkedList<GameObject> a) {

    }
}
