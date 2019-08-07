package com.pemeyer.swingy.model;

public class Hero {
    protected String name;
    protected String Class;
    protected int level;
    protected int exp;
    protected int attack;
    protected int def;
    protected int hit;

    public Hero(String name, String Class, int level, int exp, int attack, int def, int hit){
        this.name = name;
        this.Class = Class;
        this.level = level;
        this.exp = exp;
        this.attack = attack;
        this.def = def;
        this.hit = hit;
    }
}