package org.finnhblr.jaws.aircraftManager;
import org.finnhblr.jaws.aircraftManager.aircraft.A380;
import org.finnhblr.jaws.aircraftManager.aircraft.Plane;
import org.finnhblr.jaws.aircraftManager.flightFunctions.SyncPlanesInitDownload;

import java.util.Arrays;

public class FlightManager {
    public FlightManager() {

    }

    public void createNewFlights() {
        //TODO Init UI
        // - Save list for use in IT/Flight Manager.

        SyncPlanesInitDownload initSync = new SyncPlanesInitDownload();
        // System.out.println(initSync.getPlanes().toString());

        for(Plane planes : initSync.getPlanes()){
            System.out.println(planes.getCallSign());
            System.out.println(planes.getType());
            System.out.println(planes.getInFlight());
        }

        System.out.println("Welcome to Waterbucket airport! We hope you have a well connected day in the cloud.");
        // Update planes?
        A380 firstPlane = new A380("A380", "0001", false);
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
        firstPlane.takeOff();
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
        firstPlane.land();
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
    }
}
