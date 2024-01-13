package project.Character.Baggage;

public class BaggageItem {
    public String type;
    public int additionalHealth;
    public int additionalAttackPower;
    public int additionalArmor;
    protected static int nextId = 1;
    protected final int id;
    private boolean isSet = false;


    public BaggageItem(String type, int additionalHealth, int additionalAttackPower, int additionalArmor) {
        this.type = type;
        this.additionalHealth = additionalHealth;
        this.additionalAttackPower = additionalAttackPower;
        this.additionalArmor = additionalArmor;
        this.id = nextId++;
        this.isSet = isSet;
    }

    public void putOnItem() {
        isSet = true;
    }

    public String getType() {
        return type;
    }

    public int getAdditionalHealth() {
        return additionalHealth;
    }

    public int getAdditionalAttackPower() {
        return additionalAttackPower;
    }

    public int getAdditionalArmor() {
        return additionalArmor;
    }

    @Override
    public String toString() {
        return "BaggageItem{" +
                "type='" + type + '\'' +
                ", additionalHealth=" + additionalHealth +
                ", additionalAttackPower=" + additionalAttackPower +
                ", additionalArmor=" + additionalArmor +
                '}';
    }
}
