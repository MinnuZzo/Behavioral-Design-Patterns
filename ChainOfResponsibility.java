package example;

abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(String request);
}

class ConcreteHandler1 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("low")) {
            System.out.println("Handled by Handler 1");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

class ConcreteHandler2 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("high")) {
            System.out.println("Handled by Handler 2");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.setNext(h2);

        h1.handleRequest("high");
    }
}
