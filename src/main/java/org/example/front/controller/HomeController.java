package org.example.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.annotation.RequestMethod;
import org.example.front.annotation.RequestMapping;

@org.example.front.annotation.Controller
public class HomeController {
//public class HomeController implements Controller {

//    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "home";
    }
}
