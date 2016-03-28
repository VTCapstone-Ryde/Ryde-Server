/*
 * Created by Eric Leszcynski on 2016.03.28  * 
 * Copyright © 2016 Eric Leszcynski. All rights reserved. * 
 */
package com.ryde.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "TimeslotUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeslotUser.findAll", query = "SELECT t FROM TimeslotUser t"),
    @NamedQuery(name = "TimeslotUser.findById", query = "SELECT t FROM TimeslotUser t WHERE t.id = :id"),
    @NamedQuery(name = "TimeslotUser.findByDriver", query = "SELECT t FROM TimeslotUser t WHERE t.driver = :driver")})
public class TimeslotUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "driver")
    private Boolean driver;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserTable userId;
    @JoinColumn(name = "ts_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TimeslotTable tsId;

    public TimeslotUser() {
    }

    public TimeslotUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDriver() {
        return driver;
    }

    public void setDriver(Boolean driver) {
        this.driver = driver;
    }

    public UserTable getUserId() {
        return userId;
    }

    public void setUserId(UserTable userId) {
        this.userId = userId;
    }

    public TimeslotTable getTsId() {
        return tsId;
    }

    public void setTsId(TimeslotTable tsId) {
        this.tsId = tsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeslotUser)) {
            return false;
        }
        TimeslotUser other = (TimeslotUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ryde.entity.TimeslotUser[ id=" + id + " ]";
    }
    
}
