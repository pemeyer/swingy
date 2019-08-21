package com.pemeyer.swingy.view;

import com.pemeyer.swingy.model.hero.ATT;

public interface View {
    String createOrSelect();
    Boolean didCreate(String command);
    Boolean isClass(String input);
    ATT heroCreation();
    void playGame(View console, ATT hero);
    String direction();
    String fightOrRun();
    void gotAway();
    void gameOver();
    void won();
    void errorMessage(Exception e);
    void damage(int num);
    ATT select();
    void grabView(View view);
}