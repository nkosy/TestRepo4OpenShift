package course.api;

import course.domain.Department;
import course.domain.Faculty;
import course.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hashcode on 2015/05/10.
 */

@RestController
@RequestMapping(value="/faculty/**")
public class FacultyPage {
    @Autowired
    private FacultyService service;
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Department> getFaculty(@PathVariable Long id) {


        // ...
        return service.getDepatments(id);
    }
//
//    @RequestMapping(value="/{id}/departments", method=RequestMethod.GET)
//    List<Department> getFacultyDepartments(@PathVariable Long id) {
//        // ...
//    }
//
//    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//    public Faculty deleteUser(@PathVariable Long id) {
//        // ...
//    }
//

}
