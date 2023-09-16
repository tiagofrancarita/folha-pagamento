package br.com.franca.hrpayroll.feignclients;

import br.com.franca.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeingClients {

    @GetMapping(value = "/findById/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
