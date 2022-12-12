package ability;

import ability.CanAttack;

public interface CanReceiveDamage {
    int getHealth();
    int getMaxHealth();
    default boolean isAlive() {
        return getHealth() > 0;
    }
    void receiveDamage(CanAttack from, int damage);
}
