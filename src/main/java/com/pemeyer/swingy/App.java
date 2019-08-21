package com.pemeyer.swingy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.pemeyer.swingy.controller.Create;
import com.pemeyer.swingy.model.hero.ATT;
import com.pemeyer.swingy.model.hero.HeroFactory;
import com.pemeyer.swingy.view.GUI;
import com.pemeyer.swingy.view.Console;
import com.pemeyer.swingy.view.View;


public class App
{
    static GUI newGUI;
    static Console newConsole;
    static View view;
    static ATT hero;
    //Console newConsole;
    public static void main( String[] args )
    {   
        if (args[0].equalsIgnoreCase("GUI"))
        {
            view = new GUI(view);
            view.grabView(view);
        }
        else if (args[0].equalsIgnoreCase("Console"))
        {
            view = new Console();
            String command = view.createOrSelect();
            if (!command.equalsIgnoreCase("Select")){
                while (!view.didCreate(command)) {
                    command = view.createOrSelect();
                }
                hero = view.heroCreation();
            }else {
                System.out.println("You chose Select");
                hero = view.select();
            }
            view.playGame(view, hero);
        }
    }

}
