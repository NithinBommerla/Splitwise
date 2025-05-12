package dev.nithin.Splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExpenseCreateRequestDTO {
    private String description;
    private Double amount;
    private int expenseAddedByID;
    private List<UserExpenseCreateRequestDTO> userExpenses;

}
