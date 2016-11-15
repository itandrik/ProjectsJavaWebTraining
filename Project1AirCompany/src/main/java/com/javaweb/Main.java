package com.javaweb;

import com.javaweb.controller.Controller;
import com.javaweb.view.View;

/**
 * Created by Dron on 12-Nov-16.
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.processUser();
        //https://ru.wikipedia.org/wiki/%D0%A1%D0%B0%D0%BC%D0%BE%D0%BB%D1%91%D1%82
    }
}
