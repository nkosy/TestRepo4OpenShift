package course.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hashcode on 2015/04/13.
 */
public class CourseTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCourse() throws Exception {
        Course course = new Course.Builder("ND4").name("NDP").offering(2015).build();
        Assert.assertEquals("NDP",course.getName());

    }
}
