package chater2.isp2;

/**
 * Created by simjunbo on 2018-02-20.
 */
public abstract class Door {
    public abstract void lock();

    public abstract void unLock();

    public abstract boolean isDoorOpen();
}

class TimedDoor extends Door {
    public void doorTimeOut(int timeOutId) {

    }

    @Override
    public void lock() {

    }

    @Override
    public void unLock() {

    }

    @Override
    public boolean isDoorOpen() {
        return false;
    }
}

abstract class TimerClient {
    public abstract void timeOut(int timeOutId);
}

class DoorTimerAdapter extends TimerClient {
    private TimedDoor itsTimerdoor;

    public DoorTimerAdapter(TimedDoor theDoor) {
        this.itsTimerdoor = theDoor;
    }

    public void timeOut(int timeOutId) {
        itsTimerdoor.doorTimeOut(timeOutId);
    }
}