package project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterManager {
    public ArrayList<Character> characters = new ArrayList<>();

    public Location currentLocation;

    public CharacterManager() {
        this.currentLocation = new Location();
    }

    public void createChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип героя. 1 - Маг, 2 - Воин, 3 - Лучник.");
        int characterType = scanner.nextInt();
        switch (characterType) {
            case 1 -> {
                characters.add(new CharacterMag(Character.CharacterType.MAG));
                System.out.println("Вы играете за " + Character.CharacterType.MAG);
            }
            case 2 -> {
                characters.add(new CharacterWar(Character.CharacterType.WAR));
                System.out.println("Вы играете за " + Character.CharacterType.WAR);
            }
            case 3 -> {
                characters.add(new CharacterArcher(Character.CharacterType.ARCHER));
                System.out.println("Вы играете за " + Character.CharacterType.ARCHER);
            }

        }
    }
    public Character getCharacterById (int id) {
        for (Character character : characters) {
            if(character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    public void move(Character character) {
        currentLocation.moveHero(character);
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

}
