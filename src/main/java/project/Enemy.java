package project;

public class Enemy extends Creature{
    String[] enemyName = {"Альп", "Брукса", "Гаркаин", "Фледер", "Голем", "Ифрит", "Черепоглав", "Пиявка", "Риггер", "Кикимора", "Химера"};

    public void createEnemy(int coordinateX, int coordinateY) {
        this.health = 10;
        this.attack = 5;
        int counter = -1;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                counter++;
                if(x == 0 && y == 0) {
                    continue;
                } else {
                    if (coordinateX == x && coordinateY == y) {
                        System.out.println("x: " + x + " y " + y);
                        this.name = enemyName[counter];
                    }
                }
            }
        }
        System.out.println("Вы встретили врага " + this.name + ". его здоровье " + this.health + ". Атака " + this.attack);
    }

}
