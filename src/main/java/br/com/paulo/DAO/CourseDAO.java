/**
 * @author João Paulo
 */

package br.com.paulo.DAO;


import br.com.paulo.domain.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CourseDAO implements ICourseDAO {

    @Override
    public Course register(Course course) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return course;
    }
}
