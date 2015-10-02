/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Person;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andreas
 */
public class Facade implements PersonInterface {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    
        private static EntityManager getEM() {
        return emf.createEntityManager();
    }

    @Override
    public Person addPerson(Person p) {
        EntityManager em = getEM();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    @Override
    public Person deletePerson(int id) {
                EntityManager em = getEM();
        em.getTransaction().begin();
        em.remove(em.find(Person.class, id));
        em.getTransaction().commit();
        return em.find(Person.class, id);
    }

    @Override
    public Person getPerson(int id) {
        EntityManager em = getEM();
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = getEM();
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public Person editPerson(Person p) {
        EntityManager em = getEM();
        em.find(Person.class, p);
        return em.merge(p);
    }

}
