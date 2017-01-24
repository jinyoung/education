/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateOopsocsampleData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().beginTransaction();
		try {
			org.uengine.edu.oop.soc.model.Account lorguengineeduoopsocmodelAccount = new org.uengine.edu.oop.soc.model.Account();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : balance, accountId
			lorguengineeduoopsocmodelAccount.setAccountId("JJY");
			lorguengineeduoopsocmodelAccount.setBalance(1000);
			org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().save(lorguengineeduoopsocmodelAccount);
			
			t.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateOopsocsampleData createOopsocsampleData = new CreateOopsocsampleData();
			try {
				createOopsocsampleData.createTestData();
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
