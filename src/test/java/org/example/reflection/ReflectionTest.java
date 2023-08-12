package org.example.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Controller 애노테이션이 설정되어 있는 모든 클래스를 찾아서 출력한다.
 */
public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {

        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));

        logger.debug("beans: [{}]}", beans);
    }

    @Test
    void showClass() {

        Class<User> clazz = User.class;
        logger.debug(clazz.getName());

        logger.debug("User all declared fields: [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors: [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared methods: [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    /**
     * 힙 엽역에 로드되어 있는 클래스를 가져오는 방법 3가지
     * @throws ClassNotFoundException
     */
    @Test
    void load() throws ClassNotFoundException {
        // 1
        Class<User> clazz1 = User.class;

        // 2
        User user = new User("id", "name");
        Class<? extends User> clazz2 = user.getClass();

        // 3
        Class<?> clazz3 = Class.forName("org.example.model.User");


        logger.debug("clazz1: [{}]", clazz1);
        logger.debug("clazz2: [{}]", clazz2);
        logger.debug("clazz3: [{}]", clazz3);

        assertThat(clazz1 == clazz2).isTrue();
        assertThat(clazz2 == clazz3).isTrue();
        assertThat(clazz1 == clazz3).isTrue();
    }

    private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();

//        beans.addAll(reflection.getTypesAnnotatedWith(Controller.class));
//        beans.addAll(reflection.getTypesAnnotatedWith(Service.class));

        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));

        return beans;
    }
}
