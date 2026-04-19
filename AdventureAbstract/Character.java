import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private static List<Character> allCharacters = new ArrayList<>();

    protected final int maxHealth;
    protected int currentHealth;
    protected final String name;

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        } else if (this.currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        }
    }

    public String getName() {
        return name;
    }

    protected void addHealth(int amount) {
        setCurrentHealth(getCurrentHealth() + amount);
    }

    public static Character fight(Character first, Character second) {
        while (first.getCurrentHealth() > 0 && second.getCurrentHealth() > 0) {
            first.attack(second);
            if (second.getCurrentHealth() == 0) {
                return first;
            }
            second.attack(first);
        }
        return second.getCurrentHealth() > 0 ? second : first;
    }

    public static String printStatus() {
        StringBuilder builder = new StringBuilder();
        builder.append("------------------------------------------\n");
        if (allCharacters.isEmpty()) {
            builder.append("Nobody's fighting right now !\n");
        } else {
            builder.append("Characters currently fighting :\n");
            for (Character character : allCharacters) {
                builder.append(" - ").append(character).append("\n");
            }
        }
        builder.append("------------------------------------------\n");
        return builder.toString();
    }

    public abstract void takeDamage(int damage);

    public abstract void attack(Character target);

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " : KO";
        }
        return getName() + " : " + getCurrentHealth() + "/" + getMaxHealth();
    }
}
