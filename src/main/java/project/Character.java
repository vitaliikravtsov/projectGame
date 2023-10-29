package project;

import java.util.Scanner;

public class Character extends Creature{
    Scanner scanner = new Scanner(System.in);

    int charLevel;
    int charExperience;

    public Character() {

        this.charLevel = 0;
        this.charExperience = 0;
    }

    public Character createChar (int characterType) {
        Character character = null;
        switch (characterType) {
            case 1:
                System.out.println(characterType);
                character = new CharacterMag(characterType);
                break;
            case 2:
                System.out.println(characterType);
                character = new CharacterWarrior(characterType);
                break;
            case 3:
                System.out.println(characterType);
                character = new CharacterArcher(characterType);
                break;
        }

        return character;
    }

    public void move(int direction) {
        switch (direction) {
            case 1:
                this.setCoordinateY(this.getCoordinateY()+1);
                break;
            case 2:
                this.setCoordinateX(this.getCoordinateX()-1);
                break;
            case 3:
                this.setCoordinateX(this.getCoordinateX()+1);
                break;
            case 4:
                this.setCoordinateY(this.getCoordinateY()-1);
                break;
        }
    }

}
