package com.pemeyer.swingy.model.hero;

import com.pemeyer.swingy.model.hero.ATT;
import com.pemeyer.swingy.model.hero.Elf;

public class HeroFactory {
    public static ATT newHero(String type, String name, int exp, int level, int att, int def, int hp){
        if (type.equalsIgnoreCase("ELF")){
            return new Elf(name, "Elf", 1, 0, 49, 34, 100);
        }
        else if (type.equalsIgnoreCase("Knight")){
            return new Knight(name, "Knight", 1, 0, 53, 53, 100);
        }
        else if (type.equalsIgnoreCase("Ogre")){
            return new Ogre(name, "Ogre", 1, 0, 45, 39, 100);
        }
        else if (type.equalsIgnoreCase(type)){
            return new Select(name, type, exp, level, att, def, hp);
        }
        return null;
    }
}
