package part6.decorator;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class LoudDialModem implements Modem {
    private Modem itsModem;

    public LoudDialModem(Modem m) {
        itsModem = m;
    }

    public void dial(String pno) {
        itsModem.setSpeakerVolume(10);
        itsModem.dial(pno);
    }

    public void setSpeakerVolume(int volume) {
        itsModem.setSpeakerVolume(volume);
    }

    public String getPhoneNumber() {
        return itsModem.getPhoneNumber();
    }

    public int getSpeakerVolume() {
        return itsModem.getSpeakerVolume();
    }
}
