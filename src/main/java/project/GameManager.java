package project;

public class GameManager {


    public static void startGame() {
        CharacterManager characterManager = new CharacterManager();
        EnemyManager enemyManager = new EnemyManager();
        Location location = new Location(characterManager, enemyManager);
        characterManager.createChar();
        Character char1 = characterManager.getCharacterById(1);
        enemyManager.createEnemy(1, 0);
        enemyManager.createEnemy(1, 1);
        characterManager.move(char1);

        if(location.isThereEnemy(char1)) {
            System.out.println("You bumped into thee enemy");
        }
    }
}
