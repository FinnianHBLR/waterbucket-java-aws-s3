package org.finnhblr.jaws;
import org.finnhblr.jaws.dataManager.BucketManager;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("lo");
        BucketManager s3Manager = new BucketManager();
        // Create new bucket
        s3Manager.createBucket("shepp-waterbucket");
        // Upload file to bucket
        s3Manager.uploadFile("shepp-waterbucket", "bucket.svg", "C:\\Users\\finnn\\Desktop\\Java\\java-aws\\images\\bucket.svg");
        // Download bucket
        s3Manager.downloadBucket("shepp-waterbucket", "bucket.svg");
    }

}
