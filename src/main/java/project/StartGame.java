package project;

import java.util.Objects;
import java.util.Scanner;

public class StartGame {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите персонажа за которого будете играть : \"маг - 1\", \"воин - 2\", \"лучник - 3\", \"выход - 0\"");
        int characterChoice = scanner.nextInt();

        while(!Objects.equals(characterChoice, 1) && !Objects.equals(characterChoice, 2) && !Objects.equals(characterChoice, 3)) {
            if(Objects.equals(characterChoice, 0)) {
                System.out.println("exit");
                return;
            }
            System.out.println("Персонажа " + characterChoice + " не существует. Выберите одного из: \"маг\", \"воин\", \"лучник\"");
            characterChoice = scanner.nextInt();
        }
        System.out.println("Хорошо, вы будете играть за " + characterChoice);

        Character characterObject = new Character();
        Character createdCharacter = characterObject.createChar(characterChoice);
        System.out.println("Хорошо, вы будете играть за " + createdCharacter.name + "." + "Ваше здоровье: " + createdCharacter.health + ". Атака: " + createdCharacter.attack);

        Enemy mob = new Enemy();
        createdCharacter.move();

        mob.createEnemy(createdCharacter.getCoordinateX(), createdCharacter.getCoordinateY());


//        Enemy mob = new Enemy();
//        mob.createEnemy(createdCharacter.getCoordinateX(), createdCharacter.getCoordinateY());
//
//        System.out.println("Что будем делать? 1 - драться, 2 - сдаться, 3 - убежать");
//        String action = scanner.nextLine();


    }
}
