package org.finnhblr.jaws;
import org.finnhblr.jaws.dataManager.BucketManager;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("lo");
        // Create new bucket
        BucketManager s3Manager = new BucketManager();
        s3Manager.createBucket("shepp-waterbucket");
    }

    }
