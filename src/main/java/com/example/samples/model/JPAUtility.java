/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {

    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("com.example.samples");
    }

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
    public static void close() {
        emFactory.close();
    }
}
