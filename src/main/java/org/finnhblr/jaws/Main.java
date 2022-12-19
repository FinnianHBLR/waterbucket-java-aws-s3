package org.finnhblr.jaws;
import org.finnhblr.jaws.AWSDataManager.SyncBucket;
import org.finnhblr.jaws.aircraftManager.FlightManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("lo");
        // DownloadBucket s3BucketDownload = new DownloadBucket();
        // Create new bucket
        // s3Manager.createBucket("shepp-waterbucket");
        // Upload file to bucket
        // s3Manager.uploadFile("shepp-waterbucket", "bucket.svg", "C:\\Users\\finnn\\Desktop\\Java\\java-aws\\images\\bucket.svg");
        // Download bucket
        // s3BucketDownload.downloadBucket("shepp-waterbucket", "bucket.svg");

        FlightManager flightManager = new FlightManager();
        flightManager.createNewFlights();

        // syncer.listAllBucketData("shepp-waterbucket");

    }

}
