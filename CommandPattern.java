package example;

interface Command {
    void execute();
}

class Light {
    void on() { System.out.println("Light is ON"); }
    void off() { System.out.println("Light is OFF"); }
}

class LightOnCommand implements Command {
    private Light light;
    LightOnCommand(Light light) { this.light = light; }

    public void execute() {
        light.on();
    }
}

class RemoteControl {
    private Command command;
    void setCommand(Command command) { this.command = command; }
    void pressButton() { command.execute(); }
}

public class CommandPattern {
    public static void main(String[] args) {
        Light light = new Light();
        Command onCommand = new LightOnCommand(light);
        RemoteControl control = new RemoteControl();
        control.setCommand(onCommand);
        control.pressButton();
    }
}
