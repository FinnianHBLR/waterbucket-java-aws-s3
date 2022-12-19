# AWS Bucket tool
This is created to use AWS buckets on the storage service s3!
It will be a flight sync system for virtual planes to AWS servers.

### S3 Manager can do the following tasks:
* createBucket()
* uploadFile()
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
* s3tracker()
  * Any data changes in the Plane class are tracked with this function