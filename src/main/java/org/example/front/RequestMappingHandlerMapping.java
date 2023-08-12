package org.example.front;

import java.util.HashMap;
import java.util.Map;
import org.example.front.controller.Controller;
import org.example.front.controller.HomeController;

public class RequestMappingHandlerMapping {

    // [key] /users / [value] UserController
    private Map<String, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put("/", new HomeController());
    }

    public Controller findHandler(String uriPath) {
        return mappings.get(uriPath);
    }

}
