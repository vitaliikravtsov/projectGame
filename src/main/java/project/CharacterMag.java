package project;

public class CharacterMag extends Character{
    protected int characterType;
    public CharacterMag(int characterType) {
        this.name = "Mag";
        this.health = 70;
        this.attack = 40;
        this.characterType = characterType;
    }
}
