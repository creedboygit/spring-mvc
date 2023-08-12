package org.example.front;

import java.util.HashMap;
import java.util.Map;
import org.example.annotation.RequestMethod;
import org.example.front.controller.Controller;
import org.example.front.controller.ForwardController;
import org.example.front.controller.UserCreateController;
import org.example.front.controller.UserListController;

public class RequestMappingHandlerMapping implements HandlerMapping {

    // [key] /users / [value] UserController
//    private Map<String, Controller> mappings = new HashMap<>();
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
//        mappings.put("/", new HomeController());
//        mappings.put("/users", new UserListController());
//        mappings.put("/users", new UserCreateController());

//        mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form"));
    }

    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
