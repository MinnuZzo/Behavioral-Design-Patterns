package example;

interface Mediator {
    void send(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;
    Colleague(Mediator m) { this.mediator = m; }
}

class ConcreteColleague1 extends Colleague {
    ConcreteColleague1(Mediator m) { super(m); }

    void send(String msg) {
        mediator.send(msg, this);
    }

    void receive(String msg) {
        System.out.println("Colleague1 received: " + msg);
    }
}

class ConcreteColleague2 extends Colleague {
    ConcreteColleague2(Mediator m) { super(m); }

    void send(String msg) {
        mediator.send(msg, this);
    }

    void receive(String msg) {
        System.out.println("Colleague2 received: " + msg);
    }
}

class ConcreteMediator implements Mediator {
    private ConcreteColleague1 c1;
    private ConcreteColleague2 c2;

    public void setColleagues(ConcreteColleague1 c1, ConcreteColleague2 c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public void send(String message, Colleague sender) {
        if (sender == c1) c2.receive(message);
        else c1.receive(message);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague1 c1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 c2 = new ConcreteColleague2(mediator);

        mediator.setColleagues(c1, c2);

        c1.send("Hi from C1");
        c2.send("Hello from C2");
    }
}
