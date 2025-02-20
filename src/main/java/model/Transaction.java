package model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
