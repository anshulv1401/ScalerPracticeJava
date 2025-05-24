package dev.anshul.splitwise.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "splitwise_groups")
public class Group extends BaseModel {

    private String name;
    private String description;

    // @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany()
    private List<User> mumbers;

    @OneToMany
    private User admin;

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}

// when, you have a list attribute inside a model, spring doesn't fetch it
// eagerly

// List lazy
// Primitive type
