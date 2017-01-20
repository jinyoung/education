package org.uengine.edu.oop.soc.framework;

import org.uengine.edu.oop.soc.db.DB;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class Logic {

    DB db;
        public DB getDb() {
            return db;
        }
        public void setDb(DB db) {
            this.db = db;
        }

    public String doLogic() {
        Object result = getDb().save();

        return result.toString();
    }


}
