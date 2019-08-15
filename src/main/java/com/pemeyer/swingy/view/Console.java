package com.pemeyer.swingy.view;

import java.util.Scanner;
import com.pemeyer.swingy.model.hero.HeroFactory;
import com.pemeyer.swingy.controller.Create;
import com.pemeyer.swingy.model.hero.ATT;

public class Console 
{
    Scanner input = new Scanner(System.in);
    String command;
    Create controller = new Create();

    public Console() 
    {
        //Welcome start screnn
        System.out.println("You are playing Swingy!! Enter command to start playing.");
        System.out.println("CREATE - Create hero");
        System.out.println("SELECT - Choose saved hero");

        System.out.println();
        command = input.next();

        if (command.equalsIgnoreCase("Create")){
            heroSelection();
        }
        
    }
    public void heroSelection()
    {
        String name;
        String type;

        System.out.println("Type in your Hero's name");
        name = input.next();

        System.out.println("Choose from these hero's");
        System.out.println("Choose hero type");
        System.out.println("Knight: Attack:53 - Defense:53 - HP:100");
        System.out.println("Ogre: Attack:45 - Defense:39 - HP:100");
        System.out.println("Elf: Attack:49 - Defense:34 - HP:100");
        type = input.next();

        controller.createHero(type, name);
        System.out.println(controller.showHeroStats());
        play();
    }

    public void play(){
        controller.StartGame();
        System.out.println("North - South - East - West");
        controller.play();
    }
    
}