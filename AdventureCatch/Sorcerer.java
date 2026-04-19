public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) throws DeadCharacterException {
        if (currentHealth == 0) {
            throw new DeadCharacterException(this);
        }
        character.addHealth(healCapacity);
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (currentHealth == 0) {
            throw new DeadCharacterException(this);
        }
        heal(this);
        target.takeDamage(getAttackDamage(10));
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (currentHealth == 0) {
            throw new DeadCharacterException(this);
        }
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP." + weaponSuffix();
        }
        return name + " is a sorcerer with " + currentHealth + " HP. It can heal " + healCapacity + " HP." + weaponSuffix();
    }
}
