package project.Character;

public class CharacterArcher extends Character{
    public String charName;
    public CharacterArcher(CharacterType characterType) {
        super(characterType);
        this.charName = "Archer";
        this.health = 100;
        this.attackPower = 30;
        this.armor = 3;
    }
}
