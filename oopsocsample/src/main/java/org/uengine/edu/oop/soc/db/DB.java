package org.uengine.edu.oop.soc.db;

import org.uengine.edu.oop.soc.model.*;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class DB {
    public Object save() {
        System.out.println("저장완료됨.");
        return "1000 만원";
    }

	public void loadData() {
		// TODO - implement DB.load
		throw new UnsupportedOperationException();
	}

	Account model;
}
