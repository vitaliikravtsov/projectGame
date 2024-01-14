package project.Character;

import lombok.Data;
import lombok.extern.java.Log;
import project.Character.Baggage.BaggageItem;
import project.Character.Baggage.BaggageStore;
import project.Enemy.Enemy;
import project.Logger;

import java.util.Scanner;
import org.json.JSONObject;

//@Getter
//@Setter
//@ToString(includeFieldNames = true)
@Log
@Data
public abstract class Character {
    public BaggageStore baggageStore;
    protected int health;
    protected int attackPower;
    protected int armor;
    protected static int nextId = 1;
    protected final int id;
    public int coordinateX;
    public int coordinateY;
    public Logger logger;

    public Character() {
        this.baggageStore = new BaggageStore();
        this.id = nextId++;
        logger = Logger.getLoggerInstance();
    }


    public void move(int maxX, int maxY) {
            Scanner scanner = new Scanner(System.in);
            logger.log("Выберите направлени движения 1 - прямо, 2 - влево, 3 - вправо, 4 - назад");
            int direction = scanner.nextInt();

            if(direction == 1 && this.getCoordinateY() == maxY) {
                logger.log("Нельзя вперед");
            } else if (direction == 2 && this.getCoordinateX() == -maxX) {
                logger.log("Нельзя влево");
            } else if (direction == 3 && this.getCoordinateX() == maxX) {
                logger.log("Нельзя вправо");
            } else if (direction == 4 && this.getCoordinateY() == -maxY) {
                logger.log("Нельзя назад");
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
            logger.log("You attacked. Enemy health " + findedEnemy.getHealth() + ", your health is " + character.getHealth());
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
                logger.log("You`v just got a " + baggageItem.type + " which gives to you " );
                if(baggageItem.getAdditionalHealth()>0) {
                    logger.log("additional "  + baggageItem.getAdditionalHealth() + " health");
                } else if (baggageItem.getAdditionalAttackPower() > 0) {
                    logger.log("additional "  + baggageItem.getAdditionalAttackPower() + " attack power");
                } else if (baggageItem.getAdditionalArmor() > 0) {
                    logger.log("additional "  + baggageItem.getAdditionalArmor() + " armor");
                }

                logger.log("Would you like to put it on? 1 - yes, 2 - no");
                int choice = scanner.nextInt();
                if (choice== 1) {
                    baggageItem.putOnItem();
                    if(baggageItem.getAdditionalHealth()>0) {
                        this.setHealth(this.getHealth()+baggageItem.getAdditionalHealth());
                        logger.log("Now your health is " + this.getHealth());
                    } else if (baggageItem.getAdditionalAttackPower() > 0) {
                        this.setAttackPower(this.getAttackPower()+baggageItem.getAdditionalAttackPower());
                        logger.log("Now your attack power is " + this.getAttackPower());
                    } else if (baggageItem.getAdditionalArmor() > 0) {
                        this.setArmor(this.getArmor()+baggageItem.getAdditionalArmor());
                        logger.log("Now your armor is " + this.getArmor());
                    }
                } else {
                    logger.log("ok hodi kak bomzh");
                }
            }
        }
        public void exploreBaggageStore() {
            if(!baggageStore.getBaggageStore().isEmpty()) {
                logger.log(baggageStore.toString());
            }else {
                logger.log("Baggabee is empty yet");
            };
        }

        public void getInfo() {
            logger.log("Here is your data:");
            logger.log("Health is " + this.getHealth());
            logger.log("Armor is " + this.getArmor());
            logger.log("Attack Power is " + this.getAttackPower());
        }

}
