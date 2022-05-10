package com.ajsw.java.payment.service.models.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class PaymentMPRequest {
    @Getter
    @Setter
    @Email
    public String email;

    @Getter
    @Setter
    public String firstName;

    @Getter
    @Setter
    public BigDecimal transactionAmount;

    @Getter
    @Setter
    public String cardToken;

    @Getter
    @Setter
    public String paymentMethodId;

    @Getter
    @Setter
    public String description;

    @Getter
    @Setter
    public String identificationType;

    @Getter
    @Setter
    public String identificationNumber;

    @Getter
    @Setter
    @Min(1)
    @Max(12)
    public int installments;
}
