package project.Character;

import project.Character.Baggage.BaggageStore;
import project.Location;

public class CharacterMag extends Character{
    public String charName;
    public CharacterMag(CharacterType characterType) {

        super(characterType);
        this.charName = "Mag";
        this.health = 70;
        this.attackPower = 20;
        this.armor = 2;
    }

}
