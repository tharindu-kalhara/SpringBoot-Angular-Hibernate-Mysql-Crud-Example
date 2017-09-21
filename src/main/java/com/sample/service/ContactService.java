package com.sample.service;

import org.springframework.http.ResponseEntity;

/**
 * Created by Tharindu Kalhara on 9/21/2017.
 */
public interface ContactService{
    public ResponseEntity getAllContactForUsrId(int userId);
}
