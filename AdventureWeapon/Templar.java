public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public void heal(Character character) {
        character.addHealth(healCapacity);
    }

    @Override
    public void attack(Character target) {
        heal(this);
        target.takeDamage(getAttackDamage(6));
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = damage - shield;
        if (reducedDamage < 0) {
            reducedDamage = 0;
        }
        currentHealth -= reducedDamage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " has been beaten, even with its " + shield + " shield. So bad, it could heal "
                    + healCapacity + " HP." + weaponSuffix();
        }
        return name + " is a strong Templar with " + currentHealth + " HP. It can heal " + healCapacity
                + " HP and has a shield of " + shield + "." + weaponSuffix();
    }
}
