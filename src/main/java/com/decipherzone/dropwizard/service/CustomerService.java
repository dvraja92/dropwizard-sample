package com.decipherzone.dropwizard.service;

import com.decipherzone.dropwizard.bean.Customer;

import java.util.List;

/**
 * Created on 3/9/17 4:31 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */

public interface CustomerService {

    /**
     * Getting all customers
     * @return List of customers
     */
    List<Customer> getAllCustomers();

}
