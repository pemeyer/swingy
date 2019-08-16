package com.pemeyer.swingy.controller;

import com.pemeyer.swingy.model.hero.ATT;
import com.pemeyer.swingy.model.hero.Hero;
import com.pemeyer.swingy.model.hero.HeroFactory;
import com.pemeyer.swingy.model.Game;


public class Create
{
    HeroFactory heroFactory = new HeroFactory(); 
    Game game = new Game();
    ATT hero;
    int map;

    public Create(){ 
    }

    public ATT createHero(String type, String name){
        return hero = heroFactory.newHero(type, name);
    }

    public String showHeroStats(){
        return hero.showStats();
    }

    public void StartGame(){
        //sets coordinates to zero. Creates map based on level
        map = (int) Math.floor(game.GenerateMap(hero));
        System.out.println(map);
    }

    public void play(){
        game.start(map);
    }




}