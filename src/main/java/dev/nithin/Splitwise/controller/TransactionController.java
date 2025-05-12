package dev.nithin.Splitwise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import dev.nithin.Splitwise.service.TransactionService;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
}
