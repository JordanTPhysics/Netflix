package com.TSI.MovieDatabase;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AWSsecret {
    private String username;
    private String password;
    private String engine;
    private String port;
    private String host;
    private String dbInstanceIdentifier;

    public String getEngine() {
        return engine;
    }

    public String getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getDbInstanceIdentifier() {
        return dbInstanceIdentifier;
    }


    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }




}




