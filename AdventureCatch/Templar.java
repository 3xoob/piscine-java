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
    public void heal(Character character) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        character.addHealth(healCapacity);
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        heal(this);
        target.takeDamage(getAttackDamage(6));
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        int reducedDamage = damage - shield;
        if (reducedDamage < 0) {
            reducedDamage = 0;
        }
        setCurrentHealth(getCurrentHealth() - reducedDamage);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " has been beaten, even with its " + shield + " shield. So bad, it could heal "
                    + healCapacity + " HP." + weaponSuffix();
        }
        return getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity
                + " HP and has a shield of " + shield + "." + weaponSuffix();
    }
}
