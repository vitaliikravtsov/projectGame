package project.Enemy;

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


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }



    @Override
    public String toString() {
        return "Enemy{" +
                "health=" + health +
                ", attackPower=" + attackPower +
                ", coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }
}