package org.uengine.edu.oop.soc.db;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.uengine.edu.oop.soc.db.*;

public class MySQLDB extends DB {

    @Override
    public Object save() {

        PersistentTransaction t = null;
        try {
            t = org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().beginTransaction();
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        try {
            org.uengine.edu.oop.soc.model.Account lorguengineeduoopsocmodelAccount = new org.uengine.edu.oop.soc.model.Account();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : balance, accountId
            lorguengineeduoopsocmodelAccount.setAccountId("JJY");
            lorguengineeduoopsocmodelAccount.setBalance(1000);
            org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().save(lorguengineeduoopsocmodelAccount);

            t.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                t.rollback();
            } catch (PersistentException e1) {
                e1.printStackTrace();
            }
        }

        return super.save();


    }
}