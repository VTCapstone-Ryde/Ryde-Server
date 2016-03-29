/*
 * Created by Eric Leszcynski on 2016.03.28  * 
 * Copyright © 2016 Eric Leszcynski. All rights reserved. * 
 */
package com.ryde.sessionbean;

import com.ryde.entity.TimeslotTable;
import com.ryde.entity.TimeslotUser;
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
public class TimeslotUserFacade extends AbstractFacade<TimeslotUser> {

    @PersistenceContext(unitName = "Ryde-ServerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TimeslotUserFacade() {
        super(TimeslotUser.class);
    }
    public List<TimeslotTable> findUserTimeslots(int userID) {return null;}
    public List<UserTable> findUsersInTimeslot(int timeslotID) {return null;}
    public List<UserTable> findDriversInTimeslot(int driver) {return null;}

}
