package org.uengine.edu.oop.soc.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.uengine.edu.oop.soc.db.DB;
import org.uengine.edu.oop.soc.framework.Logic;
import org.uengine.edu.oop.soc.ui.UI;
import org.uengine.edu.oop.soc.ui.WindowUI;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class SpringBanking {

    public static void main(String... args){

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");


        UI ui = context.getBean(UI.class);
        Logic logic = context.getBean(Logic.class);
        DB db = context.getBean(DB.class);

        logic.setDb(db);
        ui.setLogic(logic);

        ui.doUI();

    }

}
