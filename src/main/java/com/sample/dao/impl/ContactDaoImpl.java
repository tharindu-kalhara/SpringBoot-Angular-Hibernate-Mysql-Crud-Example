package com.sample.dao.impl;

import com.sample.dao.ContactDao;
import com.sample.entity.SampleContact;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tharindu Kalhara on 9/21/2017.
 */
@Service
@Transactional
public class ContactDaoImpl extends GenericDaoImpl<Integer, SampleContact> implements ContactDao {

    @Override
    public List<SampleContact> getAllContactsForUserId(int userId) {
        System.out.println("ContactDaoImpl.getAllContactsForUserId");
        Criteria criteria = getSession().createCriteria(SampleContact.class, "SampleContact");
        criteria.createAlias("SampleContact.userId", "SampleUser");
        ProjectionList list = Projections.projectionList();
        list.add(Projections.property("SampleContact.contactId"));
        list.add(Projections.property("SampleContact.contact"));
        criteria.setProjection(list);
        criteria.add(Restrictions.eq("SampleUser.userId",userId));
        List<Object[]> dataList = criteria.list();
        List<SampleContact> responseList = new ArrayList<>();
        SampleContact contact;
        for (Object[] data : dataList) {
            contact = new SampleContact();
            contact.setContactId(getInteger(data[0].toString()));
            contact.setContact(getString(data[1].toString()));
            responseList.add(contact);
        }
        return responseList;
    }
}
