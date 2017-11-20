package ru.intodayer.servlets.service;

import ru.intodayer.servlets.utility.JPAUtility;
import javax.persistence.EntityManager;


public class BaseEntityService {
    public void save(Object obj) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
