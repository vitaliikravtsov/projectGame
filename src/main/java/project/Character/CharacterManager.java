package project.Character;

import project.Character.Baggage.BaggageStore;
import project.Enemy.Enemy;
import project.Location;
import project.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterManager {
    public ArrayList<Character> characters = new ArrayList<>();


    public void createChar() {
        Scanner scanner = new Scanner(System.in);
        Logger.log("Выберите тип героя. 1 - Маг, 2 - Воин, 3 - Лучник.");
        int characterType = scanner.nextInt();
        Character character = null;
        switch (characterType) {
            case 1 -> {
                character = new CharacterMag(Character.CharacterType.MAG);
            }
            case 2 -> {
                character = new CharacterWar(Character.CharacterType.WAR);
            }
            case 3 -> {
                character = new CharacterArcher(Character.CharacterType.ARCHER);
            }

        }
        characters.add(character);
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

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

}
