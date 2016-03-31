/*
 * Created by Cameron Gibson on 2016.03.31  * 
 * Copyright © 2016 Cameron Gibson. All rights reserved. * 
 */
package com.ryde.restful;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author cameron
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.ryde.restful.UserTableFacadeREST.class);
    }
    
}
