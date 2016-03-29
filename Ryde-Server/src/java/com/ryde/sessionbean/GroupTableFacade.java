/*
 * Created by Eric Leszcynski on 2016.03.28  * 
 * Copyright © 2016 Eric Leszcynski. All rights reserved. * 
 */
package com.ryde.sessionbean;

import com.ryde.entity.GroupTable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eric
 */
@Stateless
public class GroupTableFacade extends AbstractFacade<GroupTable> {

    @PersistenceContext(unitName = "Ryde-ServerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupTableFacade() {
        super(GroupTable.class);
    }
    public GroupTable findGroupById(int id) {return null;}
    public List<GroupTable> findGroupsByName(String name) {return null;}
    public GroupTable findGroupByName(String name) {return null;}

}
