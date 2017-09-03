package com.decipherzone.dropwizard.dao;

import com.decipherzone.dropwizard.bean.Customer;

import java.util.List;

/**
 * Created on 3/9/17 4:33 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */

public interface CustomerDao {

    /**
     * Getting all customers
     * @return List of customers
     */
    List<Customer> getAllCustomers();

}
