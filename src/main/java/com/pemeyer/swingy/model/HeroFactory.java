package com.pemeyer.swingy.model;

import com.pemeyer.swingy.model.ATT;
import com.pemeyer.swingy.model.Elf;

public class HeroFactory {
    public static ATT newHero(String type){
        if (type.equalsIgnoreCase("ELF")){
            return new Elf();
        }
        else if (type.equalsIgnoreCase("Knight")){
            return new Knight();
        }
        else if (type.equalsIgnoreCase("Ogre")){
            return new Ogre();
        }
        return null;
    }
}
