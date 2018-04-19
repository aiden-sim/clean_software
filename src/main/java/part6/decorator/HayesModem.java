package part6.decorator;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class HayesModem implements Modem {
    private String itsPhoneNumber;
    private int itsSpekaerVolume;

    public void dial(String pno) {
        itsPhoneNumber = pno;
    }

    public void setSpeakerVolume(int volume) {
        itsSpekaerVolume = volume;
    }

    public String getPhoneNumber() {
        return itsPhoneNumber;
    }

    public int getSpeakerVolume() {
        return itsSpekaerVolume;
    }
}
