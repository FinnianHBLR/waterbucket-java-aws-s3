package org.finnhblr.jaws.AWSDataManager;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

public class CreateBucket {
    public void createBucket(String name) {
        // Init s3 client in Sydney
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();

        // Set bucket name
        String bucket_name = name;

        try {
            // Create bucket with client and name
            s3.createBucket(bucket_name);
        } catch (
                AmazonS3Exception error) {
            // Print any errors
            System.out.println(error.getErrorMessage());
        }


    }

}
