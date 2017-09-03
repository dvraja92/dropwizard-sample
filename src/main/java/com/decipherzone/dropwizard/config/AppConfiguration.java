package com.decipherzone.dropwizard.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created on 3/9/17 3:38 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
public class AppConfiguration {

    private static final String APP_NAME = "appName";
    private static final String APP_BASE_URL = "appBaseUrl";

    @NotEmpty
    @JsonProperty(APP_NAME)
    private String appName;

    @JsonProperty(APP_BASE_URL)
    private String appBaseUrl;

    public String getAppBaseUrl()
    {
        return appBaseUrl;
    }

    public String getAppName() {
        return appName;
    }
}
