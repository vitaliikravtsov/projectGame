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

    public void move() {
        System.out.println("Выерите направление движения: 1 - вперед, 2 - влево, 3 - вправо, 4 - назад");
        int direction = scanner.nextInt();
//        if((direction == 1 && this.getCoordinateY() == 2) || (direction == 2 && this.getCoordinateY() == 2) || (this.getCoordinateX() == 2 && this.getCoordinateY() == 2)){
//            System.out.println("Выберите другое направление");
//            direction = scanner.nextInt();
//        }
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
