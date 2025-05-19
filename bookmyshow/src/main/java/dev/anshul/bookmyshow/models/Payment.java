package dev.anshul.bookmyshow.models;

import dev.anshul.bookmyshow.models.emuns.PaymentMode;
import dev.anshul.bookmyshow.models.emuns.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel {
    private Long amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String transactionId;
}
