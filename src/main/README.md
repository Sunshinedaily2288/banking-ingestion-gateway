# Cloud Banking Ingestion Gateway 🏦

An enterprise-grade, high-throughput integration gateway built with Spring Boot to securely ingest, validate, and store raw financial transaction events. This system demonstrates the decoupling of fast ingestion networks from strict transactional database ledgers.

## 🚀 Key Architectural Strengths

*   **Asynchronous Ingestion Ready:** Decouples structural ingestion endpoints from backend ledger systems, enabling ultra-low latency API responses.
*   **Real-Time Data Screening:** Built-in business logic engine that evaluates processing payloads in real-time, automatically routing suspect transactions to specialized `FRAUD_FLAG` states.
*   **Decoupled SQL Staging Design:** Auto-configures an isolated relational schema to log transaction metadata (`PENDING`, `SETTLED`, `FRAUD_FLAG`) before processing deep ledger writes.
*   **Zero-Downtime Infrastructure Integration:** Built to serve as the critical entry point layer for modular microservice ecosystems, matching modern banking infrastructure patterns.

## 🛠️ Tech Stack & Dependencies

*   **Framework:** Java 17 + Spring Boot 3.2.2
*   **Integration Layer:** Spring Web (REST API Model)
*   **Data Layer:** Spring Data JPA (Object-Relational Mapping)
*   **Database:** H2 Database (In-Memory Engine for high-speed local integration testing)
*   **Build Automation:** Apache Maven

## 💻 System API Endpoints

### 1. Ingest Raw Transactions
*   **Method / Route:** `POST /api/v1/banking/ingest`
*   **Payload Example:**
    ```json
    {
      "referenceId": "TXN-7789",
      "amount": 12500.0
    }
    ```
*   **Response Logic:** Automatically evaluates risk parameters. Amounts above `10,000.0` trigger an immediate `FRAUD_FLAG` audit state inside the SQL engine.

### 2. Retrieve Operational Audit Logs
*   **Method / Route:** `GET /api/v1/banking/records`
*   **Description:** Pulls the comprehensive, immutable ingestion sequence history currently active inside the database layer.

---
*Developed as a modular portfolio component for enterprise integration and backend engineering architectures.*
