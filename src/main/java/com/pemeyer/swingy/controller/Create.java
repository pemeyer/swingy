package com.pemeyer.swingy.controller;

import com.pemeyer.swingy.model.ATT;
import com.pemeyer.swingy.model.HeroFactory;

public class Create
{
    public Create(){ 
    }

    public void createHero(String type, String name){
        HeroFactory heroFactory = new HeroFactory(); 

        ATT hero = heroFactory.newHero(type.substring(0, type.indexOf(':')), name);
        hero.someFunc();
    }
}