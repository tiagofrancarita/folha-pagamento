package br.com.franca.hrpayroll.services;

import br.com.franca.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){

        return new Payment("bob",200.00,days);


    }


}
