package project;

public class CharacterMag extends Character{
    public String charName;
    public CharacterMag(CharacterType characterType) {

        super(characterType);
        this.charName = "Mag";
        this.health = 70;
        this.attackPower = 20;
        this.armor = 2;
    }

    @Override
    public void superPower() {

    }

}
