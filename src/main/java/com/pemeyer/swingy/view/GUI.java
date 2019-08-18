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

public class GUI 
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, createButtonPanel, mainTextPanel, choiceButtonPanel, ShowAttPanel;
    JLabel titleNameLabel;
    JTextArea mainTextArea;
    JTextField textField;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font textFieldFont = new Font("Times New Roman", Font.PLAIN, 14);
    JButton createButton, createHero, chooseSavedHero;
    DefaultListModel DLM;
    JList list;
    Create controller = new Create();

    String type;
    TitleScreenHandler tsHandler = new TitleScreenHandler();

   
    public GUI(){
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

    public void heroSelection() {
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

        con.add(mainTextPanel);
        con.add(choiceButtonPanel);
    }

    public void GamePlayView(){
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);

        ShowAttPanel = new JPanel();
        ShowAttPanel.setBounds(100, 100, 600, 250);
        ShowAttPanel.setBackground(Color.black);

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
    }
    
    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String command = event.getActionCommand();
            if (command.equals( "CREATE GAME" )){
                heroSelection();
            } else if (command.equals("CREATE NEW HERO")){
                type = list.getSelectedValue().toString();
                String type1 = type.substring(0, type.indexOf(':'));
                controller.createHero(type1, textField.getText());
                GamePlayView();
            }
        }
    }
}