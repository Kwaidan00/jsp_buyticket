/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.model;

import javax.persistence.EntityManager;

public class UserRepository {

    private static UserRepository instance = null;

    protected UserRepository() {}

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public User findById(long id) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        return entityManager.find(User.class, id);
    }

    public User save(User user) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    public void deleteById(long id) {

    }



}
