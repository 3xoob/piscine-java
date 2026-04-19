import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private static List<Character> allCharacters = new ArrayList<>();

    private final int maxHealth;
    private int currentHealth;
    private final String name;
    protected final Weapon weapon;

    public Character(String name, int maxHealth) {
        this(name, maxHealth, null);
    }

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) {
            this.currentHealth = 0;
            return;
        }
        if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
            return;
        }
        this.currentHealth = currentHealth;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    protected void addHealth(int amount) {
        currentHealth += amount;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    protected int getAttackDamage(int defaultDamage) {
        if (weapon == null) {
            return defaultDamage;
        }
        return weapon.getDamage();
    }

    protected String weaponSuffix() {
        if (weapon == null) {
            return "";
        }
        return " He has the weapon " + weapon + ".";
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
