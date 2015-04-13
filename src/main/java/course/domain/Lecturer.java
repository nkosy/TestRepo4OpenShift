package course.domain;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/04/07.
 */
public class Lecturer implements Serializable{
    private String firstName;
    private String lastName;
    private int age;

    private Lecturer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Lecturer(Builder builder){
        firstName=builder.firstName;
        lastName=builder.lastName;
        age=builder.age;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private int age;

        public Builder(String lastName) {
            this.lastName = lastName;
        }

        public Builder firstName(String value){
            this.firstName=value;
            return this;
        }

        public Builder age(int value){
            this.age=value;
            return this;

        }
        
        public Lecturer build(){
            return new Lecturer(this);
        }
    }
}
