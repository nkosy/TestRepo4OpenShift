package course.api;

import course.domain.Subject;
import course.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by hashcode on 2015/08/21.
 */
@RestController
@RequestMapping("/api/**")
public class SubjectPage {
    @Autowired
    private SubjectService service;

    //-------------------Retrieve All Subjects--------------------------------------------------------

    @RequestMapping(value = "/subjects/", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> listAllSubjects() {
        List<Subject> Subjects = service.findAll();
        if(Subjects.isEmpty()){
            return new ResponseEntity<List<Subject>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Subject>>(Subjects, HttpStatus.OK);
    }


    //-------------------Retrieve Single Subject--------------------------------------------------------

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subject> getSubject(@PathVariable("id") long id) {
        System.out.println("Fetching Subject with id " + id);
        Subject Subject = service.findById(id);
        if (Subject == null) {
            System.out.println("Subject with id " + id + " not found");
            return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Subject>(Subject, HttpStatus.OK);
    }



    //-------------------Create a Subject--------------------------------------------------------

    @RequestMapping(value = "/subject/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createSubject(@RequestBody Subject subject,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Subject " + subject.getName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(subject);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/subject/{id}").buildAndExpand(subject.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Subject --------------------------------------------------------

    @RequestMapping(value = "/subject/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Subject> updateSubject(@PathVariable("id") long id, @RequestBody Subject Subject) {
        System.out.println("Updating Subject " + id);

        Subject currentSubject = service.findById(id);

        if (currentSubject==null) {
            System.out.println("Subject with id " + id + " not found");
            return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
        }

        Subject updatedSubject = new Subject
                .Builder(currentSubject.getCode())
                .copy(currentSubject)
                .build();
        service.update(updatedSubject);
        return new ResponseEntity<Subject>(updatedSubject, HttpStatus.OK);
    }

    //------------------- Delete a Subject --------------------------------------------------------

    @RequestMapping(value = "/subject/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Subject> deleteSubject(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Subject with id " + id);

        Subject subject = service.findById(id);
        if (subject == null) {
            System.out.println("Unable to delete. Subject with id " + id + " not found");
            return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
        }

        service.delete(subject);
        return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
    }
}
