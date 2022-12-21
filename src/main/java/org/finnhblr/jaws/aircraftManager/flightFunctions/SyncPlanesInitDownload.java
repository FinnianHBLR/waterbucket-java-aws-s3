package org.finnhblr.jaws.aircraftManager.flightFunctions;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.finnhblr.jaws.awsDataManager.functions.DownloadBucket;
import org.finnhblr.jaws.awsDataManager.functions.ListBucket;
import org.finnhblr.jaws.aircraftManager.aircraft.A380;
import org.finnhblr.jaws.aircraftManager.aircraft.Plane;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SyncPlanesInitDownload {
    public List<Plane> getPlanes(){
        // Pull list of buckets, then each one opened for flights
        ListBucket listOfFlights = new ListBucket();
        List<S3ObjectSummary> newLister = listOfFlights.listAllBucketData("shepp-waterbucket");
        List<Plane> planes = new ArrayList<Plane>();;
        // For each object summary open and get key, this is so the files can be accessed.
        for (S3ObjectSummary s3object : newLister) {
            System.out.println(String.format("S3 Object Lister: %s", s3object.getKey()));

            // Download each one by call sign (key).
            DownloadBucket downloadBucket = new DownloadBucket();
            // Init each flight by its JSON
            planes = createPlane(downloadBucket.getBucketStream("shepp-waterbucket", s3object.getKey()));;
        }
        // Return a list of created plane objects.
        return planes;
    }

    private List<Plane> createPlane(byte[] jsonData){
        // Take in JSON files to create plane objects.
        String jsonPlaneData = new String(jsonData, StandardCharsets.UTF_8);
        // Convert JSON into list
        ObjectMapper objectToCreate = new ObjectMapper();

        try {
            Map<String, Object> map = objectToCreate.readValue(jsonData, new TypeReference<Map<String,Object>>(){});
            // DEBUG: System.out.println(map.get("type"));
            // List of planes to be returned.
            List<Plane> planes = new ArrayList<Plane>();
            // THIS IS WHERE OTHER TYPES OF PLANES ARE ADDED.
            // Check if the input type of the plane is an A380
            if("A380".equals(map.get("type"))){
                A380 newA380 = new A380(map.get("type").toString(), map.get("callSign").toString(), Boolean.parseBoolean(map.get("inFlight").toString()));
                // Add plane to list of planes
                // DEBUG: System.out.println("We have a: " + newA380.getType());
                planes.add(newA380);
            } else {
                // Else error.
                System.err.println("CHECK PLANE TYPE IS ADDED (SyncPlaneInitDownload) - Call sign: " + map.get("callSign") + " TYPE: " + map.get("type"));
                Thread.dumpStack();
            }

        return planes;
        } catch (IOException e) {
            System.err.println("Check your S3 bucket for non-Plane type JSON/other files!");
            throw new RuntimeException(e);
        }
    }
}
