package project;

import java.util.ArrayList;

public class EnemyManager {
    ArrayList<Enemy> enemies = new ArrayList<>();

    public void createEnemy() {
        enemies.add(new Enemy(1,1));
    }

    public Enemy findEnemyById(int id) {
        for (Enemy enemy : enemies) {
            if (enemy.getId() == id) {
                return enemy;
            }
        }
        return null;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
}
