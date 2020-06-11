package com.Home.TaskRest.Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import java.io.Serializable;

@Stateless
@LocalBean
public class DBServiseProducer implements Serializable {
    @Produces
    public DBService getDbService(){
        return new DBService();
    }
}
