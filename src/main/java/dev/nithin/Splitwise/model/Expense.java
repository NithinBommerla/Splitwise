package dev.nithin.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @OneToMany
    @JoinColumn(name = "expense_id") // nameOfModel_nameofPKAttribute -> expense_id
    private List<UserExpense> userExpenses; // Issue -> fixed by adding the Join Column (Mapping Table instead of expenseID in user_expense table)

}
