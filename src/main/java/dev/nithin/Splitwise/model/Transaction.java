package dev.nithin.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Transaction extends BaseModel {
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    private Double amount;
}
