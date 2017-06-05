package com.company;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by akupp_000 on 6/4/2017.
 */
public class Handler
{
    private LinkedList<GameObject> objects = new LinkedList<>();
    private GameObject tempObject;
    public Handler(){

    }
    public LinkedList<GameObject> getObjects() {
        return objects;
    }
    public void addObject(GameObject object){
        objects.add(object);
    }
    public void removeObject(GameObject object){
        objects.remove(object);
    }
    public void tick(){
        for(int i = 0; i < objects.size();i++){
            tempObject = objects.get(i);
            tempObject.tick(objects);
        }
    }
    public void render(Graphics g){
        for(int i = 0; i < objects.size();i++){
            tempObject = objects.get(i);
            tempObject.render(g);
        }
    }
}
