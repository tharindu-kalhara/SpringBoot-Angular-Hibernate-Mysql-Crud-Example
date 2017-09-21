/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.dao.impl;

import com.sample.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * Created by Tharindu Kalhara on 9/21/2017.
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<PK extends Serializable, T> implements GenericDao<PK, T> {

    private final Class<? extends T> daoType;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(daoType);
    }

    @Override
    public PK add(T entity) {
        return (PK) getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public T getByKey(PK key) {
        return (T) getSession().get(daoType, key);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) createEntityCriteria().list();
    }

    /*@Author - Kalhara  , @Datetime - 2017-06-19 02:27:14 PM */
    @Override
    public Integer getInteger(Object val) {
        try {
            return Integer.parseInt(val.toString());
        } catch (NullPointerException | NumberFormatException e) {
            return 0;
        }
    }

    /*@Author - Kalhara  , @Datetime - 2017-06-19 02:27:14 PM */
    @Override
    public String getString(Object val) {
        try {
            return val.toString();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /*@Author - Kalhara  , @Datetime - 2017-06-19 02:27:14 PM */
    @Override
    public Boolean getBoolean(Object val) {
        try {
            return Boolean.parseBoolean(val.toString());
        } catch (NullPointerException e) {
            return null;
        }
    }

    /*@Author - Kalhara  , @Datetime - 2017-06-19 02:27:14 PM */

    public Double getDouble(Object val) {
        try {
            return new Double(val.toString());
        } catch (NullPointerException e) {
            return null;
        }
    }


    /*@Author - Kalhara  , @Datetime - 2017-07-19 01:52:12 PM */
    @Override
    public void print(String name,Object object){
        System.out.println("HR-PRINT : "+name+" > "+object);
    }


    /*@Author - Kalhara  , @Datetime - 2017-07-19 01:52:12 PM */
    public void print(String name){
        System.out.println("SAMO-PRINT : "+name);
    }

}
