package br.com.franca.hrpayroll.resources;

import br.com.franca.hrpayroll.entities.Payment;
import br.com.franca.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentResource {

    private PaymentService paymentService;

    @Autowired
    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/payment/{workerID}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerID, @PathVariable Integer days){

        Payment payment = paymentService.getPayment(workerID,days);

        return ResponseEntity.ok(payment);
    }

}