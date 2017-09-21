package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tharindu Kalhara on 9/22/2017.
 */
@Controller
public class IndexController {
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView Index() {
        System.out.println("IndexController.Index");
        return new ModelAndView("Index");
    }

}
