public class DoOp {
    public static String operate(String[] args) {
        if (args == null || args.length != 3) {
            return "Error";
        }
        int left;
        int right;
        try {
            left = Integer.parseInt(args[0]);
            right = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            return "Error";
        }
        String op = args[1];
        if (op == null || op.length() != 1) {
            return "Error";
        }
        char sign = op.charAt(0);
        switch (sign) {
            case '+':
                return Integer.toString(left + right);
            case '-':
                return Integer.toString(left - right);
            case '*':
                return Integer.toString(left * right);
            case '/':
                if (right == 0) {
                    return "Error";
                }
                return Integer.toString(left / right);
            case '%':
                if (right == 0) {
                    return "Error";
                }
                return Integer.toString(left % right);
            default:
                return "Error";
        }
    }
}
