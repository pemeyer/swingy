package com.pemeyer.swingy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.pemeyer.swingy.model.ATT;
import com.pemeyer.swingy.model.HeroFactory;


public class App 
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, createButtonPanel, mainTextPanel, choiceButtonPanel;
    JLabel titleNameLabel;
    JTextArea mainTextArea;
    JTextField textField;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font textFieldFont = new Font("Times New Roman", Font.PLAIN, 14);
    JButton createButton, createHero, chooseSavedHero;

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main( String[] args )
    {
        new App();
    }

    public App(){
        window = new JFrame();
        window.setSize(800, 600);
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
    public void createCreateScreen() {
        titleNamePanel.setVisible(false);
        createButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        
        mainTextArea = new JTextArea("CREATE YOUR HERO HERE:");
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
        textField.setBounds(100, 200, 100, 150);
        textField.setBackground(Color.black);
        textField.setForeground(Color.white);
        textField.setFont(normalFont);

        choiceButtonPanel.add(createHero);
        choiceButtonPanel.add(chooseSavedHero);

        createButton.setActionCommand( "CREATE GAME" );
        createHero.setActionCommand( "CREATE NEW HERO" );

        con.add(mainTextPanel);
        con.add(choiceButtonPanel);
        con.add(textField);

    }

    public void createHero(String name){
        HeroFactory heroFactory = new HeroFactory();

        ATT hero = heroFactory.newHero("Knight", name);
        hero.someFunc();
    }
    
    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String command = event.getActionCommand();
            if (command.equals( "CREATE GAME" )){
                createCreateScreen();
            } else if (command.equals("CREATE NEW HERO")){
                createHero(textField.getText());
            }
        }
    }
}
