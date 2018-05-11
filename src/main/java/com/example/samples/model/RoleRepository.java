/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.model;

import javax.persistence.EntityManager;

public class RoleRepository {

    private static RoleRepository instance = null;

    protected RoleRepository() {}

    public static RoleRepository getInstance() {
        if (instance == null) {
            instance = new RoleRepository();
        }
        return instance;
    }


    public Role findById(long id) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        return entityManager.find(Role.class, id);
    }

    public Role save(Role role) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        if (role.getId() == 0) {
            entityManager.persist(role);
        } else {
            entityManager.merge(role);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return role;
    }


}
