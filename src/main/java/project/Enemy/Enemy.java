package project.Enemy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Enemy {
    protected int health;
    protected final int attackPower;
    protected int coordinateX;
    protected int coordinateY;
    protected static int nextId = 1;
    protected final int id;

    public Enemy(int coordinateX, int coordinateY) {
        this.health = 50;
        this.attackPower = 10;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.id = nextId++;

    }
}