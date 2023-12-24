package project;

public class Location {

    public CharacterManager characterManager;
    public EnemyManager enemyManager;

    public Location(CharacterManager characterManager, EnemyManager enemyManager) {
        this.characterManager = characterManager;
        this.enemyManager = enemyManager;
    }

    public boolean isThereEnemy(Character characterById) {
        for (Enemy enemy : enemyManager.getEnemies()) {
            if(enemy.getCoordinateX() == characterById.getCoordinateX() && enemy.getCoordinateY() == characterById.getCoordinateY()) {
                return true;
            }
        }

        System.out.println(enemyManager.getEnemies());

        System.out.println(characterManager.getCharacterById(1).getCoordinateX());
        return false;
    }

}
