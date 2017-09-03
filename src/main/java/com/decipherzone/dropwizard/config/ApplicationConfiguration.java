package com.decipherzone.dropwizard.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Created on 3/9/17 3:41 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */

class ApplicationConfiguration extends Configuration {

    private static final String CONFIG = "config";
    private static final String SWAGGER = "swagger";

    @JsonProperty(CONFIG)
    private AppConfiguration appConfig;

    @JsonProperty(SWAGGER)
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    public AppConfiguration getAppConfig() {
        return appConfig;
    }

    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }
}
