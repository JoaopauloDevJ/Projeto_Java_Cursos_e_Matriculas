/**
 * @author João Paulo
 */

package test.java.br.com.paulo;

import br.com.paulo.DAO.CourseDAO;
import br.com.paulo.DAO.ICourseDAO;
import br.com.paulo.DAO.IRegistrationDAO;
import br.com.paulo.DAO.RegistrationDAO;
import br.com.paulo.domain.Course;
import br.com.paulo.domain.Registration;
import org.junit.Test;

import java.time.Instant;

public class RegistrationTest {

    private IRegistrationDAO registrationDAO;

    private ICourseDAO courseDAO;

    public RegistrationTest() {
        registrationDAO = new RegistrationDAO();
        courseDAO = new CourseDAO();
    }

    @Test
    public void register() {
        Course course = CreateCourse("A1");
        Registration regis = new Registration();
        regis.setCode("1");
        regis.setDate(Instant.now());
        regis.setValue(200d);
        regis.setCourse(course);
        regis.setStatus("ATIVO");

        registrationDAO.register(regis);
    }

    public Course CreateCourse(String codigo) {
        Course course = new Course();
        course.setCode(codigo);
        course.setName("Java");
        course.setDescription("Back end Java");
        return courseDAO.register(course);
    }
}
