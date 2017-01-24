/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteOopsocsampleData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().beginTransaction();
		try {
			org.uengine.edu.oop.soc.model.Account lorguengineeduoopsocmodelAccount= (org.uengine.edu.oop.soc.model.Account)org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().createQuery("From org.uengine.edu.oop.soc.model.Account").setMaxResults(1).uniqueResult();
			org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().delete(lorguengineeduoopsocmodelAccount);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			DeleteOopsocsampleData deleteOopsocsampleData = new DeleteOopsocsampleData();
			try {
				deleteOopsocsampleData.deleteTestData();
			}
			finally {
				org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
