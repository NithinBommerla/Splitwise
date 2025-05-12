package dev.nithin.Splitwise.service;

import dev.nithin.Splitwise.DTO.ExpenseCreateRequestDTO;
import dev.nithin.Splitwise.DTO.UserExpenseCreateRequestDTO;
import dev.nithin.Splitwise.exception.GroupNotFoundException;
import dev.nithin.Splitwise.model.Expense;
import dev.nithin.Splitwise.model.UserExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.nithin.Splitwise.repository.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserExpenseService userExpenseService;

    @Autowired
    private GroupService groupService;

    public Expense createExpense(ExpenseCreateRequestDTO requestDTO, int groupId) throws GroupNotFoundException {
        Expense expense = new Expense();
        expense.setAmount(requestDTO.getAmount());
        expense.setDescription(requestDTO.getDescription());
        expense.setAddedBy(userService.findByID(requestDTO.getExpenseAddedByID()));
        List<UserExpense> userExpenses = new ArrayList<>();
        for(UserExpenseCreateRequestDTO dto : requestDTO.getUserExpenses()) {
            userExpenses.add(userExpenseService.createUserExpense(dto));
        }
        expense.setUserExpenses(userExpenses);
        Expense savedExpense = expenseRepository.save(expense);
        groupService.addExpenseToGroup(groupId, expense);
        return savedExpense;
    }
}
