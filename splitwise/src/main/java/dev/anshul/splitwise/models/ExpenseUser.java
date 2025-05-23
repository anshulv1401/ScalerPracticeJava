package dev.anshul.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExpenseUser extends BaseModel {
    private int amount;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
    private String currency;
}
