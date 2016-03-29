/*
 * Created by Eric Leszcynski on 2016.03.28  * 
 * Copyright © 2016 Eric Leszcynski. All rights reserved. * 
 */
package com.ryde.sessionbean;

import com.ryde.entity.UserTable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eric
 */
@Stateless
public class UserTableFacade extends AbstractFacade<UserTable> {

    @PersistenceContext(unitName = "Ryde-ServerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserTableFacade() {
        super(UserTable.class);
    }
    public UserTable findUserById(int id) {return null;}
    public UserTable createUser() {return null;}
    public UserTable updateUser(UserTable user) {return null;}
    public UserTable deleteUser(int id) {return null;}
    public List<UserTable> findAllByName(String name) {return null;}

    
    
}
