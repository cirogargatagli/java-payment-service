package com.ajsw.java.payment.service.services;

import com.ajsw.java.payment.service.models.dto.request.PaymentMPRequest;
import com.ajsw.java.payment.service.models.dto.response.Response;
import com.ajsw.java.payment.service.repositories.IPaymentRepository;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final IPaymentRepository paymentRepository;

    public PaymentService(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Response payWithMP(PaymentMPRequest paymentMPRequest){
        MercadoPagoConfig.setAccessToken("TEST-3270230910219779-050921-f50e9b38e7349b758d28ce74f120d006-1120909340");

        PaymentClient client = new PaymentClient();

        PaymentCreateRequest createRequest =
                PaymentCreateRequest.builder()
                        .token(paymentMPRequest.getCardToken())
                        .transactionAmount(paymentMPRequest.getTransactionAmount())
                        .description(paymentMPRequest.getDescription())
                        .installments(paymentMPRequest.getInstallments())
                        .paymentMethodId(paymentMPRequest.getPaymentMethodId())
                        .payer(
                                PaymentPayerRequest.builder()
                                        .email(paymentMPRequest.getEmail())
                                        .firstName(paymentMPRequest.getFirstName())
                                        .identification(
                                                IdentificationRequest.builder()
                                                        .type(paymentMPRequest.getIdentificationType())
                                                        .number(paymentMPRequest.getIdentificationNumber())
                                                        .build())
                                        .build())
                        .build();

        try {
            Payment payment = client.create(createRequest);
            System.out.println(payment);
        } catch (MPApiException ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s%n",
                    ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
        } catch (MPException ex) {
            ex.printStackTrace();
        }
        return new Response();
    }

//    public Response savePayment(Payment payment){
//        return paymentRepository.save(payment);
//    }
}
