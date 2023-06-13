package com.ohgiraffers.machine;

import com.ohgiraffers.common.SnackDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        SnackDAO snackDAO = context.getBean("snackDAO",SnackDAO.class);

        System.out.println(snackDAO.findSnackbyNumber(5));
    }
}
