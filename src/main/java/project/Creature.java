package project;

public class Creature {
    protected String name;
    protected int health;
    protected int attack;
    protected int coordinateX;
    protected int coordinateY;

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

    public boolean isAlive() {
        return this.health > 0;
    }

    public void greetingCreature() {
        System.out.println(this.name + " " + this.health + " " + this.attack + "position " + this.coordinateX + " " + this.coordinateY);
    }
}
