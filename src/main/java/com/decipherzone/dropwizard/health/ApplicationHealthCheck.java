package com.decipherzone.dropwizard.health;

import com.codahale.metrics.health.HealthCheck;
import com.decipherzone.dropwizard.AppConstants;

/**
 * Created on 3/9/17 3:49 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
public class ApplicationHealthCheck extends HealthCheck {

    private final String appName;

    public ApplicationHealthCheck(String appName) {
        this.appName = appName;
    }

    /**
     * For checking the health of application
     * @return
     * @throws Exception
     */
    @Override
    protected Result check() throws Exception {
        final String saying = String.format(appName, AppConstants.APP_NAME);
        if (!saying.contains(AppConstants.APP_NAME)) {
            return Result.unhealthy("Application doesn't include a name");
        }
        return Result.healthy();
    }
}
