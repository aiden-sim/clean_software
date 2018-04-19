package part3.command;

/*
Command Concrete
 */
public class LightOnCommand implements Command {

    Light light;   //이 Light 객체는 실제 불키는 방법을 알고있는 리시버 객체


    public LightOnCommand(Light light) {

        this.light = light;

    }


    @Override
    public void execute() {

        light.on();

    }

}