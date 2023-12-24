package project;

import java.util.Scanner;

public abstract class Character extends CharacterManager{
    protected CharacterType characterType;
    protected int health;
    protected int attackPower;
    protected int armor;
    protected static int nextId = 1;
    protected final int id;
    public int coordinateX;
    public int coordinateY;

    public Character(CharacterType characterType) {
        this.characterType = characterType;
        this.id = nextId++;
    }

    public abstract void superPower();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getId() {
        return id;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public enum CharacterType {
        MAG, WAR, ARCHER;
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
        return "Character{" +
                "characterType=" + characterType +
                ", health=" + health +
                ", attackPower=" + attackPower +
                ", id=" + id +
                '}';
    }
}
