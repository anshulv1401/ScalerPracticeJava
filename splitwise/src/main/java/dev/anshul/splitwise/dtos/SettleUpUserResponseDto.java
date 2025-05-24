package dev.anshul.splitwise.dtos;

import java.util.List;

import dev.anshul.splitwise.CustomObjects.Transaction;
import lombok.Getter;
import lombok.Setter;

/*
My system will return all the expenses where I am involved and suggest me the list of txn I should make to settle up
 */
@Getter
@Setter
public class SettleUpUserResponseDto {
    List<Transaction> transactions;
}
