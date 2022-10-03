package models;

/**
 * The type Lift data.
 *
 * @projectName: SkiResortClient
 * @package: NEU.cs6650.Models
 * @className: LiftData
 * @author: Bignfan Tian
 * @description: TODO
 * @date: 9 /28/22 3:04 PM
 * @version: 1.0
 */
public class LiftData {

    /**
     skierID - between 1 and 100000
     resortID - between 1 and 10
     liftID - between 1 and 40
     seasonID - 2022
     dayID - 1
     time - between 1 and 360
     **/
    private int skierID;
    private int resortID;
    private int liftID;
    private int seasonID;
    private int dayID;
    private int time;

    /**
     * Instantiates a new Lift data.
     *
     * @param skierID  the skier id
     * @param resortID the resort id
     * @param liftID   the lift id
     * @param seasonID the season id
     * @param dayID    the day id
     * @param time     the time
     */
    public LiftData(int skierID, int resortID, int liftID, int seasonID, int dayID, int time) {
        this.skierID = skierID;
        this.resortID = resortID;
        this.liftID = liftID;
        this.seasonID = seasonID;
        this.dayID = dayID;
        this.time = time;
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
     * Gets lift id.
     *
     * @return the lift id
     */
    public int getLiftID() {
        return liftID;
    }

    /**
     * Sets lift id.
     *
     * @param liftID the lift id
     */
    public void setLiftID(int liftID) {
        this.liftID = liftID;
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
    public int getDayID() {
        return dayID;
    }

    /**
     * Sets day id.
     *
     * @param dayID the day id
     */
    public void setDayID(int dayID) {
        this.dayID = dayID;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LiftData{" +
                "skierID=" + skierID +
                ", resortID=" + resortID +
                ", liftID=" + liftID +
                ", seasonID=" + seasonID +
                ", dayID=" + dayID +
                ", time=" + time +
                '}';
    }
}
