import java.util.*;

public class InfixEvaluator {
    public static int evaluate(String expr, Map<String, Integer> env) {
        try {
            List<String> rpn = toRPN(expr);
            return evalRPN(rpn, env);
        } catch (Exception e) {
            System.out.println("ERROR");
            throw new RuntimeException("ERROR");
        }
    }

    private static List<String> toRPN(String expr) {
        List<String> output = new ArrayList<>();
        Stack<String> ops = new Stack<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isWhitespace(c)) continue;
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                if (num.length() > 0) {
                    output.add(num.toString());
                    num.setLength(0);
                }
                if (Character.isLetter(c)) {
                    StringBuilder func = new StringBuilder();
                    while (i < expr.length() && Character.isLetter(expr.charAt(i))) func.append(expr.charAt(i++));
                    i--;
                    ops.push(func.toString());
                } else if (c == ',') {
                    while (!ops.isEmpty() && !ops.peek().equals("(")) output.add(ops.pop());
                } else if (c == '(') {
                    ops.push("(");
                } else if (c == ')') {
                    while (!ops.isEmpty() && !ops.peek().equals("(")) output.add(ops.pop());
                    if (ops.isEmpty()) throw new RuntimeException();
                    ops.pop();
                    if (!ops.isEmpty() && isFunction(ops.peek())) output.add(ops.pop());
                } else {
                    String op = String.valueOf(c);
                    if (c == '-' && (i == 0 || expr.charAt(i - 1) == '(' || isOperator(expr.charAt(i - 1)))) op = "u-";
                    while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(op)) output.add(ops.pop());
                    ops.push(op);
                }
            }
        }
        if (num.length() > 0) output.add(num.toString());
        while (!ops.isEmpty()) {
            if (ops.peek().equals("(") || ops.peek().equals(")")) throw new RuntimeException();
            output.add(ops.pop());
        }
        return output;
    }

    private static int evalRPN(List<String> rpn, Map<String, Integer> env) {
        Stack<Integer> st = new Stack<>();
        for (String t : rpn) {
            if (isNumber(t)) st.push(Integer.parseInt(t));
            else if (isVariable(t)) {
                if (!env.containsKey(t)) throw new RuntimeException();
                st.push(env.get(t));
            } else if (isFunction(t)) {
                if (t.equals("abs")) {
                    int a = st.pop();
                    st.push(Math.abs(a));
                } else if (t.equals("min") || t.equals("max")) {
                    int b = st.pop(), a = st.pop();
                    st.push(t.equals("min") ? Math.min(a, b) : Math.max(a, b));
                }
            } else {
                if (t.equals("u-")) st.push(-st.pop());
                else {
                    int b = st.pop(), a = st.pop();
                    switch (t) {
                        case "+": st.push(a + b); break;
                        case "-": st.push(a - b); break;
                        case "*": st.push(a * b); break;
                        case "/": if (b == 0) throw new RuntimeException(); st.push(a / b); break;
                        case "%": if (b == 0) throw new RuntimeException(); st.push(a % b); break;
                        case "^": st.push((int)Math.pow(a, b)); break;
                        default: throw new RuntimeException();
                    }
                }
            }
        }
        if (st.size() != 1) throw new RuntimeException();
        return st.pop();
    }

    private static boolean isNumber(String s) { return s.matches("-?\\d+"); }
    private static boolean isVariable(String s) { return s.matches("[a-zA-Z]+") && !isFunction(s); }
    private static boolean isFunction(String s) { return s.equals("min") || s.equals("max") || s.equals("abs"); }
    private static boolean isOperator(char c) { return "+-*/%^".indexOf(c) != -1; }
    private static int precedence(String op) {
        switch (op) {
            case "u-": return 4;
            case "^": return 3;
            case "*": case "/": case "%": return 2;
            case "+": case "-": return 1;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> env = new HashMap<>();
        env.put("x", -2);
        env.put("y", -7);
        System.out.println(evaluate("-(x) + abs(y)", env));
    }
}
