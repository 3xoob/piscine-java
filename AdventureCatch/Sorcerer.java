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
        target.takeDamage(getAttackDamage(10));
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        setCurrentHealth(getCurrentHealth() - damage);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP." + weaponSuffix();
        }
        return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP."
                + weaponSuffix();
    }
}
