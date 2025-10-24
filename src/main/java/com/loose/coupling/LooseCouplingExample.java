package com.loose.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LooseCouplingExample {
    public static void main(String[] args) {
       // UserDataProvider databaseProvider = new UserDatabaseProvider();
       // UserManager userManagerWithDB = new UserManager(databaseProvider);
       // System.out.println(userManagerWithDB.getUserInfo());

        UserDataProvider webServiceProvider = new WebServiceDataProvider();
        UserManager userManagerWithWS = new UserManager(webServiceProvider);
        System.out.println(userManagerWithWS.getUserInfo());

        UserDataProvider newDatabaseProvider = new NewDatabaseProvider();
        UserManager userManagerWithNewDB = new UserManager(newDatabaseProvider);
        System.out.println(userManagerWithNewDB.getUserInfo());


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationChallange.xml");
        UserManager userManagerFromSpring = (UserManager) context.getBean("userManagerWithUserDataProvider");
        System.out.println("buneeeee"+userManagerFromSpring.getUserInfo());

        UserManager userManagerFromSpring1 = (UserManager) context.getBean("userManagerWithWebServiceDataProvider");
        System.out.println("buneeeee"+userManagerFromSpring1.getUserInfo());
    }
}
//deneme