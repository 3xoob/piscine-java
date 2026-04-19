public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) {
        character.addHealth(healCapacity);
    }

    @Override
    public void attack(Character target) {
        heal(this);
        target.takeDamage(10);
    }

    @Override
    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
        }
        return name + " is a sorcerer with " + currentHealth + " HP. It can heal " + healCapacity + " HP.";
    }
}
