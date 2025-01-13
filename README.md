# Chronos - Design

## Distributed Job Scheduling System

### High-Level Design Overview

This document provides a concise overview of the distributed job scheduling system, including class diagrams, database schema, and architectural design.

### System Architecture

The system is designed using a modular and distributed architecture to ensure scalability and fault tolerance.

**Key Components:**

1. **Job API Service**: Handles job submissions, updates, and queries.
2. **Scheduler Service**: Manages job scheduling and execution.
3. **Worker Nodes**: Executes jobs based on instructions from the scheduler.
4. **Monitoring Service**: Tracks system health, logs, and job statuses.

### Class Diagram

**Classes:**

- **Job**: Represents a job with attributes such as ID, type, status, schedule, and retries.
- **User**: Represents a user with authentication and authorization details.
- **Scheduler**: Handles the scheduling logic.
- **Worker**: Executes the tasks.
- **Monitor**: Tracks logs and statuses.

### Database Schema

**Tables:**

1. **Users**
    - `user_id` (PK): Unique identifier for each user.
    - `username`: Username for authentication.
    - `password_hash`: Securely stored password hash.
    - `email`: Contact email.
2. **Jobs**
    - `job_id` (PK): Unique identifier for each job.
    - `user_id` (FK): User who submitted the job.
    - `job_type`: Type of job (e.g., one-time, recurring).
    - `status`: Current status (e.g., pending, running, failed).
    - `schedule`: Time or recurrence pattern.
    - `created_at`: Timestamp of job creation.
    - `updated_at`: Last updated timestamp.
3. **Job_Logs**
    - `log_id` (PK): Unique identifier for logs.
    - `job_id` (FK): Associated job ID.
    - `log_message`: Details of the log.
    - `timestamp`: Time of log entry.

### High-Level Design Diagram

**Workflow:**

1. Users interact with the system via RESTful APIs to submit and manage jobs.
2. The **Job API Service** authenticates users and forwards job requests to the Scheduler.
3. The **Scheduler** determines the execution timeline and assigns jobs to Worker Nodes.
4. **Worker Nodes** execute jobs and update their status in the database.
5. The **Monitoring Service** aggregates logs and tracks system metrics for failure detection and retries.

### Summary

This design ensures:

- Scalability through distributed workers.
- Reliability with retry mechanisms and monitoring.
- Flexibility for handling one-time and recurring jobs.