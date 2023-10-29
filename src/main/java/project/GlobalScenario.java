package project;

import java.util.Objects;
import java.util.Scanner;

public class GlobalScenario {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);


//  Выбор персонажа
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

        Character characterObject = new Character();
        Character createdCharacter = characterObject.createChar(characterChoice);
        System.out.println("Хорошо, вы будете играть за " + createdCharacter.name + "." + "Ваше здоровье: " + createdCharacter.health + ". Атака: " + createdCharacter.attack);

//  Создать врагов
        Enemy enemy = new Enemy();
        EnemyMob[] enemyArray = enemy.createMobList();



//  Выбрать направление движения
        while (enemy.getAliveEnemy()) { /* проверяем есть ли живой моб */
            if(createdCharacter.getHealth() <= 0) { /*проверяем живой ли персонаж*/
                System.out.println("Вас убили, Вы проиграли.");
                return;
            }
            chooseDirection(createdCharacter, enemyArray);
            System.out.println("alive enemy " + enemy.getAliveEnemy());

        }

        if(!enemy.getAliveEnemy()) { /*win*/
            System.out.println("Врагов больше нет. Игра пройдена.");
        }
    }

    public void chooseDirection(Character createdCharacter, EnemyMob[] enemyArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выерите направление движения: 1 - вперед, 2 - влево, 3 - вправо, 4 - назад");
        int direction = scanner.nextInt();
        while ( (direction == 1 && createdCharacter.getCoordinateY() == 1)  ||
                (direction == 2 && createdCharacter.getCoordinateX() == -1) ||
                (direction == 3 && createdCharacter.getCoordinateX() == 1)  ||
                (direction == 4 && createdCharacter.getCoordinateY() == -1)
            ) {
            System.out.println("Выберите другое направление");
            direction = scanner.nextInt();
        }
        createdCharacter.move(direction);
        findEnemy(createdCharacter, enemyArray);
    }

    public void findEnemy(Character createdCharacter, EnemyMob[] enemyArray) {
        Scanner scanner = new Scanner(System.in);
        for (EnemyMob enemyMob : enemyArray) {
            if(createdCharacter.getCoordinateX() == enemyMob.coordinateX && createdCharacter.getCoordinateY() == enemyMob.coordinateY) {
                if (enemyMob.getIsAlive()) {
                    System.out.println("Вы встретили врага! " + enemyMob.name + ". Его здоровье " + enemyMob.getHealth() + ". Показатель атаки " + enemyMob.getAttack() + ".");
                    while (enemyMob.getIsAlive()) {
                        System.out.println("Атакуем? 1 - да, 2 - нет.");
                        int isFight = scanner.nextInt();
                        if (isFight == 1) {
                            attack(enemyMob, createdCharacter);
                        } else {
                            System.out.println("Фу, трус.");
                            chooseDirection(createdCharacter, enemyArray);
                        }
                    }
                }
            }
        }
    }
    public void attack(EnemyMob enemyMob, Character createdCharacter) {
        enemyMob.setHealth(enemyMob.getHealth() - createdCharacter.getAttack());
        if(enemyMob.getIsAlive()) {
            createdCharacter.setHealth(createdCharacter.getHealth() - enemyMob.getAttack());
            System.out.println("Вы атакованы. Ваше здоровье: " + createdCharacter.getHealth());
        } else {
            System.out.println("Враг сражен! " + enemyMob.getIsAlive());
        }
    }
}
