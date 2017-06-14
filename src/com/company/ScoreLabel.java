package com.company;

import java.awt.*;

/**
 * Created by akupp_000 on 6/13/2017.
 */
public class ScoreLabel
{
    private int score = 0;
   private double x;
   private double y;
    public ScoreLabel(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void render(Graphics g){
        Font fnt0 = new Font("arial", Font.BOLD, 25);
        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, (int)x, (int)y);

    }
}
