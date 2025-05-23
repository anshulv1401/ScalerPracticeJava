package dev.anshul.splitwise.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private int amount;
    private String description;

    @ManyToOne
    private Group group;

    @ManyToOne
    private User addedBy;

    @OneToMany
    private List<ExpenseUser> expenseUsers;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
}
