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

    public String getName(){
        return this.name;
    }

    public String getclass(){
        return this.Class;
    }
    public int getLevel(){
        return this.level;
    }

    public int getExperience(){
        return this.exp;
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

    public String showStats()
    {
        return "Name - " + this.getName() + "\n" +
        "Class - " + this.getclass() + "\n" +
        "Level - " + this.getLevel() + "\n" + 
        "Experience - " + this.getExperience() + "\n" +
        "Attack - " + this.getAttack() + "\n" +
        "Defense - " + this.getDefense() + "\n" +
        "Hit Points - " + this.getHit();
    }
}