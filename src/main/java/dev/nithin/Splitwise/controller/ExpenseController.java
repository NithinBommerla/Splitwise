package dev.nithin.Splitwise.controller;

import dev.nithin.Splitwise.DTO.ExpenseCreateRequestDTO;
import dev.nithin.Splitwise.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import dev.nithin.Splitwise.service.ExpenseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expense/{groupID}")
    public ResponseEntity<Expense> addExpenseToGroup(@PathVariable("groupID") int groupID, @RequestBody ExpenseCreateRequestDTO request) {
        return ResponseEntity.ok(expenseService.createExpense(request, groupID));
    }
}
