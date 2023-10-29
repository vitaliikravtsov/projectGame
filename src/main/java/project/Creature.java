package project;

public class Creature {
    protected String name;
    protected int health;
    protected int attack;
    protected int coordinateX;
    protected int coordinateY;
    protected boolean isAlive = true;

    public Creature() {
        this.name = "";
        this.health = 0;
        this.attack = 0;
        this.coordinateX = 0;
        this.coordinateY = 0;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean getIsAlive() {
        return this.getHealth() > 0;
    }

//    public void setIsAlive(boolean alive) {
//        this.isAlive = alive;
//    }

    public void greetingCreature() {
        System.out.println(this.name + " " + this.health + " " + this.attack + "position " + this.coordinateX + " " + this.coordinateY);
    }
}
