package chater3.command;

/*
Command Concrete
 */
public class LightOffCommand implements Command {

    Light light;   //이 Light 객체는 실제 불키는 방법을 알고있는 리시버 객체


    public LightOffCommand(Light light) {

        this.light = light;

    }


    @Override
    public void execute() {

        light.on();

    }

}