package com.decipherzone.dropwizard.service.impl;

import com.decipherzone.dropwizard.bean.Customer;
import com.decipherzone.dropwizard.dao.CustomerDao;
import com.decipherzone.dropwizard.service.CustomerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created on 3/9/17 4:27 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
@Singleton
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Inject
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.getAllCustomers();
    }

}
