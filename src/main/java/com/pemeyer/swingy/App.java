package com.pemeyer.swingy;

import com.pemeyer.swingy.model.ATT;
import com.pemeyer.swingy.model.Hero;
import com.pemeyer.swingy.model.HeroFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HeroFactory heroFactory = new HeroFactory();

        ATT hero = heroFactory.newHero("Elf");
        hero.someFunc();
    }
}
