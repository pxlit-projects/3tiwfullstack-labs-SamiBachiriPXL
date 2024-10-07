package be.pxl.domain;

import be.pxl.domain.user.Age;
import be.pxl.domain.user.Email;
import be.pxl.domain.user.Name;

public class User {
    private Age age;
    private Name name;
    private Email email;

    private long Id;

    public Age getAge() {
        return age;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public long getId() {
        return Id;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setId(long id) {
        Id = id;
    }
}
