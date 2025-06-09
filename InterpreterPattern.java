package example;

interface Expression {
    boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;
    TerminalExpression(String data) { this.data = data; }

    public boolean interpret(String context) {
        return context.contains(data);
    }
}

class OrExpression implements Expression {
    private Expression expr1, expr2;

    OrExpression(Expression e1, Expression e2) {
        this.expr1 = e1;
        this.expr2 = e2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

public class InterpreterPattern {
    public static void main(String[] args) {
        Expression person1 = new TerminalExpression("Alice");
        Expression person2 = new TerminalExpression("Bob");
        Expression isKnown = new OrExpression(person1, person2);

        System.out.println(isKnown.interpret("Alice")); // true
        System.out.println(isKnown.interpret("Charlie")); // false
    }
}
