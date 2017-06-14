package com.company;

import java.awt.*;

/**
 * Created by akupp_000 on 6/13/2017.
 */
public class Menu {
    private Rectangle play = new Rectangle(Game.WIDTH/2 - 40, 200, 120, 50);
    public void render(Graphics g){
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("Welcome to Pong", Game.WIDTH/2 - 170, 100);
        Graphics2D g2D = (Graphics2D)g;
        g.drawString("Play",Game.WIDTH/2 - 30, 240 );
        g2D.draw(play);
    }
}
