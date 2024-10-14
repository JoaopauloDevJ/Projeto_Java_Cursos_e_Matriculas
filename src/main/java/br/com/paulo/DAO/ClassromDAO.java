/**
 * @author João Paulo
 */

package br.com.paulo.DAO;

import br.com.paulo.domain.Classrom;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClassromDAO implements IClassromDAO{

    @Override
    public Classrom register(Classrom classrom) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(classrom);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return classrom;
    }
}
