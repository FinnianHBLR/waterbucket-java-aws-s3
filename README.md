# AWS Bucket tool
This is created to use AWS buckets on the storage service s3!
It will be a flight sync system for virtual planes to AWS servers.

### S3 Manager can do the following tasks:
* createBucket()
* uploadFile() `To S3`
* downloadBucket()
* SyncBucket()
  * Uploads file with plane call sign and data to AWS s3
### Plane Manager
+type  
+inFlight  
+callSign

* createNewFlights()  
* takeOff()  
* land()  
* s3tracker() `To S3`
  * Any data changes in any Plane class are tracked by uploading to S3 with this function
* getPlanes() `From S3`
* createPlanes() `From S3`