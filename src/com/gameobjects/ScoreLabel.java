package com.gameobjects;

import com.company.GameObject;
import com.company.Handler;
import com.company.ObjectId;
import javafx.scene.text.*;

import java.awt.*;
import java.awt.Font;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 6/13/2017.
 */
public class ScoreLabel extends GameObject
{
    private int score = 0;

    public ScoreLabel(double x, double y, ObjectId id, Handler handler) {
        super(x, y, id, handler);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    public void render(Graphics g){
        Font font = new Font("arial", Font.BOLD, 25);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, (int)getX(),(int)getY() );
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
