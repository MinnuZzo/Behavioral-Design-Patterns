package example;

abstract class Game {
    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play() {
        initialize();
        start();
        end();
    }
}

class Cricket extends Game {
    void initialize() { System.out.println("Cricket Game Initialized."); }
    void start() { System.out.println("Cricket Game Started."); }
    void end() { System.out.println("Cricket Game Ended."); }
}

class Football extends Game {
    void initialize() { System.out.println("Football Game Initialized."); }
    void start() { System.out.println("Football Game Started."); }
    void end() { System.out.println("Football Game Ended."); }
}

public class TemplateMethodPattern {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        System.out.println();

        game = new Football();
        game.play();
    }
}
