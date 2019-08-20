package com.pemeyer.swingy.controller;

import com.pemeyer.swingy.model.hero.ATT;
import com.pemeyer.swingy.model.hero.Hero;
import com.pemeyer.swingy.model.hero.HeroFactory;
import com.pemeyer.swingy.view.Console;
import com.pemeyer.swingy.view.View;

import java.io.BufferedReader;
import java.io.FileReader;

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


    // public 
    public void select(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/pemeyer/swingy/persistence/savedHeros.txt"));
            String st;
                
            while ((st = br.readLine()) != null){
                createHero(st.split(" ")[0], st.split(" ")[1],
                Integer.parseInt(st.split(" ")[2]), Integer.parseInt(st.split(" ")[3]),
                Integer.parseInt(st.split(" ")[4]),Integer.parseInt(st.split(" ")[5]),
                Integer.parseInt(st.split(" ")[6]));
            }
        } 
        catch (Exception e){
            e.getMessage();
        }
    }

    public void StartGame(View console){
        //sets coordinates to zero. Creates map based on level
        map = (int) Math.floor(game.GenerateMap(hero));
        game.start(map, hero, console);
    }
}