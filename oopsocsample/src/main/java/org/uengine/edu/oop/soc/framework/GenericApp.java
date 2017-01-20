package org.uengine.edu.oop.soc.framework;

import org.uengine.edu.oop.soc.db.DB;
import org.uengine.edu.oop.soc.ui.UI;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class GenericApp {

    public static void main(String... args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        UI ui = (UI) Class.forName("org.uengine.edu.oop.soc.ui."+ args[0]).newInstance();
        Logic logic = new Logic();//(Logic) Class.forName("org.uengine.edu.oop.soc.logic." + args[1]).newInstance();
        DB db = (DB) Class.forName("org.uengine.edu.oop.soc.db." + args[1]).newInstance();

        logic.setDb(db);
        ui.setLogic(logic);

        ui.doUI();

    }
}
