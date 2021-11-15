package com.TSI.MovieDatabase;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Base64;

@Configuration
public class AppConfig {
@Value("${cloud.aws.credentials.access-key}")
private String accessKey;
@Value("${cloud.aws.credentials.secret-key}")
private String secretKey;
    @Bean
    public DataSource dataSource(){
        AWSsecret secrets=getSecret();
        return DataSourceBuilder
                .create()
                .url("jdbc:" + secrets.getEngine() + "://" + secrets.getHost() + ":" + secrets.getPort() + "/sakila")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();


    }

    private Gson gson = new Gson();

    private AWSsecret getSecret() {

        String secretName = "arn:aws:secretsmanager:us-east-1:877439784628:secret:TestingDB-7jPfIh";
        String region = "us-east-1";

        // Create a Secrets Manager client
        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();

        // In this sample we only handle the specific exceptions for the 'GetSecretValue' API.
        // See https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
        // We rethrow the exception by default.

        String secret = null,
                decodedBinarySecret;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(secretName);
        GetSecretValueResult getSecretValueResult = null;

    try {
        getSecretValueResult = client.getSecretValue(getSecretValueRequest);
    } catch (Exception e) {
        e.printStackTrace();
    }
        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();
            return gson.fromJson(secret,AWSsecret.class);
        }
    return null;




    }
}


