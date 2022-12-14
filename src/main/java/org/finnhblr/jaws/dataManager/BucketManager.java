package org.finnhblr.jaws.dataManager;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import java.io.FileOutputStream;


import javax.imageio.ImageIO;
import java.io.*;

public class BucketManager {
    public BucketManager(){}

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
    public void uploadFile(String bucketName, String fileName, String path){
        // fileName is the "key" of the file.
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();

        try{
            s3.putObject(bucketName, fileName, new File(path));
        } catch (AmazonS3Exception error) {
            System.err.println(error.getErrorMessage());
            System.exit(1);
        }
    }

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
            IOUtils.copy(objectContent, new FileOutputStream("./images/bucket.svg"));
        } catch (IOException error) {
            System.err.println("File saving error!");
            error.printStackTrace();
        }
    }
}
