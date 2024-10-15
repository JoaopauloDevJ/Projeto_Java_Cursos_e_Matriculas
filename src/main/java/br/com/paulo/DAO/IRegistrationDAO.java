/**
 * @author
 */

package br.com.paulo.DAO;


import br.com.paulo.domain.Course;
import br.com.paulo.domain.Registration;

public interface IRegistrationDAO {
    Registration register(Registration regis);

    Registration reshearByCodeCourse(String codeCourse);

    Registration reshearByCourse(Course course);
}
