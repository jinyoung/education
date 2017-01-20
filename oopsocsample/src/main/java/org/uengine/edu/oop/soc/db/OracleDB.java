package org.uengine.edu.oop.soc.db;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class OracleDB extends DB {

    @Override
    public Object save() {
        System.out.println("Oracle 에 저장됨");

        return "1001 만원";
    }
}
