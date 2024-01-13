package project.Character;

import project.Character.Baggage.BaggageItem;
import project.Character.Baggage.BaggageStore;
import project.Enemy.Enemy;
import project.Logger;

import java.util.Scanner;

public abstract class Character{

    public BaggageStore baggageStore;

    protected CharacterType characterType;
    protected int health;
    protected int attackPower;
    protected int armor;
    protected static int nextId = 1;
    protected final int id;
    public int coordinateX;
    public int coordinateY;

    public Character(CharacterType characterType) {
        this.baggageStore = new BaggageStore();
        this.characterType = characterType;
        this.id = nextId++;
    }

    public void move(int maxX, int maxY) {
            Scanner scanner = new Scanner(System.in);
            Logger.log("Выберите направлени движения 1 - прямо, 2 - влево, 3 - вправо, 4 - назад");
            int direction = scanner.nextInt();

            if(direction == 1 && this.getCoordinateY() == maxY) {
                Logger.log("Нельзя вперед");
            } else if (direction == 2 && this.getCoordinateX() == maxX) {
                Logger.log("Нельзя влево");
            } else if (direction == 3 && this.getCoordinateX() == maxX) {
                Logger.log("Нельзя вправо");
            } else if (direction == 4 && this.getCoordinateY() == maxY) {
                Logger.log("Нельзя назад");
            } else {
                switch (direction) {
                    case 1 -> this.setCoordinateY(this.getCoordinateY()+1); //straight
                    case 2 -> this.setCoordinateX(this.getCoordinateX()-1); // left
                    case 3 -> this.setCoordinateX(this.getCoordinateX()+1); // right
                    case 4 -> this.setCoordinateY(this.getCoordinateY()-1); // back
                }
            }
        }

        public void fight(Character character, Enemy findedEnemy) {
            findedEnemy.setHealth(findedEnemy.getHealth() - character.getAttackPower());
            character.setHealth(character.getHealth() - findedEnemy.getAttackPower() + character.getArmor());
            Logger.log("You attacked. Enemy health " + findedEnemy.getHealth() + ", your health is " + character.getHealth());
        }

        public void addItemToBaggage(int random) {
            BaggageItem baggageItem = null;
            switch (random){
//                case 0, 2, 4 -> {
//                    return;
//                }
                case 0 -> {
                    baggageItem = baggageStore.createBaggageItem("Sword", 0, 10, 0);
                }
                case 1 -> {
                    baggageItem = baggageStore.createBaggageItem("Axe", 0, 10, 0);
                }
                case 2 -> {
                    baggageItem = baggageStore.createBaggageItem("Potion", 50, 0, 0);
                }
                case 3 -> {
                    baggageItem = baggageStore.createBaggageItem("Helmet", 0, 0, 5);
                }
                case 4 -> {
                    baggageItem = baggageStore.createBaggageItem("Chain mail", 0, 0, 10);
                }
            }
            if(baggageItem != null) {
                Scanner scanner = new Scanner(System.in);
                Logger.log("You`v just got a " + baggageItem.type + " which gives to you " );
                if(baggageItem.getAdditionalHealth()>0) {
                    Logger.log("additional "  + baggageItem.getAdditionalHealth() + " health");
                } else if (baggageItem.getAdditionalAttackPower() > 0) {
                    Logger.log("additional "  + baggageItem.getAdditionalAttackPower() + " attack power");
                } else if (baggageItem.getAdditionalArmor() > 0) {
                    Logger.log("additional "  + baggageItem.getAdditionalArmor() + " armor");
                }

                Logger.log("Would you like to put it on? 1 - yes, 2 - no");
                int choice = scanner.nextInt();
                if (choice== 1) {
                    baggageItem.putOnItem();
                    if(baggageItem.getAdditionalHealth()>0) {
                        this.setHealth(this.getHealth()+baggageItem.getAdditionalHealth());
                        Logger.log("Now your health is " + this.getHealth());
                    } else if (baggageItem.getAdditionalAttackPower() > 0) {
                        this.setAttackPower(this.getAttackPower()+baggageItem.getAdditionalAttackPower());
                        Logger.log("Now your attack power is " + this.getAttackPower());
                    } else if (baggageItem.getAdditionalArmor() > 0) {
                        this.setArmor(this.getArmor()+baggageItem.getAdditionalArmor());
                        Logger.log("Now your armor is " + this.getArmor());
                    }
                } else {
                    Logger.log("ok hodi kak bomzh");
                }
            }
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

    public BaggageStore getBaggageStore() {
        return baggageStore;
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
