package course.api;

import course.domain.Subject;
import course.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hashcode on 2015/08/21.
 */
@RestController
@RequestMapping("/api/**")
public class SubjectPage {
    @Autowired
    private SubjectService service;
    @RequestMapping(value = "subject/create",method = RequestMethod.POST)
    public String createSubject(){
        return null;
    }
    @RequestMapping(value = "subject/read{subjectId}",method = RequestMethod.GET)
    public Subject getSubject(@PathVariable("subjectId")	String subjectId){
        return service.findById(new Long(subjectId));
    }
    @RequestMapping(value = "subject/readall",method = RequestMethod.GET)
    public List<Subject> getSubjects(){
        return service.findAll();
    }
    @RequestMapping(value = "subject/update",method = RequestMethod.PUT)
    public String updateSubject(){
        return null;
    }
    @RequestMapping(value = "subject/delete",method = RequestMethod.DELETE)
    public String deleteSubject(){
        return null;
    }

}
