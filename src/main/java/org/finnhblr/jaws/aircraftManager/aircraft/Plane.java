package org.finnhblr.jaws.aircraftManager.aircraft;
import org.finnhblr.jaws.AWSDataManager.SyncBucketUp;

public abstract class Plane {
    // All plane methods must be defined here and overridden by subclasses! If not, methods will not be available.
    public String type;
    public String callSign;
    public Boolean inFlight;
    public Plane(String type, String callSign, Boolean inFlight){
        this.type = type;
        this.callSign = callSign;
        this.inFlight = inFlight;
        // At init the plane will be tracked. This adds extra traffic when objects are synced... An override in SyncPlanesDownload would solve this.
        s3tracker();
    }

    protected void s3tracker()  {
        // Any data changes are reflected on a s3 bucket. This is protected as only subclasses are able to use this method.
        SyncBucketUp tracker = new SyncBucketUp();
        tracker.syncBucketUpload("shepp-waterbucket", this);
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
