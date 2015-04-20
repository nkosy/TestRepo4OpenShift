package course.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/04/20.
 */
public class Faculty implements Serializable{
    private String id;
    private String name;
    @Embedded
    private ContactAddress address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Department> departments;

}
