package project;

import project.Character.Character;
import project.Character.CharacterManager;
import project.Enemy.Enemy;
import project.Enemy.EnemyManager;

import java.util.ArrayList;

public class Location {

    public final int maxCoordinateX;
    public final int maxCoordinateY;
    public final String locationName;

    public Location(int maxCoordinateX, int maxCoordinateY, String locationName) {
        this.maxCoordinateX = maxCoordinateX;
        this.maxCoordinateY = maxCoordinateY;
        this.locationName = locationName;
    }

    public boolean checkIfMeetEnemies(int charX, int charY, int enemyX, int enemyY) {
        return (charX == enemyX) && charY == enemyY;
    }

    public int getMaxCoordinateX() {
        return maxCoordinateX;
    }

    public int getMaxCoordinateY() {
        return maxCoordinateY;
    }

    public String getLocationName() {
        return locationName;
    }

    public boolean checkIfMeetEnemies(int coordinateX, int coordinateY, ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if ((enemy.getCoordinateX() == coordinateX) && enemy.getCoordinateY() == coordinateY) {
                Logger.log("Enemy!!!! aaaaaaaaa");
                return true;
            }
        }
        return false;
    }
}
