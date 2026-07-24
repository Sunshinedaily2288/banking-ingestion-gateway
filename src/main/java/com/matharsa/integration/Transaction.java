package com.matharsa.integration;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MIGRATED_TRANSACTIONS")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceId;
    private Double amount;
    private String status; // PENDING, SETTLED, FRAUD_FLAG
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String refId) { this.referenceId = refId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
