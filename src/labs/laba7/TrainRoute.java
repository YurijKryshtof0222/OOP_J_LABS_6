package labs.laba7;

import java.time.LocalTime;
import java.util.Objects;

public class TrainRoute {
    private String srcStation;
    private String dstStation;
    private LocalTime time;

    public TrainRoute(String sourceStation, String destinationStation, LocalTime date) {
        this.srcStation = sourceStation.strip();
        this.dstStation = destinationStation.strip();
        this.time = date;
    }

    public TrainRoute(String sourceStation, String destinationStation, int hour, int minutes) {
        this.srcStation = sourceStation;
        this.dstStation = destinationStation;
        this.time = LocalTime.of(hour, minutes, 0, 0);
    }

    @Override
    public String toString() {
        return String.format("%s %s - %02d:%02d", srcStation, dstStation, time.getHour(), time.getMinute());
    }

    public String getSrcStation() {
        return srcStation;
    }

    public void setSrcStation(String srcStation) {
        this.srcStation = srcStation.strip();
    }

    public String getDstStation() {
        return dstStation;
    }

    public void setDstStation(String dstStation) {
        this.dstStation = dstStation.strip();
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainRoute that = (TrainRoute) o;
        return Objects.equals(srcStation, that.srcStation) && Objects.equals(dstStation, that.dstStation) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srcStation, dstStation, time);
    }
}
