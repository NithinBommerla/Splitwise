package dev.nithin.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import dev.nithin.Splitwise.model.constant.UserExpenseType;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType expenseType;
}
