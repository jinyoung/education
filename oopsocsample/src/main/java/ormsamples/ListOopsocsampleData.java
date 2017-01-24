/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class ListOopsocsampleData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Account...");
		java.util.List lAccountList = org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().getSession().createQuery("From org.uengine.edu.oop.soc.model.Account").setMaxResults(ROW_COUNT).list();
		org.uengine.edu.oop.soc.model.Account[] lorguengineeduoopsocmodelAccounts = (org.uengine.edu.oop.soc.model.Account[]) lAccountList.toArray(new org.uengine.edu.oop.soc.model.Account[lAccountList.size()]);
		int length = Math.min(lorguengineeduoopsocmodelAccounts.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lorguengineeduoopsocmodelAccounts[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public static void main(String[] args) {
		try {
			ListOopsocsampleData listOopsocsampleData = new ListOopsocsampleData();
			try {
				listOopsocsampleData.listTestData();
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
