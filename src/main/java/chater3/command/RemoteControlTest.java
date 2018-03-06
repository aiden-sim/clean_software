package chater3.command;

/*
Client
 */
public class RemoteControlTest {

    public static void main(String[] args) {

        SimpleRemoteControl remote = new SimpleRemoteControl(); // Invoker

        Light light = new Light(); // Receiver

        LightOnCommand lightOn = new LightOnCommand(light); // ConcreteCommand
        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        LightOffCommand lightOff = new LightOffCommand(light);
        remote.setCommand(lightOff);
        remote.buttonWasPressed();

    }

}