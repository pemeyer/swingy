package com.pemeyer.swingy.model;

import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

import com.pemeyer.swingy.model.enemy.Enemy;
import com.pemeyer.swingy.model.hero.ATT;

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

    public void start(int mapsize, ATT hero){
        String direction;
        String option;
        int i;
        //spread enemies accross board CreateEnemies
        for (i = 0; i < 10; i++){
            enemies[i] = createEnemies(mapsize);
        }
    
        while (edgeReached(x, y, mapsize)) {
            direction = input.next();
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
            // System.out.println(y + " " + x);
            // System.out.println(enemyCoords[0] + " " + enemyCoords[1]);
            for (i = 0; i < enemies.length; i++){
                if (y == enemies[i].enemyCoords()[0] && x == enemies[i].enemyCoords()[1]){
                    //turn into view
                    System.out.println("You've encountered an enemy");
                    System.out.println("You have two options, FIGHT OR RUN!!");
                    System.out.println("Pick one:");
                    option = input.next();

                    if (option.equalsIgnoreCase("fight")){
                        fight(hero, enemies[i]);
                    }else if (option.equalsIgnoreCase("run")){
                        run(direction);
                    }

                }
            }
           
        } 
        if (!edgeReached(x, y, mapsize)){
            System.out.println("You have won the game");
        }
    }

    public Enemy createEnemies(int mapsize){
        enemy = new Enemy((mapsize / 2), (mapsize / 2) * -1);
        return enemy;
    }
    public void fight(ATT hero, Enemy enemy) {
        int heroHP = hero.getHit();
        int enemyHP = enemy.getHit();

        while (enemyHP > 0 && heroHP > 0)
        {
            int heroTotal = (int) (Math.random() * ((hero.getAttack() - hero.getDefense()) + 1)) + hero.getDefense();
            int villainTotal = (int)(Math.random() * ((hero.getAttack() - hero.getDefense()) + 1)) + hero.getDefense();
            if (heroTotal > villainTotal){
                enemyHP -= hero.getAttack();
                System.out.println("You damaged your enemy - ENEMY hitpoints: " + enemyHP);
            }else if (heroTotal < villainTotal){
                heroHP -= enemy.getAttack();
                System.out.println("You've taken damage'- Hitpoints: " + heroHP);
            }
        }
        if (enemyHP < 1){
            System.out.println("You've won");
            //set experience and level function();
            //and save();
            //turn switch statements into function
            System.exit(0);
        }
        else if (heroHP < 1){
            System.out.println("You just got killed sorry");
            System.out.println("Game over");
            System.exit(0);
        }
        
    }

    public void run(String direction) {
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
            //turn into view
            System.out.println("You got away");
        }else {
            //turn into view GameOVER
            System.out.println("You just got killed sorry");
            System.out.println("Game over");
            System.exit(0);
        }
    }
}