package org.finnhblr.jaws.AWSDataManager;
import java.io.*;

public abstract class BucketManager {
    public BucketManager(){}


    public int countDownloadedBuckets(String path){
        // Count number of files stored in a specific directory.
        return new File(path).list().length;
    }
}
