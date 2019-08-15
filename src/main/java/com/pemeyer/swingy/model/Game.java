package com.pemeyer.swingy.model;

import java.util.Scanner;

import com.pemeyer.swingy.model.hero.ATT;

public class Game {
    Scanner input = new Scanner(System.in);
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

    public void movePosition(int mapsize){
        String direction;
        //Doesn't allow other options yeahhhhhhhh
        while (y < (mapsize / 2)){
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
            System.out.println(y);
            System.out.println(mapsize / 2);
        } 
        if (y == mapsize / 2){
            System.out.println("You have won the game");
        }
    }
}