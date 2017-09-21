package com.sample.controller;

import com.sample.entity.SampleUser;
import com.sample.service.ContactService;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tharindu Kalhara on 9/21/2017.
 */
@Controller
@RequestMapping(value = {"user"})
public class ViewUsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public ModelAndView viewUsers() {
        System.out.println("ViewUsersController.viewUsers");
        return new ModelAndView("ViewUsers");
    }

    @RequestMapping(value = {"get"}, method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {
        System.out.println("ViewUsersController.getAllUsers");
        return userService.getAllUsers();
    }

    @RequestMapping(value = {"get/contact"}, method = RequestMethod.GET)
    public ResponseEntity getContactsForUser(@RequestParam("userId") Integer userId) {
        System.out.println("ViewUsersController.getContactsForUser");
        return contactService.getAllContactForUsrId(userId);
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody SampleUser sampleUser) {
        System.out.println("ViewUsersController.getContactsForUser");
        return userService.addUser(sampleUser);
    }

    @RequestMapping(value = {"delete/{userId}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("ViewUsersController.deleteUser");
        return userService.deleteUser(userId);
    }


}
