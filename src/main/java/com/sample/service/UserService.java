package com.sample.service;

import com.sample.entity.SampleUser;
import org.springframework.http.ResponseEntity;

/**
 * Created by Tharindu Kalhara on 9/21/2017.
 */
public interface UserService {
    public ResponseEntity getAllUsers();
    public ResponseEntity addUser(SampleUser user);
    public ResponseEntity deleteUser(int userId);
}
