package Model;

import java.util.Objects;

/**
 * The type Lift data.
 *
 * @author Bingfan Tian
 */
public class LiftData {

    private int resortID;
    private int seasonID;
    private String dayID;
    private int skierID;


    /**
     * Instantiates a new Lift data.
     *
     * @param resortID the resort id
     * @param seasonID the season id
     * @param dayID    the day id
     * @param skierID  the skier id
     */
    public LiftData(int resortID, int seasonID, String dayID, int skierID) {
        this.resortID = resortID;
        this.seasonID = seasonID;
        this.dayID = dayID;
        this.skierID = skierID;
    }

    /**
     * Gets resort id.
     *
     * @return the resort id
     */
    public int getResortID() {
        return resortID;
    }

    /**
     * Sets resort id.
     *
     * @param resortID the resort id
     */
    public void setResortID(int resortID) {
        this.resortID = resortID;
    }

    /**
     * Gets season id.
     *
     * @return the season id
     */
    public int getSeasonID() {
        return seasonID;
    }

    /**
     * Sets season id.
     *
     * @param seasonID the season id
     */
    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    /**
     * Gets day id.
     *
     * @return the day id
     */
    public String getDayID() {
        return dayID;
    }

    /**
     * Sets day id.
     *
     * @param dayID the day id
     */
    public void setDayID(String dayID) {
        this.dayID = dayID;
    }

    /**
     * Gets skier id.
     *
     * @return the skier id
     */
    public int getSkierID() {
        return skierID;
    }

    /**
     * Sets skier id.
     *
     * @param skierID the skier id
     */
    public void setSkierID(int skierID) {
        this.skierID = skierID;
    }

    public boolean isValid() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LiftData)) return false;
        LiftData liftData = (LiftData) o;
        return getResortID() == liftData.getResortID() && getSeasonID() == liftData.getSeasonID() &&
                getSkierID() == liftData.getSkierID() && getDayID().equals(liftData.getDayID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResortID(), getSeasonID(), getDayID(), getSkierID());
    }

    @Override
    public String toString() {
        return "LiftData{" +
                "resortID=" + resortID +
                ", seasonID=" + seasonID +
                ", dayID='" + dayID + '\'' +
                ", skierID=" + skierID +
                '}';
    }
}
