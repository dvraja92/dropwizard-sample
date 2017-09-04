package com.decipherzone.dropwizard.service.impl;

import com.decipherzone.dropwizard.dao.ApplicationDao;
import com.decipherzone.dropwizard.service.ApplicationService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created on 4/9/17 4:25 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */
@Singleton
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationDao applicationDao;

    @Inject
    public ApplicationServiceImpl(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

    @Override
    public void loadInitialData() {
        applicationDao.loadInitialData();
    }



}
