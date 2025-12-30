package com.smhrd.web.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.checksums.RequestChecksumCalculation;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class NCPBucketConfig {
    @Value("${ncp.access-key}")
    private String accessKey;

    @Value("${ncp.secret-key}")
    private String secretKey;

    @Value("${ncp.region}")
    private String region;

    @Value("${ncp.end-point}")
    private String endPoint;

    @Value("${ncp.bucket-name}")
    private String bucketName;

    @Bean
    public S3Client amazonS3() {
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey,secretKey)
                ))
                .requestChecksumCalculation(RequestChecksumCalculation.WHEN_REQUIRED)
                .endpointOverride(URI.create(endPoint))
                .build();
    }
}
