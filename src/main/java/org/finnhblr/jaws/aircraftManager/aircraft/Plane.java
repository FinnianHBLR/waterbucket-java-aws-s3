package org.finnhblr.jaws.aircraftManager.aircraft;
import org.finnhblr.jaws.AWSDataManager.SyncBucket;

public abstract class Plane {
    public String type;
    public String callSign;
    public Boolean inFlight;
    public Plane(String type, String callSign, Boolean inFlight){
        this.type = type;
        this.callSign = callSign;
        this.inFlight = inFlight;

    }
    private void s3tracker()  {
        // Any data changes are reflected on a s3 bucket.
        SyncBucket tracker = new SyncBucket("shepp-waterbucket", this);
    }
    public void takeOff() {
        this.inFlight = true;
        s3tracker();
    }

    public void land() {
        this.inFlight = false;
        s3tracker();
    }

    public Boolean getInFlight() {
        return inFlight;
    }

    public String getCallSign() {
        return callSign;
    }

    public String getType() {
        return type;
    }
}
