package org.finnhblr.jaws.aircraftManager;
import org.finnhblr.jaws.aircraft.A380;

public class FlightManager {
    public FlightManager() {

    }

    public void createNewFlights(){
        A380 firstPlane = new A380("A380", "0001", false);
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
        firstPlane.takeOff();
        System.out.println(String.format("Flight in progress type:%s in Air:%s", firstPlane.getType() , firstPlane.getInFlight()));
        firstPlane.land();
    }

    /*
    public JSONObject dumbAllStatus(){
        JSONObject jsonData = new JSONObject();
        jsonData.put("name");
        return jsonData);
    }
    */

}
