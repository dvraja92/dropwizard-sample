package com.decipherzone.dropwizard.config;

import com.decipherzone.dropwizard.AppConstants;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created on 4/9/17 3:40 PM by Raja Dushyant Vashishtha
 * Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DbConfig {
    private String username = AppConstants.DB_USERNAME;
    private String password = AppConstants.DB_PASSWORD;
    private String host = AppConstants.DB_HOST;
    private int port = AppConstants.DB_PORT;
    private String dbName = AppConstants.DB_AUTH;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }
}
