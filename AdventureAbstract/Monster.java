public class Monster extends Character {
    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(7);
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - ((damage * 8) / 10));
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a monster and is dead";
        }
        return getName() + " is a monster with " + getCurrentHealth() + " HP";
    }
}
