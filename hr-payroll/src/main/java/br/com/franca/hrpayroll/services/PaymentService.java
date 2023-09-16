package br.com.franca.hrpayroll.services;

import br.com.franca.hrpayroll.entities.Payment;
import br.com.franca.hrpayroll.entities.Worker;
import br.com.franca.hrpayroll.feignclients.WorkerFeingClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class PaymentService {



    private WorkerFeingClients workerFeingClients;

    @Autowired
    public PaymentService(WorkerFeingClients workerFeingClients) {

        this.workerFeingClients = workerFeingClients;
    }

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeingClients.findById(workerId).getBody();
        return new Payment(worker.getName(),worker.getDailyIncome(),days);

    }
}