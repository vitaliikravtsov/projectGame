package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Location {
//    public ArrayList<Character> characters;
//    public ArrayList<Enemy> enemies;
//
//    public Location(ArrayList<Character> characters) {
//        this.characters = characters;
//    }


//    public Location(ArrayList<Character> characters, ArrayList<Enemy> enemies) {
//        this.characters = characters;
//        this.enemies = enemies;
//    }

    public void moveHero(Character character) {
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
