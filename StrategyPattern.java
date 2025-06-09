package example;

interface Strategy {
    int doOperation(int a, int b);
}

class AddOperation implements Strategy {
    public int doOperation(int a, int b) {
        return a + b;
    }
}

class SubtractOperation implements Strategy {
    public int doOperation(int a, int b) {
        return a - b;
    }
}

class Context1 {
    private Strategy strategy;
    Context1(Strategy s) { this.strategy = s; }
    int execute(int a, int b) {
        return strategy.doOperation(a, b);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Context1 context = new Context1(new AddOperation());
        System.out.println("10 + 5 = " + context.execute(10, 5));

        context = new Context1(new SubtractOperation());
        System.out.println("10 - 5 = " + context.execute(10, 5));
    }
}
