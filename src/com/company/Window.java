package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by akupp_000 on 6/4/2017.
 */
public class Window
{
    JFrame frame;
    public Window(int w, int h, String title, Game game){
        game.setPreferredSize(new Dimension(w, h));
        game.setMaximumSize(new Dimension(w,h));
        game.setMinimumSize(new Dimension(w,h));
        frame = new JFrame(title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }
    public Window(int w, int h, String title){
        frame = new JFrame(title);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(w,h);
    }
}
