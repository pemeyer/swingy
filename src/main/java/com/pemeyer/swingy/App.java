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

import com.pemeyer.swingy.model.ATT;
import com.pemeyer.swingy.model.Hero;
import com.pemeyer.swingy.model.HeroFactory;


public class App 
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, createButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton createButton;

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main( String[] args )
    {
        /*HeroFactory heroFactory = new HeroFactory();

        ATT hero = heroFactory.newHero("Elf");
        hero.someFunc();*/
        new App();
    }

    public App(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
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
        createButton.setForeground(Color.white);
        createButton.setFont(normalFont);
        //createButton.addActionListener(tsHandler);
        createButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        createButtonPanel.add(createButton);

        con.add(titleNamePanel);
        con.add(createButtonPanel);

    }
    public void createCreateScreen() {
        titleNamePanel.setVisible(false);
        createButtonPanel.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            createCreateScreen();
        }
    }
}
