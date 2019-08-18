package com.pemeyer.swingy.model.hero;

public interface ATT {
    String getName();
    String getclass();
    int getLevel();
    int getExperience();
    int getAttack();
    int getDefense();
    int getHit();
    void setLevel(int level);
    void setExperience(int exp);
    void setAttack(int attack);
    void setDefense(int defense);
    void setHit(int hit);
    String showStats();
}
