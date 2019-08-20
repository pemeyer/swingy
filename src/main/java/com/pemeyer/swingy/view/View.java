package com.pemeyer.swingy.view;

public interface View {
    String createOrSelect();
    Boolean didCreate(String command);
    Boolean isClass(String input);
    void heroCreation();
    void playGame(View console);
    String direction();
    String fightOrRun();
    void gotAway();
    void gameOver();
    void won();
    void errorMessage(Exception e);
    void damage(int num);
	void select();
}