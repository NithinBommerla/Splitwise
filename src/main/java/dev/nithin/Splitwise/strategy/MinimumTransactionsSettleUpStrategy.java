package dev.nithin.Splitwise.strategy;

import dev.nithin.Splitwise.DTO.SettleUpTransactionResponseDTO;
import dev.nithin.Splitwise.model.Expense;
import dev.nithin.Splitwise.model.Group;
import dev.nithin.Splitwise.model.User;
import dev.nithin.Splitwise.model.UserExpense;
import dev.nithin.Splitwise.model.constant.UserExpenseType;

import java.util.HashMap;
import java.util.List;

public class MinimumTransactionsSettleUpStrategy implements SettleUpStrategy {
    public SettleUpTransactionResponseDTO settleUp(Group group) {
        SettleUpTransactionResponseDTO responseDTO = new SettleUpTransactionResponseDTO();
        HashMap<User, Double> finalAmountPerUser = new HashMap<>();
        List<Expense> expenses = group.getExpenses();
        for (Expense expense : expenses) {
            for(UserExpense userExpense : expense.getUserExpenses()) {
                if(finalAmountPerUser.containsKey(userExpense.getUser())) {
                    double currentAmount = finalAmountPerUser.get(userExpense.getUser());
                    if(userExpense.getExpenseType().equals(UserExpenseType.HAS_PAID)) {
                        currentAmount += userExpense.getAmount();
                    } else {
                        currentAmount -= userExpense.getAmount();
                    }
                    finalAmountPerUser.put(userExpense.getUser(), currentAmount);
                } else {
                    double currentAmount = 0;
                    if(userExpense.getExpenseType().equals(UserExpenseType.HAS_PAID)) {
                        currentAmount += userExpense.getAmount();
                    } else {
                        currentAmount -= userExpense.getAmount();
                    }
                    finalAmountPerUser.put(userExpense.getUser(), currentAmount);
                }
            }
        }


        return responseDTO;
    }


}
