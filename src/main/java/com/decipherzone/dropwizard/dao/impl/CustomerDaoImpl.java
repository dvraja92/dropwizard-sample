package com.decipherzone.dropwizard.dao.impl;

import com.decipherzone.dropwizard.AppConstants;
import com.decipherzone.dropwizard.bean.Customer;
import com.decipherzone.dropwizard.dao.CustomerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created on 3/9/17 4:28 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */

public class CustomerDaoImpl implements CustomerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

    public List<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();

        try (Stream<String> stream = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(AppConstants.CUSTOMER_FILE))).lines()) {

                stream.forEach((String res) ->{
                    String[] customerDetailsArr = res.split(",");
                    Customer customer = new Customer();
                    customer.setFirstName(customerDetailsArr[0].replaceAll("\"", ""));
                    customer.setLastName(customerDetailsArr[1].replaceAll("\"", ""));
                    customer.setCompanyName(customerDetailsArr[2].replaceAll("\"", ""));
                    customer.setAddress(customerDetailsArr[3].replaceAll("\"", ""));
                    customer.setCity(customerDetailsArr[4].replaceAll("\"", ""));
                    customer.setCounty(customerDetailsArr[5].replaceAll("\"", ""));
                    customer.setState(customerDetailsArr[6].replaceAll("\"", ""));
                    customer.setZip(customerDetailsArr[7].replaceAll("\"", ""));
                    customer.setPhoneNumber(customerDetailsArr[8].replaceAll("\"", ""));
                    customer.setEmail(customerDetailsArr[10].replaceAll("\"", ""));
                    customer.setWebsite(customerDetailsArr[11].replaceAll("\"", ""));
                    customerList.add(customer);
                });

        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }

        return customerList;
    }

}
