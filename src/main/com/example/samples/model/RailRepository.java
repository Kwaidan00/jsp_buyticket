/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.model;

import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RailRepository {

    private static RailRepository instance = null;

    protected RailRepository() {}

    public static RailRepository getInstance() {
        if (instance == null) {
            instance = new RailRepository();
        }
        return instance;
    }

    public City findCityById(long id) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        return entityManager.find(City.class, id);
    }

    public List<City> getAllCities() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<City> criteria = builder.createQuery(City.class);
        Root<City> from = criteria.from(City.class);
        criteria.select(from);
        return entityManager.createQuery(criteria).getResultList();
    }

    public List<City> findCityByExactString(String value) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<City> criteria = builder.createQuery(City.class);
        Root<City> from = criteria.from(City.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("name"), value));
        return entityManager.createQuery(criteria).getResultList();
    }

    public List<City> findCityByPartialString(String value) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<City> criteria = builder.createQuery(City.class);
        Root<City> from = criteria.from(City.class);
        criteria.select(from);
        criteria.where(builder.like(from.get("name"), "%" + value + "%"));
        return entityManager.createQuery(criteria).getResultList();
    }

    public List<RailLink> findRailLinkByStartCity(String value) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RailLink> criteria = builder.createQuery(RailLink.class);
        Root<RailLink> from = criteria.from(RailLink.class);
        criteria.select(from);
        criteria.where(builder.like(from.get("startCity").get("name"), "%" + value + "%"));
        return entityManager.createQuery(criteria).getResultList();
    }


    public City save(City city) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        if (city.getId() == 0) {
            entityManager.persist(city);
        } else {
            entityManager.merge(city);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return city;
    }

    public RailLink save(RailLink link) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        if (link.getId() == 0) {
            entityManager.persist(link);
        } else {
            entityManager.merge(link);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return link;
    }


}
