package org.finnhblr.jaws.aircraftManager;
import org.finnhblr.jaws.aircraftManager.aircraft.A380;

import java.io.IOException;

public class FlightManager {
    public FlightManager() {

    }

    public void createNewFlights() {
        System.out.println("Welcome to Waterbucket airport! We hope you have a well connected day in the cloud.");

        A380 firstPlane = new A380("A380", "0001", false);
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
        firstPlane.takeOff();
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
        firstPlane.land();
    }
}
