package com.sample.dao;

import com.sample.entity.SampleContact;

import java.util.List;

/**
 * Created by Tharindu Kalhara on 9/21/2017.
 */
public interface ContactDao extends GenericDao<Integer,SampleContact> {
    public List<SampleContact> getAllContactsForUserId(int userId);
}
