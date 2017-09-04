package com.decipherzone.dropwizard.dao.impl;

import com.decipherzone.dropwizard.AppConstants;
import com.decipherzone.dropwizard.dao.ApplicationDao;
import com.decipherzone.dropwizard.dao.BaseDao;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created on 4/9/17 7:53 PM by Raja Dushyant Vashishtha
 * Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
@Singleton
public class ApplicationDaoImpl implements ApplicationDao, BaseDao<BasicDBObject> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationDaoImpl.class);

    private MongoClient mongoClient;

    @Inject
    public ApplicationDaoImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void loadInitialData() {
        loadCustomers();
    }

    private boolean loadCustomers(){
        MongoCollection<BasicDBObject> customerCollection = getCollection(mongoClient, AppConstants.CUSTOMER_COLLECTION, BasicDBObject.class);

        if (customerCollection.count() == 0){
            List<BasicDBObject> customerList = new ArrayList<>();

            try (Stream<String> stream = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(AppConstants.CUSTOMER_FILE))).lines()) {

                stream.forEach((String res) ->{
                    String[] customerDetailsArr = res.split(",");
                    BasicDBObject customer = new BasicDBObject();
                    customer.put("FirstName", customerDetailsArr[0].replaceAll("\"", ""));
                    customer.put("LastName", customerDetailsArr[1].replaceAll("\"", ""));
                    customer.put("CompanyName", customerDetailsArr[2].replaceAll("\"", ""));
                    customer.put("Address", customerDetailsArr[3].replaceAll("\"", ""));
                    customer.put("City", customerDetailsArr[4].replaceAll("\"", ""));
                    customer.put("County", customerDetailsArr[5].replaceAll("\"", ""));
                    customer.put("State", customerDetailsArr[6].replaceAll("\"", ""));
                    customer.put("Zip", customerDetailsArr[7].replaceAll("\"", ""));
                    customer.put("PhoneNumber", customerDetailsArr[8].replaceAll("\"", ""));
                    customer.put("Email", customerDetailsArr[10].replaceAll("\"", ""));
                    customer.put("Website", customerDetailsArr[11].replaceAll("\"", ""));
                    customerList.add(customer);
                });

                customerCollection.insertMany(customerList);

                return true;
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                return false;
            }
        }

        return false;
    }
}
