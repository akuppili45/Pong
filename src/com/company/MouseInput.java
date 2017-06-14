package com.company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by akupp_000 on 6/13/2017.
 */
public class MouseInput implements MouseListener
{

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //private Rectangle play = new Rectangle(Game.WIDTH/2 - 40, 200, 120, 50);
        int mx = e.getX();
        int my = e.getY();
        if(mx >= Game.WIDTH/2 - 40 && mx <= Game.WIDTH/2 + 80){
            if(my <= 200 + 120 && my >= 200)
                Game.setState(Game.STATE.GAME);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
