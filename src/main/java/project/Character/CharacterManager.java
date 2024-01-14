package project.Character;

import lombok.Data;
import project.Logger;

import java.util.ArrayList;
import java.util.Scanner;
@Data
public class CharacterManager {
    public ArrayList<Character> characters = new ArrayList<>();
    public Logger logger = Logger.getLoggerInstance();
    public CharacterType characterType;

    public enum CharacterType {
        MAGE, WAR, ARCHER
    }

    public CharacterType chooseCharacterType() {
        Scanner scanner = new Scanner(System.in);
        logger.log("Выберите тип героя:");
        logger.log("1 - Маг;");
        logger.log("2 - Воин;");
        logger.log("3 - Лучник;");
        int choice = scanner.nextInt();
        characterType = null;
        switch (choice) {
            case 1 -> {
                characterType = CharacterType.MAGE;
            }
            case 2 -> {
                characterType = CharacterType.WAR;
            }
            case 3 -> {
                characterType = CharacterType.ARCHER;
            }
        }
        return characterType;
    }
    public Character createChar(CharacterType characterType) {
        Character character = null;
        switch (characterType) {
            case MAGE -> {
                character = new CharacterMag();
            }
            case WAR -> {
                character = new CharacterWar();
            }
            case ARCHER -> {
                character = new CharacterArcher();
            }
        }
        characters.add(character);
        return character;
    }

    public void remove(Character character) {
        characters.remove(character);
    }

    public Character getCharacterById (int id) {
        for (Character character : characters) {
            if(character.getId() == id) {
                return character;
            }
        }
        return null;
    }
}
