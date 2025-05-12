package dev.nithin.Splitwise.service;

import dev.nithin.Splitwise.DTO.UserExpenseCreateRequestDTO;
import dev.nithin.Splitwise.model.UserExpense;
import dev.nithin.Splitwise.model.constant.UserExpenseType;
import dev.nithin.Splitwise.repository.UserExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExpenseService {

    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    private UserService userService;

    public UserExpense createUserExpense(UserExpenseCreateRequestDTO requestDTO) {
        UserExpense userExpense = new UserExpense();
        userExpense.setAmount(requestDTO.getAmount());
        userExpense.setUser(userService.findByID(requestDTO.getUserId()));
        if(requestDTO.getExpenseType() == 1) {
            userExpense.setExpenseType(UserExpenseType.HAS_PAID);
        } else{
            userExpense.setExpenseType(UserExpenseType.HAS_TO_PAY);
        }
        return userExpenseRepository.save(userExpense);
    }

}
