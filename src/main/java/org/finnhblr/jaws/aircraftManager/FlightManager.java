package org.finnhblr.jaws.aircraftManager;
import org.finnhblr.jaws.aircraft.A380;

import java.io.IOException;

public class FlightManager {
    public FlightManager() {

    }

    public void createNewFlights() throws IOException {
        A380 firstPlane = new A380("A380", "0001", false);
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
        firstPlane.takeOff();
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
        firstPlane.land();
    }
}