public class Monster extends Character {
    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        target.takeDamage(getAttackDamage(7));
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        setCurrentHealth(getCurrentHealth() - (damage * 8) / 10);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a monster and is dead." + weaponSuffix();
        }
        return getName() + " is a monster with " + getCurrentHealth() + " HP." + weaponSuffix();
    }
}
