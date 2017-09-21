package com.sample.dao;

import com.sample.entity.SampleUser;

import java.util.List;

/**
 * Created by Tharindu Kalhara on 9/21/2017.
 */
public interface UserDao extends GenericDao<Integer, SampleUser> {
    public int delete(Class className,int id);

}
