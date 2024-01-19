package project;
import netscape.javascript.JSObject;
import project.Character.Character;
import project.Character.CharacterManager;
import project.Enemy.Enemy;
import project.Enemy.EnemyManager;

import java.sql.SQLOutput;
import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.json.JSONObject;


public class GameManager {
    public static boolean isGameEnded = false;
    public static Logger logger = Logger.getLoggerInstance();
    public static int userID = 1;

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);

//        Define location
        Location location = new Location(4,4,"World");
        logger.log("Location is " + location.getLocationName() + "." + " Max x is " + location.getMaxCoordinateX() + " , max Y is " + location.getMaxCoordinateY());

//        Define type of character
        CharacterManager characterManager = new CharacterManager();
        final CharacterManager.CharacterType characterType = characterManager.chooseCharacterType();
        logger.log("Ok, you play for " + characterType);

//        Create character
        Character character = characterManager.createChar(characterType);
        character.getInfo();

//        Create enemies
        EnemyManager enemyManager = new EnemyManager();
        enemyManager.createEnemy();

        while (!isGameEnded) {
//        Define an action
            logger.log("What would you like to do?");
            logger.log("1 - explore the " + location.getLocationName());
            logger.log("2 - Check baggage");
            logger.log("3 - Check my properties");
            logger.log("4 - Exit");
            int action = scanner.nextInt();
            switch (action) {
                case 1 -> {
                    logger.log("Выберите направлени движения 1 - прямо, 2 - влево, 3 - вправо, 4 - назад");
                    int direction = scanner.nextInt();

//                  Check available coordinates
                    if(direction == 1 && character.getCoordinateY() == location.getMaxCoordinateY()) {
                        logger.log("Нельзя вперед");
                    } else if (direction == 2 && character.getCoordinateX() == -location.getMaxCoordinateX()) {
                        logger.log("Нельзя влево");
                    } else if (direction == 3 && character.getCoordinateX() == location.getMaxCoordinateX()) {
                        logger.log("Нельзя вправо");
                    } else if (direction == 4 && character.getCoordinateY() == -location.getMaxCoordinateY()) {
                        logger.log("Нельзя назад");
                    } else {
                        character.move(direction);
                    }
                    logger.log("Your location now is " + character.getCoordinateX() + " " + character.getCoordinateY());
                    if (location.checkIfMeetEnemies(character.getCoordinateX(), character.getCoordinateY(), enemyManager.getEnemies())) {
                        Enemy findedEnemy = enemyManager.findEnemyByCoordinates(character.getCoordinateX(), character.getCoordinateY());
                        logger.log("Are you going to fight?");
                        logger.log("1 - yes");
                        logger.log("2 - no");
                        int isFight = scanner.nextInt();
                        switch (isFight) {
                            case 1 -> {
                                while (findedEnemy.getHealth() > 0) {
                                    character.fight(character, findedEnemy);
                                }
                                if (character.getHealth() <= 0) {
                                    logger.log("You`v been killed. It`s over");
                                    characterManager.remove(character);
                                    isGameEnded = true;
                                } else if (findedEnemy.getHealth() <= 0) {
                                    logger.log("Good, you killed the enemy, move on");
                                    enemyManager.remove(findedEnemy);
                                    enemyManager.dropLoot(character);
                                }
                            }
                            case 2 -> {
                                logger.log("трус и слабак");
                            }
                        }
                    }
                    else {
                        logger.log("It`s clear, move on");
                    }
                }
                case 2 -> character.exploreBaggageStore();
                case 3 -> character.getInfo();
                case 4 -> isGameEnded = true;
            }
        }
        logger.log("Bye.");
    }
}
