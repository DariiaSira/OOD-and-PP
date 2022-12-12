package ability;

public interface CanRestoreHealth extends CanReceiveDamage {
    void restoreHealth(int health);
}
