package dip;

/**
 * Created by simjunbo on 2018-02-19.
 */
public class Button {
    private ButtonServer button;

    public Button(ButtonServer button) {
        this.button = button;
    }

    public void poll() {
        button.turnOn();
    }
}

interface ButtonServer {
    public void turnOn();

    public void turnOff();
}

class Lamp implements ButtonServer {
    public void turnOn() {
        System.out.println("On");
    }

    public void turnOff() {
        System.out.println("Off");
    }
}
