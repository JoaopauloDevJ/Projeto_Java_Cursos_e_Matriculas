/**
 * @author João Paulo
 */

package test.java.br.com.paulo;

import br.com.paulo.DAO.*;
import br.com.paulo.domain.Classrom;
import br.com.paulo.domain.Course;
import br.com.paulo.domain.Registration;
import br.com.paulo.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class RegistrationTest {

    private IRegistrationDAO registrationDAO;

    private ICourseDAO courseDAO;

    private IStudentDAO studentDAO;

    private IClassromDAO classromDAO;

    public RegistrationTest() {
        registrationDAO = new RegistrationDAO();
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
        classromDAO = new ClassromDAO();
    }

    @Test
    public void register() {
        Course course = createCourse("1");
        Student student = createStudent("A2");

        Registration regis = new Registration();
        regis.setCode("1");
        regis.setDate(Instant.now());
        regis.setValue(200d);
        regis.setCourse(course);
        regis.setStatus("ATIVO");
        regis.setStudent(student);
        student.setRegistration(regis);

        registrationDAO.register(regis);

        Assert.assertNotNull(regis);
        Assert.assertNotNull(regis.getId());

        Registration regisDBC = registrationDAO.reshearByCourse(regis.getCourse());
        Assert.assertEquals(regis.getId(), regisDBC.getId());

        Registration regisDB = registrationDAO.reshearByCodeCourse(regis.getCode());
        Assert.assertEquals(regis.getId(), regisDB.getId());
    }

    public Course createCourse(String codigo) {
        Course course = new Course();
        course.setCode(codigo);
        course.setName("Java");
        course.setDescription("Back end Java");
        return courseDAO.register(course);
    }

    public Student createStudent(String code) {
        Classrom classrom = createClassrom("A5");

        Student student = new Student();
        student.setCode(code);
        student.setName("João Paulo");
        student.add(classrom);

        return studentDAO.register(student);
    }

    public Classrom createClassrom(String code) {
        Classrom classrom = new Classrom();
        classrom.setName("Sala 1");
        classrom.setCode(code);

        return classrom;
    }
}
