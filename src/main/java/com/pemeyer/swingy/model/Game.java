package com.pemeyer.swingy.model;

import java.lang.Math;
import java.util.*; 
import java.util.Random;
import java.util.Scanner;

import java.io.*;

import com.pemeyer.swingy.model.enemy.Enemy;
import com.pemeyer.swingy.model.hero.ATT;
import com.pemeyer.swingy.view.View;

public class Game {
    Scanner input = new Scanner(System.in);
    Enemy enemy;
    Enemy enemies[] = new Enemy[10];
    int coordinates[] = new int[2];
    int Mapsize;
    int x;
    int y;

    public Game(){
    }

    public int GenerateMap(ATT hero){
        x = coordinates[0] = 0;
        y = coordinates[1] = 0; 
        Mapsize = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        return Mapsize;
        //if position == 39 / 2 or -(39 / 2)
    }

    public Boolean edgeReached(int x, int y, int mapsize){
        if (y < mapsize / 2 && x < mapsize / 2 && x > (mapsize / 2 ) * -1 && y > (mapsize /2) * -1){
            return true;
        }else {
            return false;
        }
    }
    public Enemy createEnemies(int mapsize){
        enemy = new Enemy((mapsize / 2), (mapsize / 2) * -1);
        return enemy;
    }
    public void setXPandLevel(ATT hero){
        hero.setExperience((int)Math.floor(hero.getLevel()*1000+(Math.pow(hero.getLevel() - 1, 2))*450));
        hero.setLevel(hero.getLevel() + 1);
    }

    public void save(ATT hero, View view){
        try  {
            String text = hero.getName() + " " 
            + hero.getclass() +  " " 
            + hero.getLevel() +  " "
            + hero.getExperience() +  " "
            + hero.getAttack() +  " "
            + hero.getDefense() +  " "
            + hero.getHit();
            File newTextFile = new File("src/main/java/com/pemeyer/swingy/persistence/savedHeros.txt");
            FileWriter fr = new FileWriter(newTextFile);
            fr.write(text);
            fr.close();
        }catch (Exception e){
            view.errorMessage(e);
        }        
    }
    public void start(int mapsize, ATT hero, View view){
        String direction;
        String option;
        int i;
        //spread enemies accross board CreateEnemies
        for (i = 0; i < 10; i++){
            enemies[i] = createEnemies(mapsize);
        }
    
        //turn into function
        while (edgeReached(x, y, mapsize)) {
            direction = view.direction();
            switch (direction.toUpperCase()){
                case "NORTH":
                y++;
                break;
                case "SOUTH":
                y--;
                break;
                case "EAST":
                x++;
                break;
                case "WEST": 
                x--;
                break;
            }
            for (i = 0; i < enemies.length; i++){
                if (y == enemies[i].enemyCoords()[0] && x == enemies[i].enemyCoords()[1]){
                    option = view.fightOrRun();
                    if (option.equalsIgnoreCase("fight")){
                        fight(hero, enemies[i], view);
                    }else if (option.equalsIgnoreCase("run")){
                        run(direction, hero, view);
                    }
                }
            }
        } 
        if (!edgeReached(x, y, mapsize)){
            view.won();
            setXPandLevel(hero);
            save(hero, view);
        }
    }

    public void fight(ATT hero, Enemy enemy, View view) {
        int heroHP = hero.getHit();
        int enemyHP = enemy.getHit();

        while (enemyHP > 0 && heroHP > 0)
        {
            int heroTotal = (int) (Math.random() * ((hero.getAttack() - hero.getDefense()) + 1)) + hero.getDefense();
            int villainTotal = (int)(Math.random() * ((hero.getAttack() - hero.getDefense()) + 1)) + hero.getDefense();
            if (heroTotal > villainTotal){
                enemyHP -= hero.getAttack();
                view.damage(1);
            }else if (heroTotal < villainTotal){
                heroHP -= enemy.getAttack();
                view.damage(0);
            }
        }
        if (enemyHP < 1){
            view.won();
            setXPandLevel(hero);
            save(hero, view);
            System.exit(0);
        }
        else if (heroHP < 1){
            view.gameOver();
            save(hero, view);
            System.exit(0);
        }
        
    }

    public void run(String direction, ATT hero, View view) {
        Random r = new Random();
        int coinToss = r.nextInt(2);
        if (coinToss == 1){
            switch (direction.toUpperCase()){
                case "NORTH":
                y--;
                break;
                case "SOUTH":
                y++;
                break;
                case "EAST":
                x--;
                break;
                case "WEST": 
                x++;
                break;
            }
            view.gotAway();
        }else {
            view.gameOver();
            save(hero, view);
            System.exit(0);
        }
    }

}