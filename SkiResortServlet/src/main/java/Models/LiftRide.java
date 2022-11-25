package Models;


public class LiftRide {
    private int skierId;
    private int resortId;
    private int seasonId;
    private int dayId;
    private int time;
    private int liftID;

    public LiftRide(int skierId, int resortId, int seasonId, int dayId, int time, int liftID) {
        this.skierId = skierId;
        this.resortId = resortId;
        this.seasonId = seasonId;
        this.dayId = dayId;
        this.time = time;
        this.liftID = liftID;
    }

    public int getSkierId() {
        return skierId;
    }

    public void setSkierId(int skierId) {
        this.skierId = skierId;
    }

    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getLiftID() {
        return liftID;
    }

    public void setLiftID(int liftID) {
        this.liftID = liftID;
    }

    @Override
    public String toString() {
        return "LiftRide{" +
            "skierId=" + skierId +
            ", resortId=" + resortId +
            ", seasonId=" + seasonId +
            ", dayId=" + dayId +
            ", time=" + time +
            ", liftId=" + liftID +
            '}';
    }
}
