package decorator;

import ability.CanReceiveDamage;
import ability.CanRestoreHealth;
import ability.HasVampirism;
import unit.Unit;

public class WithVampirism extends UnitDecorator implements HasVampirism {
    private final int regenPercent;

    public WithVampirism(Unit warrior, int regenPercent) {
        super(warrior);
        if (regenPercent < 0) {
            throw new IllegalArgumentException();
        }
        this.regenPercent = regenPercent;
    }

    @Override
    public int getVampirism() {
        return regenPercent;
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int before = opponent.getHealth();
        super.hit(opponent);
        int after = opponent.getHealth();

        vampire(before - after);
    }

    @Override
    public void restoreHealth(int health) {
        Unit kernel = getKernel();
        if (kernel instanceof CanRestoreHealth) {
            CanRestoreHealth simpleWarrior = (CanRestoreHealth) kernel;
            simpleWarrior.restoreHealth(health);
        }
    }
}