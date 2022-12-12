package unit;

public class Warrior extends AbstractUnit {
    public final static int STANDARD_HEALTH = 50;
    public final static int STANDARD_ATTACK = 5;

    public Warrior() {
        this(STANDARD_HEALTH, STANDARD_ATTACK);
    }

    public Warrior(int health, int attack) {
        super(health, attack);
    }
}
