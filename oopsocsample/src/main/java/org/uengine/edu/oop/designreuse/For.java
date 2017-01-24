package org.uengine.edu.oop.designreuse;

import java.util.*;

/**
 * Created by uengine on 2017. 1. 20..
 */
public abstract class For {

    public void run(Enumeration enumeration){
        while(enumeration.hasMoreElements()){
            logic(enumeration.nextElement());
        }
    }

    public void run(Iterator iter){
        while(iter.hasNext()){
            logic(iter.next());
        }
    }

    public void run(Collection list){
        run(list.iterator());
    }

    public void run(ArrayList list){
        for(int i=0; i<list.size(); i++){
            logic(list.get(i));
        }
    }

    public void run(Vector list){
        for(int i=0; i<list.size(); i++){
            logic(list.elementAt(i));
        }
    }

    public void run(Map map) throws Exception{
        run(map.values().iterator());
    }

    abstract public void logic(Object target);

    public static void main(String args[]) throws Exception {

        For lister = new For() {
            public void logic(Object target) {
                System.out.println(target);
            }
        };

        Vector vt = new Vector();
        vt.add("1");
        vt.add("2");
        vt.add("3");
        vt.add("4");
        vt.add("5");

        HashMap hm = new HashMap();
        hm.put("1", "a");
        hm.put("2", "b");
        hm.put("3", "c");
        hm.put("4", "d");
        hm.put("5", "e");
        hm.put("6", "f");

        lister.run(vt);
        lister.run(hm);

//        for(Object elem : vt){
//            System.out.println(elem);
//        }
//
//        for(Object elem : hm.values()){
//            System.out.println(elem);
//        }

    }

}
