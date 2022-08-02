package ss4_class_and_object.stop_watch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void start(long time) {
        this.startTime = time;
    }

    public void stop(long time) {
        this.endTime = time;
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}
