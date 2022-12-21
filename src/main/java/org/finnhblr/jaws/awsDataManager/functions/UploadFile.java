package org.finnhblr.jaws.awsDataManager.functions;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import java.io.File;

public class UploadFile {
    public UploadFile(String bucketName, String fileName, String path){
        // fileName is the "key" of the file.
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();

        try{
            s3.putObject(bucketName, fileName, new File(path));
        } catch (AmazonS3Exception error) {
            System.err.println(error.getErrorMessage());
        }
    }

}
