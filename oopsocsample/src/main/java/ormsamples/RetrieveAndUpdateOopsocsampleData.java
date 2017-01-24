/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateOopsocsampleData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().beginTransaction();
		try {
			org.uengine.edu.oop.soc.model.Account lorguengineeduoopsocmodelAccount= (org.uengine.edu.oop.soc.model.Account)org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().createQuery("From org.uengine.edu.oop.soc.model.Account").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().update(lorguengineeduoopsocmodelAccount);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateOopsocsampleData retrieveAndUpdateOopsocsampleData = new RetrieveAndUpdateOopsocsampleData();
			try {
				retrieveAndUpdateOopsocsampleData.retrieveAndUpdateTestData();
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
