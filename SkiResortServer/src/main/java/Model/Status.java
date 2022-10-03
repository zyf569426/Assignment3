package Model;

/**
 * The type Status.
 *
 * @projectName: SkiResort
 * @package: NEU.CS6650.Model
 * @className: Status
 * @author: Eric
 * @description: TODO
 * @date: 9 /28/22 1:13 AM
 * @version: 1.0
 */
public class Status {
    private boolean success;
    private String description;

    /**
     * Instantiates a new Status.
     *
     * @param success     the success
     * @param description the description
     */
    public Status(boolean success, String description) {
        this.success = success;
        this.description = description;
    }

    public Status() {
        this.success = false;
        this.description = "Fails";
    }

    /**
     * Is success boolean.
     *
     * @return the boolean
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets success.
     *
     * @param success the success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
