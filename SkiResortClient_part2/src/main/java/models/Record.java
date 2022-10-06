package models;

/**
 * The type Record.
 *
 * @className: Record
 * @author: Bingfan Tian
 * @description: TODO
 * @date: 10 /6/22 2:44 AM
 */
public class Record {


    private long startTime;
    private String requestType;
    private long latency;
    private int responseCode;

    /**
     * Instantiates a new Record.
     *
     * @param startTime    the start time
     * @param requestType  the request type
     * @param latency      the latency
     * @param responseCode the response code
     */
    public Record(long startTime, String requestType, long latency, int responseCode) {
        this.startTime = startTime;
        this.requestType = requestType;
        this.latency = latency;
        this.responseCode = responseCode;
    }

    /**
     * To csv format string.
     *
     * @return the string
     */
    public String toCSVFormat() {
        // csv format:
        // startTime,requestType,latency,responseCode
        return startTime + "," + requestType + "," + latency + "," + responseCode + "\n";
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets request type.
     *
     * @return the request type
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Sets request type.
     *
     * @param requestType the request type
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * Gets latency.
     *
     * @return the latency
     */
    public long getLatency() {
        return latency;
    }

    /**
     * Sets latency.
     *
     * @param latency the latency
     */
    public void setLatency(long latency) {
        this.latency = latency;
    }

    /**
     * Gets response code.
     *
     * @return the response code
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Sets response code.
     *
     * @param responseCode the response code
     */
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
