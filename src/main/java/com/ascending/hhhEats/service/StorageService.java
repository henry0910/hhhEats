package com.ascending.hhhEats.service;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

@Service
public class StorageService {
    private AmazonS3 s3Client;
    private String clientRegion="us-east-1";
    public StorageService(@Autowired AmazonS3 s3) {
        this.s3Client=s3;
    }

    public String getObject(String bucketName, String key) {
        URL url = s3Client.getUrl(bucketName, key);
        return url.toString();
    }
    public void uploadObject(String bucketName, File f) {
        // Upload a file as a new object with ContentType and title specified.
        PutObjectRequest request = new PutObjectRequest(bucketName, f.getName(), f);
        s3Client.putObject(request);
    }
    public void setS3Client(AmazonS3 s3) {
        this.s3Client = s3;
    }
    public AmazonS3 getS3Client() {
        return this.s3Client;
    }
}
