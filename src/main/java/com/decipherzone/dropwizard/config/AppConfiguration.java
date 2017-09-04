package com.decipherzone.dropwizard.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;

/**
 * Created on 3/9/17 3:38 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
public class AppConfiguration {

    @NotEmpty
    @JsonProperty("appName")
    private String appName;

    @JsonProperty("appBaseUrl")
    private String appBaseUrl;

    private DbConfig dbConfig = new DbConfig();

    public MongoClient getDataSource() {
        MongoCredential credential = MongoCredential.createCredential(dbConfig.getUsername(), dbConfig.getDbName(), dbConfig.getPassword().toCharArray());
        return new MongoClient(new ServerAddress(dbConfig.getHost(), dbConfig.getPort()), Collections.singletonList(credential));
    }

    public String getAppBaseUrl()
    {
        return appBaseUrl;
    }

    public String getAppName() {
        return appName;
    }
}
