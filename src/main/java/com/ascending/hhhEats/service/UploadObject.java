package com.ascending.hhhEats.service;
import java.io.File;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;

@Service
public class UploadObject {

    private String clientRegion="us-east-1";

    public void uploadObject(String bucketName, File f) {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(clientRegion)
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
        // Upload a file as a new object with ContentType and title specified.
        PutObjectRequest request = new PutObjectRequest(bucketName, f.getName(), f);
        s3Client.putObject(request);
    }

//    public static void main(String[] args) throws IOException {
//        String clientRegion = "*** Client region ***";
//        String bucketName = "*** Bucket name ***";
//        String stringObjKeyName = "*** String object key name ***";
//        String fileObjKeyName = "*** File object key name ***";
//        String fileName = "*** Path to file to upload ***";
//
//        try {
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withRegion(clientRegion)
//                    .withCredentials(new ProfileCredentialsProvider())
//                    .build();
//
//            // Upload a text string as a new object.
//            s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");
//
//            // Upload a file as a new object with ContentType and title specified.
//            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
//            s3Client.putObject(request);
//        }
//        catch(AmazonServiceException e) {
//            // The call was transmitted successfully, but Amazon S3 couldn't process
//            // it, so it returned an error response.
//            e.printStackTrace();
//        }
//        catch(SdkClientException e) {
//            // Amazon S3 couldn't be contacted for a response, or the client
//            // couldn't parse the response from Amazon S3.
//            e.printStackTrace();
//        }
//    }
}