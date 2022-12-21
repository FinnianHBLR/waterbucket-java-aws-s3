# AWS Bucket tool
This is created to use AWS buckets on the storage service s3!
It will be a flight sync system for virtual planes to AWS servers.

### S3 Manager can do the following tasks:
* createBucket() `⬆️ S3`
* uploadFile() `⬆️ S3`
* downloadBucket() `⬇️ S3`
* listBucket() `⬇️ all buckets available`
* SyncBucket() `⬆️ Uploads plane objects to AWS s3`
### Plane Manager
+type  
+inFlight  
+callSign

* createNewFlights()  
* takeOff()  
* land()  
* s3tracker() `⬆️ Any data changes in any Plane class are tracked by uploading to S3 with this function`
* getPlanes() `⬇️ S3`
* createPlanes()