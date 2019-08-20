package com.pemeyer.swingy.view;

import java.io.*;
import java.io.BufferedReader;
import java.util.Scanner;
import com.pemeyer.swingy.model.hero.HeroFactory;
import com.pemeyer.swingy.controller.Create;
import com.pemeyer.swingy.model.hero.ATT;
import com.pemeyer.swingy.view.*;

public class Console implements View
{
    Scanner input = new Scanner(System.in);
    String command;
    Create controller = new Create();

    public Console() 
    {
        System.out.println("You are playing Swingy!! Enter command to start playing.");
    }

    public String createOrSelect() {
        System.out.println("CREATE - Create hero");
        System.out.println("SELECT - Choose saved hero");

        System.out.println();
        command = input.next();

        return command;
    }

    public Boolean didCreate(String command){
        if (command.equalsIgnoreCase("Create")){
            return true;
        }
        else {
            System.out.println("Wrong command!");
            return false;
        }
    }

    public Boolean isClass(String input) {
        if (input.equalsIgnoreCase("Knight")){
            return true;
        }
        else if (input.equalsIgnoreCase("Ogre")){
            return true;
        }
        else if (input.equalsIgnoreCase("Elf")){
            return true;
        }
        else {
            return false;
        }
    }

    public void heroCreation()
    {
        String name;
        String type;

        System.out.println("Type in your Hero's name");
        name = input.next();

        do {
            System.out.println("\nChoose from these hero's:");
            System.out.println("Choose hero type");
            System.out.println("Knight: Attack:53 - Defense:53 - HP:100");
            System.out.println("Ogre: Attack:45 - Defense:39 - HP:100");
            System.out.println("Elf: Attack:49 - Defense:34 - HP:100\n");
            type = input.next();
        }
        while (!isClass(type));
        
        controller.createHero(type, name, 0, 0, 0, 0, 0);
        System.out.println(controller.showHeroStats());
        System.out.println("\n");
    }

    public String direction(){
        String direction; 
        System.out.println("Which direction?");
        System.out.println("North - South - East - West");
        return direction = input.next();
    }

    public void gotAway(){
        System.out.println("You got away");
    }

    public void gameOver(){
        System.out.println("You just got killed sorry");
        System.out.println("Game over");
    }

    public void won(){
        System.out.println("You have won the game");
    }

    public void errorMessage(Exception e){
        System.out.println(e.getMessage());
    }

    public void damage(int num){
        if (num == 1){
            System.out.println("You damaged your enemy");
        }
        else {
            System.out.println("You've taken damage");
        }
    }
    
    public String fightOrRun(){
        String option;
        System.out.println("You've encountered an enemy");
        System.out.println("You have two options, FIGHT OR RUN!!");
        System.out.println("Pick one:");
        return option = input.next();
    }

    public void playGame(View view){
        controller.StartGame(view);
    }
    public void select(){
        controller.select();
    }
}