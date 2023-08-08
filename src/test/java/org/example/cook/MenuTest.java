package org.example.cook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuTest {

    @DisplayName("메뉴판에서 메뉴 이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {

        Menu menu = new Menu(List.of(
                new MenuItem("치킨", 4000),
                new MenuItem("콜라", 2000),
                new MenuItem("파스타", 3000)
        ));

        MenuItem menuItem = menu.choose("파스타");

        assertThat(menuItem).isEqualTo(new MenuItem("파스타", 3000));
    }

    @DisplayName("메뉴판에 없는 메뉴를 선택할 시 예외를 반환한다.")
    @Test
    void chooseTest2() {

        Menu menu = new Menu(List.of(
                new MenuItem("치킨", 4000),
                new MenuItem("콜라", 2000),
                new MenuItem("파스타", 3000)
        ));

        assertThatCode(() -> menu.choose("뿌링클"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");

    }
}
