package course.services.Impl;

import course.domain.Subject;
import course.repository.SubjectRepository;
import course.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/08/21.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository repository;
    @Override
    public Subject findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Subject save(Subject entity) {
        return repository.save(entity);
    }

    @Override
    public Subject update(Subject entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Subject entity) {
        repository.delete(entity);

    }

    @Override
    public List<Subject> findAll() {
        List<Subject> allsubjects = new ArrayList<>();
        Iterable<Subject> subjects = repository.findAll();
        for (Subject subject : subjects) {
            allsubjects.add(subject);
        }
        return allsubjects;
    }
}
