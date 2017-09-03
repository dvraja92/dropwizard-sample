package com.decipherzone.dropwizard.config;

import com.decipherzone.dropwizard.dao.CustomerDao;
import com.decipherzone.dropwizard.dao.impl.CustomerDaoImpl;
import com.decipherzone.dropwizard.health.ApplicationHealthCheck;
import com.decipherzone.dropwizard.resources.CustomerResource;
import com.decipherzone.dropwizard.service.CustomerService;
import com.decipherzone.dropwizard.service.impl.CustomerServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.jersey.errors.LoggingExceptionMapper;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Created on 3/9/17 3:40 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
class SampleApplication extends Application<ApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        String[] param = {"server", "config.yml"};
        new SampleApplication().run(param);
//        new SampleApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<ApplicationConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ApplicationConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });
    }

    @Override
    public void run(final ApplicationConfiguration config, final Environment env) {
        final FilterRegistration.Dynamic cors = env.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        ((DefaultServerFactory) config.getServerFactory()).setRegisterDefaultExceptionMappers(false);
        env.jersey().register(new LoggingExceptionMapper<Throwable>(){});

        Injector injector = createInjector(config);

        env.jersey().register(injector.getInstance(CustomerResource.class));
        env.healthChecks().register(config.getAppConfig().getAppName(), new ApplicationHealthCheck(config.getAppConfig().getAppName()));
    }

    /**
     * Binding services and DAOs for dependency injections
     * @param config ApplicationConfiguration.class
     * @return com.google.inject.Injector
     */
    private Injector createInjector(ApplicationConfiguration config) {
        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                // services
                bind(CustomerService.class).to(CustomerServiceImpl.class);

                // dao
                bind(CustomerDao.class).to(CustomerDaoImpl.class);

                bind(AppConfiguration.class).toInstance(config.getAppConfig());
            }
        });
    }

}
