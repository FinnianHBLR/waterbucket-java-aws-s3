package org.finnhblr.jaws.awsDataManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.finnhblr.jaws.awsDataManager.functions.UploadFile;
import org.finnhblr.jaws.aircraftManager.aircraft.Plane;
import java.io.FileWriter;
import java.io.IOException;

public class SyncBucketUp {
    public SyncBucketUp(){

    }

    public void syncBucketUpload(String bucketName, Plane plane) {
        // This is attached to any parameter from any Plane class you'd like to track.
        // TODO change to byte[] like DownloadBucket.

        try{
            // Convert Plane to JSON
            ObjectMapper objMapper = new ObjectMapper();
            String jsonPlaneObj = objMapper.writeValueAsString(plane);

            // Save JSON Plane file
            FileWriter myWriter = new FileWriter(String.format("./dataworkdir/upload/%s.json", plane.callSign));
            myWriter.write(jsonPlaneObj);
            myWriter.close();
            // DEBUG: System.out.println("SENDING" + plane.callSign + plane.inFlight + plane.type);
        } catch (IOException error){
            System.err.println("FILE SYNC ERROR");
        }

        // Upload JSON plane object. The plane call sign is used to name the file.
        UploadFile fileToUpload = new UploadFile(bucketName, plane.callSign, String.format("./dataworkdir/upload/%s.json", plane.callSign));
    }
}
