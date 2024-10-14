/**
 * @author João Paulo
 */

package br.com.paulo.DAO;


import br.com.paulo.domain.Registration;

import javax.persistence.*;

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

    @Override
    public Registration reshearByCodeCourse(String codeCourse) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT r FROM Registration r ");
        sb.append("INNER JOIN Course c on c = r.course ");
        sb.append("WHERE c.code = :codeCourse");

        entityManager.getTransaction().begin();
        TypedQuery<Registration> query = entityManager.createQuery(sb.toString(), Registration.class);
        query.setParameter("codeCourse", codeCourse);
        Registration registration = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return registration;
    }
}
