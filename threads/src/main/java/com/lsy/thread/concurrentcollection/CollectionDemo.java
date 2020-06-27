package com.lsy.thread.concurrentcollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author YY
 */
public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "User" + i);
            list.add(user);
        }
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if ("User6".equals(user.getName())) {
                //ConcurrentModificationException
                list.remove(user);
            }
        }
        System.out.println(list.toString());
    }
}
