package org.finnhblr.jaws.AWSDataManager.functions;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.List;

public class ListBucket {
    public ListBucket(){

    }

    public List<S3ObjectSummary> listAllBucketData(String bucketName) {
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();
        // Create list of object summaries, use getKey to get names.
        ObjectListing objects = s3.listObjects(bucketName);


        List<S3ObjectSummary> objectList = objects.getObjectSummaries();
        return objectList;
        // Log out each name
        /*
        for (S3ObjectSummary s3object: objectList) {
            System.out.println(String.format("S3 Object Lister: %s", s3object.getKey()));
        }
        */
    }
}
