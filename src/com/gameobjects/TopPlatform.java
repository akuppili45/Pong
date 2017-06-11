package com.gameobjects;

import com.company.GameObject;
import com.company.Handler;
import com.company.ObjectId;
import com.sun.prism.*;

import java.awt.*;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 6/10/2017.
 */
public class TopPlatform extends GameObject {
    public TopPlatform(double x, double y, ObjectId id, Handler handler) {
        super(x, y, id, handler);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int)getX(), (int)getY(), 750, 30);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.MAGENTA);
        g2D.draw(getBoundsBottom());
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
        return null;
    }

    @Override
    public Rectangle getBoundsBottom() {
        return new Rectangle((int)getX(), (int)getY() + 29, 750, 2);
    }

    @Override
    public void collision(LinkedList<GameObject> a) {

    }
}
