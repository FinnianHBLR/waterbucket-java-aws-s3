package org.finnhblr.jaws.awsDataManager.functions;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import java.io.IOException;

public class DownloadBucket {
    public DownloadBucket(){

    }

    public byte[] getBucketStream(String bucketName, String fileName) {
        // fileName is the "key" of the file.
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();
        // Create request and get data
        S3Object object = s3.getObject(new GetObjectRequest(bucketName, fileName));
        S3ObjectInputStream objectContent = object.getObjectContent();

        // Get S3 object as byteArray.
        byte[] byteArrayDownload;
        try {
            // Convert object contents to byteArray
            byteArrayDownload = IOUtils.toByteArray(objectContent);
            // DEBUG as string: System.out.println(new String(byteArrayDownload, StandardCharsets.UTF_8));
            return byteArrayDownload;
        } catch (IOException error) {
            throw new RuntimeException(error);
        }
    }
}
