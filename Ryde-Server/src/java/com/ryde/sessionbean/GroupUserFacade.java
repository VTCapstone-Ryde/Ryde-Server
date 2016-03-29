/*
 * Created by Eric Leszcynski on 2016.03.28  * 
 * Copyright © 2016 Eric Leszcynski. All rights reserved. * 
 */
package com.ryde.sessionbean;

import com.ryde.entity.GroupTable;
import com.ryde.entity.GroupUser;
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
public class GroupUserFacade extends AbstractFacade<GroupUser> {

    @PersistenceContext(unitName = "Ryde-ServerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupUserFacade() {
        super(GroupUser.class);
    }
    
    public List<GroupTable> findUserGroups(int userID) {return null;}
    public List<UserTable> findUsersInGroup(int groupID) {return null;}
    public List<UserTable> findAdminsInGroup(int groupID) {return null;}

    
}
