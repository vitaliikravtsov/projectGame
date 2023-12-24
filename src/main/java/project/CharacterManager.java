package project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterManager {
    public ArrayList<Character> characters = new ArrayList<>();

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
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите направлени движения 1 - прямо, 2 - влево, 3 - вправо, 4 - назад");
            int direction = scanner.nextInt();

            if(direction == 1 && character.getCoordinateY() == 4) {
                System.out.println("Нельзя вперед");
            } else if (direction == 2 && character.getCoordinateX() == -4) {
                System.out.println("Нельзя влево");
            } else if (direction == 3 && character.getCoordinateX() == 4) {
                System.out.println("Нельзя вправо");
            } else if (direction == 4 && character.getCoordinateX() == -4) {
                System.out.println("Нельзя назад");
            } else {
                switch (direction) {
                    case 1 -> character.setCoordinateY(character.getCoordinateY()+1); //straight
                    case 2 -> character.setCoordinateX(character.getCoordinateX()-1); // left
                    case 3 -> character.setCoordinateX(character.getCoordinateX()+1); // right
                    case 4 -> character.setCoordinateY(character.getCoordinateY()-1); // back
                }
            }
            System.out.println("Вы переместились, Ваши координаты: " + character.getCoordinateX() + " " + character.getCoordinateY());
        }

    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

}
