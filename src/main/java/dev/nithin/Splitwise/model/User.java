package dev.nithin.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    @ManyToMany
    private List<Group> groups;

}

/*
{
    "username" : "",
    "email" : "",
    "password" : "",
    "firstName" : "",
    "lastName" : "",
    "phone" : ""
}
 */
