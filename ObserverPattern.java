package example;

import java.util.*;

interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    void addObserver(Observer o) { observers.add(o); }

    void notifyObservers(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}

class ConcreteObserver implements Observer {
    private String name;
    ConcreteObserver(String name) { this.name = name; }

    public void update(String message) {
        System.out.println(name + " got message: " + message);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new ConcreteObserver("Observer1"));
        subject.addObserver(new ConcreteObserver("Observer2"));

        subject.notifyObservers("Event happened!");
    }
}
