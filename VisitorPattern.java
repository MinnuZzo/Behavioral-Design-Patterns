package example;

interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}

class Mouse implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Keyboard implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

interface ComputerPartVisitor {
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
}

class DisplayVisitor implements ComputerPartVisitor {
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        ComputerPart mouse = new Mouse();
        ComputerPart keyboard = new Keyboard();

        DisplayVisitor displayVisitor = new DisplayVisitor();

        mouse.accept(displayVisitor);
        keyboard.accept(displayVisitor);
    }
}
