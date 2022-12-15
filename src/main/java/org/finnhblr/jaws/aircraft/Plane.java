package org.finnhblr.jaws.aircraft;

public abstract class Plane {
    public String type;
    public String callSign;

    public Boolean inFlight;
    public Plane(String type, String callSign, Boolean inFlight){
        this.type = type;
        this.callSign = callSign;
        this.inFlight = inFlight;
    }

    public void takeOff(){
        this.inFlight = true;
    }

    public void land(){
        this.inFlight = false;
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
