package com.pemeyer.swingy.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import com.pemeyer.swingy.view.View;

public class GUI implements View
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, createButtonPanel, mainTextPanel, choiceButtonPanel, ShowAttPanel, textFieldPanel;
    JLabel titleNameLabel;
    JTextArea mainTextArea;
    JTextField textField;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font textFieldFont = new Font("Times New Roman", Font.PLAIN, 14);
    JButton createButton, createHero, chooseSavedHero, north, south, east, west;
    DefaultListModel DLM;
    JList list;
    Create controller = new Create();
    View view;

    String type;
    TitleScreenHandler tsHandler = new TitleScreenHandler();

   
    public GUI(View view){
        view = view;
        window = new JFrame();
        window.setSize(1000, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("SWINGY");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        createButtonPanel = new JPanel();
        createButtonPanel.setBounds(300, 400, 500, 180);
        createButtonPanel.setBackground(Color.black);

        createButton = new JButton("CREATE GAME");
        createButton.setBackground(Color.black);
        createButton.setForeground(Color.white );
        createButton.setFont(normalFont);
        createButton.addActionListener(tsHandler);
        createButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        createButtonPanel.add(createButton);

        con.add(titleNamePanel);
        con.add(createButtonPanel);

        window.setVisible(true);
    }

    public void heroCreation() {
        titleNamePanel.setVisible(false);
        createButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        
        mainTextArea = new JTextArea("CHOOSE HERO TYPE AND NAME YOUR HERO");
        mainTextArea.setBounds(100, 60, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(100, 350, 120, 100);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(2,1));
        
        createHero = new JButton("CREATE NEW HERO");
        createHero.setBackground(Color.black);
        createHero.setForeground(Color.white);
        createHero.setFont(normalFont);
        createHero.addActionListener(tsHandler);
        createHero.setFocusPainted(false);

        chooseSavedHero = new JButton("CHOOSE SAVED HERO");
        chooseSavedHero.setBackground(Color.black);
        chooseSavedHero.setForeground(Color.white);
        chooseSavedHero.setFont(normalFont);
        chooseSavedHero.addActionListener(tsHandler);
        chooseSavedHero.setFocusPainted(false);

        textField = new JTextField(20);
        textField.setBounds(100, 100, 100, 100);
        textField.setBackground(Color.white);
        textField.setForeground(Color.black);
        textField.setFont(normalFont);
        mainTextPanel.add(textField);

        list = new JList();
        list.setBounds(187,200, 179,120);
        list.setBackground(Color.white);
        list.setForeground(Color.black);
        list.setFont(textFieldFont);

        DLM = new DefaultListModel();
        DLM.addElement("Knight: Attack:53 - Defense:53 - HP:100");
        DLM.addElement("Ogre: Attack:45 - Defense:39 - HP:100");
        DLM.addElement("Elf: Attack:49 - Defense:34 - HP:100");
        list.setModel(DLM);
        mainTextPanel.add(list);

        choiceButtonPanel.add(createHero);
        choiceButtonPanel.add(chooseSavedHero);

        createButton.setActionCommand( "CREATE GAME" );
        createHero.setActionCommand( "CREATE NEW HERO" );
        chooseSavedHero.setActionCommand("CHOOSE");

        con.add(mainTextPanel);
        con.add(choiceButtonPanel);
    }

    public void GamePlayView(){
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);

        ShowAttPanel = new JPanel();
        ShowAttPanel.setBounds(50, 100, 900, 400);
        ShowAttPanel.setBackground(Color.blue);


        list = new JList();
        list.setBounds(187,200, 179,120);
        list.setBackground(Color.white);
        list.setForeground(Color.black);
        list.setFont(textFieldFont);

        DLM = new DefaultListModel();
        DLM.addElement(controller.showHeroStats());
        list.setModel(DLM);
        ShowAttPanel.add(list);
        con.add(ShowAttPanel);

        mainTextArea = new JTextArea("Choose a direction");
        mainTextArea.setBounds(100, 60, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        ShowAttPanel.add(mainTextArea);


        north = new JButton("NORTH");
        north.setBackground(Color.black);
        north.setForeground(Color.white);
        north.setFont(normalFont);
        north.addActionListener(tsHandler);
        north.setFocusPainted(false);
        ShowAttPanel.add(north);

        south = new JButton("SOUTH");
        south.setBackground(Color.black);
        south.setForeground(Color.white);
        south.setFont(normalFont);
        south.addActionListener(tsHandler);
        south.setFocusPainted(false);
        ShowAttPanel.add(south);
        
        east = new JButton("EAST");
        east.setBackground(Color.black);
        east.setForeground(Color.white);
        east.setFont(normalFont);
        east.addActionListener(tsHandler);
        east.setFocusPainted(false);
        ShowAttPanel.add(east);

        west = new JButton("WEST");
        west.setBackground(Color.black);
        west.setForeground(Color.white);
        west.setFont(normalFont);
        west.addActionListener(tsHandler);
        west.setFocusPainted(false);
        ShowAttPanel.add(west);

        north.setActionCommand("NORTH");
        south.setActionCommand("SOUTH");
        east.setActionCommand("EAST");
        east.setActionCommand("WEST");
        
    }

    @Deprecated
    public String createOrSelect() {
        // System.out.println("CREATE - Create hero");
        // System.out.println("SELECT - Choose saved hero");

        // System.out.println();
        // command = input.next();

        return "command";
    }

    @Deprecated
    public Boolean didCreate(String command){
        // if (command.equalsIgnoreCase("Create")){
        //     return true;
        // }
        // else {
        //     System.out.println("Wrong command!");
            return false;
        // }
    }

    @Deprecated
    public Boolean isClass(String input) {
        // if (input.equalsIgnoreCase("Knight")){
        //     return true;
        // }
        // else if (input.equalsIgnoreCase("Ogre")){
        //     return true;
        // }
        // else if (input.equalsIgnoreCase("Elf")){
        //     return true;
        // }
        // else {
            return false;
        // }
    }

    public String direction(){
        mainTextArea.append("Which direction?\nNorth - South - East - West");
        return "North"; //= input.next();
    }

    public void gotAway(){
        mainTextArea.append("You got away");
    }

    public void gameOver(){
        mainTextArea.append("You just got killed sorry\n Game Over");
    }

    public void won(){
        mainTextArea.append("You have won the game");
    }

    public void errorMessage(Exception e){
        mainTextArea.append(e.getMessage());
    }

    public void damage(int num){
        if (num == 1){
            mainTextArea.append("You damaged your enemy");
        }
        else {
            mainTextArea.append("You've taken damage");
        }
    }
    
    public String fightOrRun(){
        String option;
        mainTextArea.append("You've encountered an enemy\nYou have two options, FIGHT OR RUN!!\nPick one:");
        return "option"; //input.next();
    }

    public void playGame(View view){
        controller.StartGame(view);
    }

    public void select(){
    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String command = event.getActionCommand();
            if (command.equals( "CREATE GAME" )){
                heroCreation();
            } else if (command.equals("CREATE NEW HERO")){
                type = list.getSelectedValue().toString();
                String type1 = type.substring(0, type.indexOf(':'));
                controller.createHero(type1, textField.getText(), 0, 0, 0, 0, 0);
                GamePlayView();
                //playGame(view);
            }else if (command.equals("CHOOSE")){
                controller.select();
                GamePlayView();
                //playGame(view);
            }
        }
    }
}