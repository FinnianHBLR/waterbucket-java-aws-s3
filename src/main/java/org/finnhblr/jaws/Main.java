package org.finnhblr.jaws;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(tester("lo"));
        // Create new bucket
        createBucket();
    }

    public static String tester(String x){
        return x;
    }

     public static void createBucket(){
        // Init s3 client in Sydney
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();

        // Set bucket name
        String bucket_name = "shepp-waterbucket";

        try{
            // Create bucket with client and name
            s3.createBucket(bucket_name);
        } catch (AmazonS3Exception error){
            // Print any errors
            System.out.println(error.getErrorMessage());
        }
    }
}