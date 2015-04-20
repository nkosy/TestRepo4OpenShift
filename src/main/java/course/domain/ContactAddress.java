package course.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/04/20.
 */
@Embeddable
public class ContactAddress implements Serializable{
    private String email;
    private String postalCode;

}
