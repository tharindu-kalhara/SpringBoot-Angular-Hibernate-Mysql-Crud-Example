/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.dao;

import java.util.List;

/**
 *
 * Created by Tharindu Kalhara on 9/21/2017.
 */
public interface GenericDao<PK, T> {

    public PK add(T entity);

    public void saveOrUpdate(T entity);

    public void delete(T entity);

    public T getByKey(PK key);

    public List<T> getAll();

    /*@Author - Kalhara  , @Datetime - 2017-06-19 02:27:14 PM */
    public Integer getInteger(Object val);

    /*@Author - Kalhara  , @Datetime - 2017-06-19 02:27:14 PM */
    public String getString(Object val);

    /*@Author - Kalhara  , @Datetime - 2017-06-19 02:27:14 PM */
    public Boolean getBoolean(Object val);

    /*@Author - Kalhara  , @Datetime - 2017-07-19 01:52:12 PM */
    public void print(String name, Object object);

}
