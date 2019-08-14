package com.pemeyer.swingy.controller;

import com.pemeyer.swingy.model.ATT;
import com.pemeyer.swingy.model.HeroFactory;

public class Create
{
    HeroFactory heroFactory = new HeroFactory(); 
    ATT hero;

    public Create(){ 
    }

    public void createHero(String type, String name){
        hero = heroFactory.newHero(type, name);
    }

    public String showHeroStats(){
        return hero.showStats();
    }
}