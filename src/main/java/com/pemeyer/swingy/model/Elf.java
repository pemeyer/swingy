package com.pemeyer.swingy.model;

public class Elf extends Hero implements ATT {
    public Elf(String name, String Class, int level, int exp, int attack, int def, int hit) {
        super(name, Class, level, exp, attack, def, hit);
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
    public void someFunc(){
        System.out.println(this.Class + " Created:");
        System.out.println("Attack: " + this.getAttack() + " Defense: " + this.getDefense());
        System.out.println("Say Hello to: " + this.name);
    }
}
