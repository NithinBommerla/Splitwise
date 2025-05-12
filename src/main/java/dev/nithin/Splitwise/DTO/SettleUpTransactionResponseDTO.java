package dev.nithin.Splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SettleUpTransactionResponseDTO {
    List<String> transactions;

}
