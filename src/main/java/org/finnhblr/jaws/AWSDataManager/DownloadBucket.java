package org.finnhblr.jaws.AWSDataManager;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadBucket extends BucketManager {
    public void downloadBucket(String bucketName, String fileName){
        // fileName is the "key" of the file.
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();
        // Create request and get data
        S3Object object = s3.getObject(new GetObjectRequest(bucketName, fileName));
        S3ObjectInputStream objectContent = object.getObjectContent();

        // Try to save images to ./images/
        try {
            // Saved with bucket name.
            IOUtils.copy(objectContent, new FileOutputStream(String.format("./dataworkdir/downloaded/%s", fileName)));
            System.out.println(String.format("Number of saved buckets is: %d", countDownloadedBuckets("./dataworkdir/downloaded/")));
        } catch (IOException error) {
            System.err.println("File saving error!");
            error.printStackTrace();
        }
    }

}
