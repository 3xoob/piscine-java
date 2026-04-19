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

    public String getName() {
        return name;
    }

    protected void addHealth(int amount) {
        currentHealth += amount;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    public static Character fight(Character first, Character second) {
        while (first.currentHealth > 0 && second.currentHealth > 0) {
            first.attack(second);
            if (second.currentHealth == 0) {
                return first;
            }
            second.attack(first);
        }
        return second.currentHealth > 0 ? second : first;
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
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }
}
