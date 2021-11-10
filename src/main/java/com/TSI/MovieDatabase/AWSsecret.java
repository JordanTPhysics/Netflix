package com.TSI.MovieDatabase;


import io.cucumber.java.it.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class AWSsecret {
    private String username;
    private String password;


    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }




}




