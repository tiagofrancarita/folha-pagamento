package br.com.franca.hrworker.resources;

import br.com.franca.hrworker.entities.Worker;
import br.com.franca.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

    private WorkerRepository workerRepository;

    @Autowired
    public WorkerResources(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping(value = "/listWorker")
    public ResponseEntity<List<Worker>> findAll(){

        List<Worker> listWorker = workerRepository.findAll();

        return ResponseEntity.ok(listWorker);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Worker> findById(@PathVariable  Long id){

        Worker worker = workerRepository.findById(id).get();

        return ResponseEntity.ok(worker);
    }
}