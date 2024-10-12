/**
 * @author João Paulo
 */

package br.com.paulo.DAO;


import br.com.paulo.domain.Registration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistrationDAO implements IRegistrationDAO {
    @Override
    public Registration register(Registration regis) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(regis);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return regis;
    }
}
