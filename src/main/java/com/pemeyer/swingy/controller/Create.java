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

    public ATT createHero(String type, String name, int level, int exp, int att, int def, int hp ){
        return hero = heroFactory.newHero(type, name, level, exp, att, def, hp);
    }

    public String showHeroStats(){
        return hero.showStats();
    }

    public void StartGame(){
        //sets coordinates to zero. Creates map based on level
        map = (int) Math.floor(game.GenerateMap(hero));
        game.start(map, hero);
    }
}