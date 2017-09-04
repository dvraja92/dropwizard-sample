package com.decipherzone.dropwizard.dao.impl;

import com.decipherzone.dropwizard.dao.CustomerDao;
import com.decipherzone.dropwizard.dao.BaseDao;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/9/17 4:28 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
@Singleton
public class CustomerDaoImpl implements CustomerDao, BaseDao<BasicDBObject> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

    private MongoClient mongoClient;

    @Inject
    public CustomerDaoImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public List<BasicDBObject> getAllCustomers(){
        List<BasicDBObject> customerList = new ArrayList<>();

        MongoCursor<BasicDBObject> iterator = getCollection(mongoClient, BasicDBObject.class).find().batchSize(100).iterator();
        while (iterator.hasNext()){
            customerList.add(iterator.next());
        }
        return customerList;
    }

}
