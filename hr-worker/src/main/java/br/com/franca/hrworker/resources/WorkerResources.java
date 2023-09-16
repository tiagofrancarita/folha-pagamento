package br.com.franca.hrworker.resources;

import br.com.franca.hrworker.entities.Worker;
import br.com.franca.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
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

    private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);

    private Environment env;

    private WorkerRepository workerRepository;

    @Autowired
    public WorkerResources(Environment env, WorkerRepository workerRepository) {
        this.env = env;
        this.workerRepository = workerRepository;
    }

    @GetMapping(value = "/listWorker")
    public ResponseEntity<List<Worker>> findAll(){

        List<Worker> listWorker = workerRepository.findAll();

        return ResponseEntity.ok(listWorker);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Worker> findById(@PathVariable  Long id){

        logger.info("Port:" + env.getProperty("local.server.port"));

        Worker worker = workerRepository.findById(id).get();

        return ResponseEntity.ok(worker);
    }
}