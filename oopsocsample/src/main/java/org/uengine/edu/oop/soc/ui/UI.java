package org.uengine.edu.oop.soc.ui;

import org.uengine.edu.oop.soc.framework.Logic;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class UI {

    private Logic logic;
        public Logic getLogic() {
            return logic;
        }
        public void setLogic(Logic logic) {
            this.logic = logic;
        }

    public void doUI() {
        System.out.println("결과값은 " + getLogic().doLogic() + "입니다.");
    }


}
