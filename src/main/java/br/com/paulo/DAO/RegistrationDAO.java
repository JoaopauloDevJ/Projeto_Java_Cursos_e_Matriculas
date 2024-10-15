/**
 * @author João Paulo
 */

package br.com.paulo.DAO;


import br.com.paulo.domain.Course;
import br.com.paulo.domain.Registration;

import javax.persistence.*;

public class RegistrationDAO implements IRegistrationDAO {
    @Override
    public Registration register(Registration regis) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(regis);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Nenhum resultado encontrado para a pesquisa de registro: " + regis);
            System.out.println("Error: " + e);
            return regis;

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return regis;
    }

    @Override
    public Registration reshearByCodeCourse(String codeCourse) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Registration registration = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT r FROM Registration r ");
            sb.append(" INNER JOIN Course c on c = r.course ");
            sb.append(" WHERE c.code = :codeCourse ");

            TypedQuery<Registration> query = entityManager.createQuery(sb.toString(), Registration.class);
            query.setParameter("codeCourse", codeCourse);
            registration = query.getSingleResult();

        } catch (Exception e) {
            System.out.println("Nenhum resultado encontrado para o código do curso: " + codeCourse);
            System.out.println("Erro: " + e);
            return registration;

        } finally {
                entityManager.close();
                entityManagerFactory.close();
        }

        return registration;
    }

    @Override
    public Registration reshearByCourse(Course course) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Registration registration = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT r FROM Registration r ");
            sb.append(" INNER JOIN Course c on c = r.course ");
            sb.append(" WHERE c = :course ");


            TypedQuery<Registration> query = entityManager.createQuery(sb.toString(), Registration.class);
            query.setParameter("course", course);
            registration = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Nenhum resultado encontrado para a pesquisa do curso: " + course);
            System.out.println("Erro: " + e);
            return registration;

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return registration;
    }
}
