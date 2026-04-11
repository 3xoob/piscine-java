public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        if (chifoumiAction == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }
        switch (chifoumiAction) {
            case ROCK:
                return ChifoumiAction.SCISSOR;
            case PAPER:
                return ChifoumiAction.ROCK;
            case SCISSOR:
                return ChifoumiAction.PAPER;
            default:
                throw new IllegalArgumentException("Unknown action: " + chifoumiAction);
        }
    }
}
