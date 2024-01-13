package project.Enemy;

import project.Character.Character;

import java.util.ArrayList;
import java.util.Random;

public class EnemyManager {
    ArrayList<Enemy> enemies = new ArrayList<>();

    public void createEnemy(int x, int y) {
        enemies.add(new Enemy(x,y));
    }

    public Enemy findEnemyById(int id) {
        for (Enemy enemy : enemies) {
            if (enemy.getId() == id) {
                return enemy;
            }
        }
        return null;
    }

    public Enemy findEnemyByCoordinates(int x, int y) {
        for (Enemy enemy : enemies) {
            if (enemy.getCoordinateX() == x && enemy.getCoordinateY() == y) {
                return enemy;
            }
        }
        return null;
    }

    public void remove(Enemy findedEnemy) {
        enemies.remove(findedEnemy);
    }

    public void dropLoot(Character character) {
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        character.addItemToBaggage(randomNumber);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
}
