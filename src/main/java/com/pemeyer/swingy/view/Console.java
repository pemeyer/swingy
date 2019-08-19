package com.pemeyer.swingy.view;

import java.io.*;
import java.io.BufferedReader;
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
        // }else if(command.equalsIgnoreCase("Select")){
        //     try {
        //         BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/pemeyer/swingy/persistence/savedHeros.txt"));
        //         String st;
            
        //         while ((st = br.readLine()) != null){
        //             controller.createHero(st.split(" ")[0], st.split(" ")[1],
        //             Integer.parseInt(st.split(" ")[2]), Integer.parseInt(st.split(" ")[3]),
        //             Integer.parseInt(st.split(" ")[4]),Integer.parseInt(st.split(" ")[5]),
        //             Integer.parseInt(st.split(" ")[6]));
        //         }
        //     } 
        //     catch (Exception e){
        //         e.getMessage();
        //     }
        // }
        // play();
    }

    public void heroSelection()
    {
        String name;
        String type;

        System.out.println("Type in your Hero's name");
        name = input.next();

        System.out.println("\nChoose from these hero's:");
        System.out.println("Choose hero type");
        System.out.println("Knight: Attack:53 - Defense:53 - HP:100");
        System.out.println("Ogre: Attack:45 - Defense:39 - HP:100");
        System.out.println("Elf: Attack:49 - Defense:34 - HP:100\n");
        type = input.next();

        controller.createHero(type, name, 0, 0, 0, 0, 0);
        System.out.println(controller.showHeroStats());
        System.out.println("\n");
        playGame();
    }

    public void playGame(){
        controller.StartGame();
    }
    
}