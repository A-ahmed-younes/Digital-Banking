package ma.enset.DigitalBankingBackend.dtos;

import lombok.Data;
import ma.enset.DigitalBankingBackend.enums.OperationType;

import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}

