package course.repository;

import course.App;
import course.domain.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/04/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudCourse {
    private Long id;

    @Autowired
    CourseRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Course> courses = new ArrayList<Course>();
        Course course = new Course.Builder("311")
                .name("National Diploma IT").offering(2015).build();
        repository.save(course);
        id=course.getId();
        Assert.assertNotNull(course.getId());
    }

    @Test
    public void testRead() throws Exception {
        Course course = repository.findOne(id);
        Assert.assertEquals("National Diploma IT",course.getName());
    }

//    @Test
    public void testUpdate() throws Exception {

        Course course = repository.findOne(id);
        Course newcourse = new Course.Builder("12").id(course.getId())
                .name("Diploma IT").offering(2014).build();
        repository.save(newcourse);
        Assert.assertEquals("Diploma IT", course.getName());
        Assert.assertEquals(2014, course.getOffering());

    }

//    @Test
    public void testDelete() throws Exception {
        Course course = repository.findOne(id);
        repository.delete(course);
        Course newcourse = repository.findOne(id);
        Assert.assertNull(newcourse);


    }
}
