package com.gameobjects;

import com.company.GameObject;
import com.company.Handler;
import com.company.ObjectId;

import java.awt.*;
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
        return null;
    }

    @Override
    public void collision(LinkedList<GameObject> a) {

    }
}
