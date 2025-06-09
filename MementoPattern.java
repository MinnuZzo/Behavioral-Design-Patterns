package example;

class Memento {
    private String state;
    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}

class Originator {
    private String state;

    public void setState(String state) { this.state = state; }
    public String getState() { return state; }
    public Memento saveState() { return new Memento(state); }
    public void restoreState(Memento m) { this.state = m.getState(); }
}

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("State1");

        Memento m1 = originator.saveState();
        originator.setState("State2");

        originator.restoreState(m1);
        System.out.println("Restored to: " + originator.getState());
    }
}
