package com.sample.service.impl;

import com.sample.dao.UserDao;
import com.sample.dto.message.SystemMessage;
import com.sample.dto.user.ViewUserDto;
import com.sample.entity.SampleUser;
import com.sample.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity getAllUsers() {
        System.out.println("UserServiceImpl.getAllUsers");
        List<SampleUser> dataList = userDao.getAll();
        if (dataList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            List<ViewUserDto> responseList = new ArrayList<>();
            ViewUserDto responseData;
            for (SampleUser user : dataList) {
                responseData = new ViewUserDto();
                responseData.setUserId(user.getUserId());
                responseData.setUsername(user.getUsername());
                responseData.setGender(user.getGender());
                responseData.setNic(user.getNic());
                responseList.add(responseData);
            }
            return new ResponseEntity(responseList, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity addUser(SampleUser user) {
        System.out.println("UserServiceImpl.addUser");
        for (int i = 0; i < user.getSampleContactCollection().size(); i++) {
            user.getSampleContactCollection().get(i).setUserId(user);
        }
        if (userDao.add(user) > 0) {
            return new ResponseEntity(new SystemMessage("User Added Success..!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new SystemMessage("Oops User Add Failed ;)"), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deleteUser(int userId) {
        System.out.println("UserServiceImpl.deleteUser");
        if (userDao.delete(SampleUser.class, userId) > 0) {
            return new ResponseEntity(new SystemMessage("Delete Success..!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new SystemMessage("Delete Failed..!"), HttpStatus.BAD_REQUEST);

        }
    }
}
