package com.sample.service.impl;

import com.sample.dao.ContactDao;
import com.sample.dto.contact.ViewContactDto;
import com.sample.entity.SampleContact;
import com.sample.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tharindu Kalhara on 9/21/2017.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactDao contactDao;

    @Override
    public ResponseEntity getAllContactForUsrId(int userId) {
        System.out.println("ContactServiceImpl.getAllContactForUsrId");
        List<SampleContact> sampleContacts = contactDao.getAllContactsForUserId(userId);
        if (sampleContacts.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            List<ViewContactDto> responseData = new ArrayList<>();
            ViewContactDto viewContactDto;
            for (SampleContact contact : sampleContacts) {
                viewContactDto = new ViewContactDto();
                viewContactDto.setContactId(contact.getContactId());
                viewContactDto.setContact(contact.getContact());
                responseData.add(viewContactDto);
            }
            return new ResponseEntity(responseData, HttpStatus.OK);
        }
    }
}
