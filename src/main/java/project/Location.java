package project;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import project.Character.Character;
import project.Character.CharacterManager;
import project.Enemy.Enemy;
import project.Enemy.EnemyManager;

import java.util.ArrayList;
@Getter
@Setter
public class Location {

    public final int maxCoordinateX;
    public final int maxCoordinateY;
    public final String locationName;
    public Logger logger = Logger.getLoggerInstance();

    public Location(int maxCoordinateX, int maxCoordinateY, String locationName) {
        this.maxCoordinateX = maxCoordinateX;
        this.maxCoordinateY = maxCoordinateY;
        this.locationName = locationName;
    }

    public boolean checkIfMeetEnemies(int charX, int charY, int enemyX, int enemyY) {
        return (charX == enemyX) && charY == enemyY;
    }

    public boolean checkIfMeetEnemies(int coordinateX, int coordinateY, ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if ((enemy.getCoordinateX() == coordinateX) && enemy.getCoordinateY() == coordinateY) {
                logger.log("Enemy!!!! aaaaaaaaa");
                return true;
            }
        }
        return false;
    }
}
