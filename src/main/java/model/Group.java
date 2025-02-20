package model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Group extends BaseModel {
    private String groupName;
    private String description;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> users;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<Transaction> transactions;
    private boolean isAllSettledUp;

}
