package org.example.cook;

public class Cooking {

    public Cook makeCook(MenuItem menuItem) {


//        return new Cook("피자", 5000);
        return new Cook(menuItem);
    }
}
