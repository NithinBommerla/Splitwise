package model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Expense extends BaseModel {
    private String description;
    private Double amount;
    @ManyToOne
    private User addedBy;


}
