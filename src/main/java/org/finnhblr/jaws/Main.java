package org.finnhblr.jaws;
import org.finnhblr.jaws.aircraftManager.FlightManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("lo");

        FlightManager flightManager = new FlightManager();
        flightManager.createNewFlights();

    }

}
