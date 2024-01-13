package project;

import project.Character.Baggage.BaggageStore;
import project.Character.Character;
import project.Character.CharacterManager;
import project.Enemy.Enemy;
import project.Enemy.EnemyManager;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class GameManager {
    public static boolean isGameEnded = false;


    public static void startGame() {
//        Define location
        Location location = new Location(4,4,"World");
        Logger.log("Location is " + location.getLocationName() + "." + " Max x is " + location.getMaxCoordinateX() + " , max Y is " + location.getMaxCoordinateY());

//        Define character
        CharacterManager characterManager = new CharacterManager();
        characterManager.createChar();
        Character character = characterManager.getCharacterById(1);
        Logger.log("You play for " + character);

        EnemyManager enemyManager = new EnemyManager();
        enemyManager.createEnemy(0,1);
        enemyManager.createEnemy(0,2);
        enemyManager.createEnemy(0,3);
        enemyManager.createEnemy(0,4);
        enemyManager.createEnemy(1,4);
        enemyManager.createEnemy(2,4);
        enemyManager.createEnemy(3,4);
        enemyManager.createEnemy(4,4);

//        Explore world
        while (!enemyManager.getEnemies().isEmpty() && !isGameEnded) {
            System.out.println("Your location now is " + character.getCoordinateX() + " " + character.getCoordinateY());
            character.move(location.getMaxCoordinateX(), location.getMaxCoordinateY());
            final Enemy findedEnemy = enemyManager.findEnemyByCoordinates(character.getCoordinateX(), character.getCoordinateY());
            if (findedEnemy != null) {
                Scanner scanner = new Scanner(System.in);
                Logger.log("Вы встретили врага. Что делаем? 1 - драться, 2 - сдаться.");
                int action = scanner.nextInt();
                switch (action) {
                    case 1 -> {
                        while (findedEnemy.getHealth() > 0) {
                            character.fight(character, findedEnemy);
                        }
                        if(character.getHealth() <= 0) {
                            Logger.log("You`v been killed. It`s over");
                            characterManager.remove(character);
                            isGameEnded = true;
                        } else if (findedEnemy.getHealth() <= 0) {
                            Logger.log("Good, you killed the enemy, move on");
                            enemyManager.remove(findedEnemy);
                            enemyManager.dropLoot(character);
                        }
                    }
                    case 2 -> {
                        Logger.log("трус и слабак");
                        isGameEnded = true;
                    }
                }
            } else {
                Logger.log("It`s clear, move on");
            }
        }
    }
}
