package dev.nithin.Splitwise.strategy;

import dev.nithin.Splitwise.DTO.SettleUpTransactionResponseDTO;
import dev.nithin.Splitwise.model.Group;

public interface SettleUpStrategy {
    SettleUpTransactionResponseDTO settleUp(Group group);
}
