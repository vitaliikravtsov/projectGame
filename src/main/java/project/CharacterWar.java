package project;

public class CharacterWar extends Character{
    public String charName;
    public CharacterWar(CharacterType characterType) {
        super(characterType);
        this.charName = "War";
        this.health = 120;
        this.attackPower = 20;
        this.armor = 5;
    }

    @Override
    public void superPower() {

    }
}
