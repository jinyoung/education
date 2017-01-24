/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateOopsocsampleDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance());
			org.uengine.edu.oop.soc.model.OopsocsamplePersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
