package project.Enemy;

import lombok.Data;
import lombok.Getter;
import project.Character.Character;
import project.GameManager;

import java.util.ArrayList;
import java.util.Random;

@Data
public class EnemyManager {
    final ArrayList<Enemy> enemies = new ArrayList<>();

    public void createEnemy() {
        enemies.add(new Enemy(0,1));
        enemies.add(new Enemy(0,2));
        enemies.add(new Enemy(0,3));
        enemies.add(new Enemy(0,4));
        enemies.add(new Enemy(1,0));
        enemies.add(new Enemy(2,0));
    }

    public Enemy findEnemyByCoordinates(int x, int y) {
        for (Enemy enemy : enemies) {
            if (enemy.getCoordinateX() == x && enemy.getCoordinateY() == y) {
                return enemy;
            }
        }
        return null;
    }

    public void isAnyEnemyAlive() {
        GameManager.isGameEnded = !enemies.isEmpty();
    }

    public void remove(Enemy findedEnemy) {
        enemies.remove(findedEnemy);
    }

    public void dropLoot(Character character) {
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        character.addItemToBaggage(randomNumber);
    }
}
