package com.pemeyer.swingy.model.enemy;

import java.lang.Math;

public class Enemy {
    protected String name;
    protected int attack;
    protected int def;
    protected int hit;
    protected int[] coords = new int[2];

    public Enemy(int max, int min){
        this.name = "Bad guy";
        this.attack = (int) (Math.random() * ((120 - 70) + 1)) + 70; 
        this.def = (int) (Math.random() * ((120 - 70) + 1)) + 70;
        this.hit = (int) (Math.random() * ((120 - 80) + 1)) + 80;
        this.coords[0] = (int) (Math.random() * ((max - min) + 1)) + min;
        this.coords[1] = (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public String getName(){
        return this.name;
    }
    
    public int getAttack(){
        return this.attack;
    }

    public int getDefense(){
        return this.def;
    }

    public int getHit(){
        return this.hit;
    }

    public int[] enemyCoords() {
        return this.coords;
    }
}