package com.company;

import com.gameobjects.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = -6261436164361361187L;
    private boolean running = false;
    Handler handler;
    private Menu menu = new Menu();
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public ScoreLabel label1 = new ScoreLabel(44, 100);
    public ScoreLabel label2 = new ScoreLabel(600,100);
    public enum STATE{
      MENU, GAME
    };
    private static STATE state = STATE.MENU;
    public synchronized void start() {
        if (running)
            return;
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage level;
        BufferedImage menu = loader.loadImage("/pongmainmenu.png");
        handler = new Handler();
        level = loader.loadImage("/ponglevel.png");
        loadImageLevel(level);

        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput());
    }
    @Override
    public void run() {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
    public void tick(){
        if(state == STATE.GAME)
            handler.tick();
    }
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2D = (Graphics2D) g;
        /////////////////////////////////
        //Draw Everything in here
        g.fillRect(0, 0, getWidth(), getHeight());//This NEEDS to be here. DON'T TAKE IT OUT OR THE PLAYER WON'T MOVE
        /////////////////////////////////
        if (state == STATE.GAME){
            handler.render(g);

            label1.render(g);
            label2.render(g);
            //g.drawString("hi",44,45);
            //also render scores
        }
        else if(state == STATE.MENU){
            menu.render(g);
        }


        g.dispose();
        bs.show();
    }
    private void loadImageLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        int xx;
        int yy;
        System.out.println("width, height" + w + "," + h);
        for (xx = 0; xx < h; xx++) {
            for (yy = 0; yy < w; yy++) {

                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (red == 0 && green == 38 && blue == 255) {
                    handler.addObject(new PlayerOne(xx * 32,yy*32,ObjectId.PlayerOne,handler));
                }
                if(red == 255 && green == 255 && blue == 255){
                    handler.addObject(new PlayerOnePlatform(xx *32, yy*32, ObjectId.PlayerOnePlatform,handler));
                }
                if(red == 0 && green == 0 && blue == 0){
                    handler.addObject(new PlayerTwoPlatform(xx *32, yy*32, ObjectId.PlayerTwoPlatform,handler));
                }
                if (red == 255 && green == 0 && blue == 0) {
                    handler.addObject(new PlayerTwo(xx *32, yy*32, ObjectId.PlayerTwo,handler));
                }
                if (red == 255 && green == 97 && blue == 12) {
                    handler.addObject(new Ball(xx *32, yy*32, ObjectId.Ball,handler, this));
                }
                if (red == 182 && green == 255 && blue == 0){
                    handler.addObject(new Platform(xx *32, yy*32, ObjectId.Platform,handler));
                }
//                if(red == 76 && green == 255 && blue == 0){
//                    handler.addObject(new ScoreLabel(xx*32,yy*32,ObjectId.ScoreLabel,handler));
//                }

            }
        }
    }


    public static void setState(STATE s) {
        state = s;
    }

    public static STATE getState(){
        return state;

    }

    public static void main(String[] args) {
        new Window(800, 600, "Pong", new Game());

    }

}
