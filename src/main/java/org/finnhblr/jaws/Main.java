package org.finnhblr.jaws;
import org.finnhblr.jaws.aircraftManager.FlightManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("lo");

        FlightManager flightManager = new FlightManager();
        flightManager.createNewFlights();

    }

}
