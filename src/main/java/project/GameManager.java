package project;

public class GameManager {


    public static void startGame() {
        CharacterManager characterManager = new CharacterManager();
        characterManager.createChar();
        Character char1 = characterManager.getCharacterById(1);
        System.out.println(char1);
        characterManager.move(char1);
        characterManager.move(char1);
        characterManager.move(char1);
        characterManager.move(char1);
        characterManager.move(char1);
        characterManager.move(char1);




    }
}
