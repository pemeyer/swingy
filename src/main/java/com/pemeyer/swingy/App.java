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

import com.pemeyer.swingy.model.ATT;
import com.pemeyer.swingy.model.HeroFactory;
import com.pemeyer.swingy.view.GUI;
import com.pemeyer.swingy.view.Console;


public class App
{
    static GUI newGUI;
    static Console newConsole;
    //Console newConsole;
    public static void main( String[] args )
    {   
        if (args[0].equalsIgnoreCase("GUI"))
        {
            newGUI = new GUI();
        }
        else if (args[0].equalsIgnoreCase("Console"))
        {
            newConsole = new Console();
        }
    }

}
