public class DeadCharacterException extends Exception {
    private final Character character;

    public DeadCharacterException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        String type;
        if (character instanceof Sorcerer) {
            type = "sorcerer";
        } else if (character instanceof Templar) {
            type = "templar";
        } else {
            type = "monster";
        }
        return "The " + type + " " + character.getName() + " is dead.";
    }
}
