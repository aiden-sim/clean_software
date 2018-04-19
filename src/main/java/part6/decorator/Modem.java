package part6.decorator;

/**
 * Created by simjunbo on 2018-04-19.
 */
public interface Modem {
    public void dial(String pno);

    public void setSpeakerVolume(int volume);

    public String getPhoneNumber();

    public int getSpeakerVolume();
}
