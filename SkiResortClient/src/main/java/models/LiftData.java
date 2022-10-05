package models;

import io.swagger.client.model.LiftRide;

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

    private int resortID;
    private String seasonID;
    private String dayID;
    private int skierID;
    private LiftRide liftRide;

    public LiftData(int resortID, String seasonID, String dayID, int skierID, LiftRide liftRide) {
        this.resortID = resortID;
        this.seasonID = seasonID;
        this.dayID = dayID;
        this.skierID = skierID;
        this.liftRide = liftRide;
    }

    public int getResortID() {
        return resortID;
    }

    public void setResortID(int resortID) {
        this.resortID = resortID;
    }

    public String getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(String seasonID) {
        this.seasonID = seasonID;
    }

    public String getDayID() {
        return dayID;
    }

    public void setDayID(String dayID) {
        this.dayID = dayID;
    }

    public int getSkierID() {
        return skierID;
    }

    public void setSkierID(int skierID) {
        this.skierID = skierID;
    }

    public LiftRide getLiftRide() {
        return liftRide;
    }

    public void setLiftRide(LiftRide liftRide) {
        this.liftRide = liftRide;
    }

    @Override
    public String toString() {
        return "LiftData{" +
                "resortID=" + resortID +
                ", seasonID=" + seasonID +
                ", dayID=" + dayID +
                ", skierID=" + skierID +
                ", liftRide=" + liftRide.toString() +
                '}';
    }
}
