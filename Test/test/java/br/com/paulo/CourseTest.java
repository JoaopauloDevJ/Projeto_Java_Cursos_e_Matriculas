/**
 * @author João Paulo
 */

package test.java.br.com.paulo;

import br.com.paulo.DAO.CourseDAO;
import br.com.paulo.DAO.ICourseDAO;
import br.com.paulo.domain.Course;
import org.junit.Assert;
import org.junit.Test;

public class CourseTest {

    private ICourseDAO courseDAO;

    public CourseTest() {
        courseDAO = new CourseDAO();
    }

    @Test
    public void registerTest() {
        Course course = new Course();
        course.setCode("1");
        course.setName("Front end");
        course.setDescription("Curso focando em front end");
        courseDAO.register(course);

        Assert.assertNotNull(course);
        Assert.assertNotNull(course.getId());
    }
}
