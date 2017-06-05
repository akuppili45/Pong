package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 6/4/2017.
 */
public abstract class GameObject {
    private double x;
    private double y;
    private double velX = 0;
    private double velY = 0;
    private ObjectId id;
    private Handler handler;

    public GameObject(double x, double y, ObjectId id, Handler handler){
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
    }
    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public double getVelX() {

        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getY() {

        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {

        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    public ObjectId getId() {
        return id;
    }
    public abstract Rectangle getBoundsLeft();
    public abstract Rectangle getBoundsTop();
    public abstract Rectangle getBoundsRight();
    public abstract Rectangle getBoundsBottom();
    public abstract void collision(LinkedList<GameObject> a);
    public Handler getHandler(){
        return handler;
    }
}
