package com.matharsa.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/banking")
public class GatewayController {

    private final TransactionRepository repository;

    public GatewayController(TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/ingest")
    public ResponseEntity<Transaction> ingestTransaction(@RequestBody Transaction transaction) {
        if (transaction.getAmount() > 10000.0) {
            transaction.setStatus("FRAUD_FLAG");
        } else {
            transaction.setStatus("SETTLED");
        }
        return ResponseEntity.ok(repository.save(transaction));
    }

    @GetMapping("/records")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(repository.findAll());
    }
}
