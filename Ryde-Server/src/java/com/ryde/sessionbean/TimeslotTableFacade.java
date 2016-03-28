/*
 * Created by Eric Leszcynski on 2016.03.28  * 
 * Copyright © 2016 Eric Leszcynski. All rights reserved. * 
 */
package com.ryde.sessionbean;

import com.ryde.entity.TimeslotTable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eric
 */
@Stateless
public class TimeslotTableFacade extends AbstractFacade<TimeslotTable> {

    @PersistenceContext(unitName = "Ryde-ServerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TimeslotTableFacade() {
        super(TimeslotTable.class);
    }
    
}
