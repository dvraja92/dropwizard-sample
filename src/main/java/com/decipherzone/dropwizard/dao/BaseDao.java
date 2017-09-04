package com.decipherzone.dropwizard.dao;

import com.decipherzone.dropwizard.AppConstants;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

/**
 * Created on 4/9/17 7:42 PM by Raja Dushyant Vashishtha
 * Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */

public interface BaseDao<T> {

    default MongoCollection<T> getCollection(MongoClient mongoClient, String collectionName, Class<T> returnClass){
        return mongoClient.getDatabase(AppConstants.APP_DATABASE_NAME).getCollection(collectionName, returnClass);
    }

}
