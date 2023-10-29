package project;

public class Enemy extends Creature{
    String[] enemyName = {"Альп", "Брукса", "Гаркаин", "Фледер", "Голем", "Ифрит", "Черепоглав", "Пиявка", "Риггер", "Кикимора", "Химера"};

    private int minCoordinateX = -1;
    private int maxCoordinateX = 1;
    private int minCoordinateY = -1;
    private int maxCoordinateY = 1;

    int mobCount = 0;

    boolean anyEnemyAlive = false;

    EnemyMob[] mobList = new EnemyMob[8];

    public EnemyMob[] createMobList() {
        for (int x = minCoordinateX; x <= maxCoordinateX ; x++) {
            for (int y = minCoordinateY; y <= maxCoordinateY; y++) {
                if(x==0 && y==0) {
                    continue;
                }
                mobList[mobCount] = new EnemyMob(enemyName[mobCount], x, y);
                mobList[mobCount].setHealth(50);
                mobList[mobCount].setAttack(20);
                mobCount++;
            }
        }
        return mobList;
    }

    public boolean getAliveEnemy() {
        for (EnemyMob enemy: mobList) {
            if(enemy.getIsAlive()) {
                System.out.println(enemy.getCoordinateX() + " " + enemy.getCoordinateY());
                anyEnemyAlive = true;
            } else {
                anyEnemyAlive = false;
            }
        }
        return anyEnemyAlive;
    }
}
