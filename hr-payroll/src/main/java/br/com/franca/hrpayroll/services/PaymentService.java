package br.com.franca.hrpayroll.services;

import br.com.franca.hrpayroll.entities.Payment;
import br.com.franca.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private RestTemplate restTemplate;

    @Autowired
    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(long workerId, int days){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id",""+workerId);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/findById/{id}",Worker.class, uriVariables);
        return new Payment(worker.getName(),worker.getDailyIncome(),days);

    }
}