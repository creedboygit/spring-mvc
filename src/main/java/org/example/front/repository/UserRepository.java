package org.example.front.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.example.front.model.User;

public class UserRepository {

    private static Map<String, User> users = new HashMap<>();

    public static void save(User user) {
        users.put(user.getUserId(), user);
    }

    public static Collection<User> findAll() {
        return users.values();
    }
}
