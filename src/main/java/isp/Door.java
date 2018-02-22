package isp;

/**
 * Created by simjunbo on 2018-02-20.
 */
public abstract class Door {
    public abstract void lock();

    public abstract void unLock();

    public abstract boolean isDoorOpen();
}

class Timer {
    public void register(int timeout, int timeOutId, TimerClient client) {

    }
}

abstract class TimerClient {
    public abstract void timeOut(int timeOutId);
}