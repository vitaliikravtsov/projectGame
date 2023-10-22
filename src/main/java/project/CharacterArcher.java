package project;

public class CharacterArcher extends Character{
    protected int characterType;
    public CharacterArcher(int characterType) {
        this.name = "Archer";
        this.health = 80;
        this.attack = 30;
        this.characterType = characterType;
    }
}
