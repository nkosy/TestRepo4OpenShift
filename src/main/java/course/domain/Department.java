package course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/04/20.
 */
@Entity
public class Department  implements Serializable{
    @Id
    private Long id;
    private String name;
    @Embedded
    private ContactAddress address;
    @OneToMany
    private List<Lecturer> lecturers;
}
