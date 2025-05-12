package dev.nithin.Splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity (name = "group_splitwise")
public class Group extends BaseModel {
    private String groupName;
    private String description;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> members; // Issue
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Expense> expenses; // Issue -> fixed by adding the Join Column (Mapping Table instead of groupID in expense table)
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Transaction> transactions; // Issue -> fixed by adding the Join Column (Mapping Table instead of groupID in transaction table)
    private double totalAmountSpent;
    private boolean isAllSettledUp;

}
