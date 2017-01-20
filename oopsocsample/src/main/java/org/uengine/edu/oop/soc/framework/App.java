package org.uengine.edu.oop.soc.framework;

import org.uengine.edu.oop.soc.db.DB;
import org.uengine.edu.oop.soc.ui.UI;
import org.uengine.edu.oop.soc.ui.WindowUI;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class App {

    public static void main(String... args){

        UI ui = new WindowUI();
        Logic logic = new Logic();
        DB db = new DB();

        logic.setDb(db);
        ui.setLogic(logic);

        ui.doUI();

    }
}
