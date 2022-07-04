package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.TransactionAudit;

@Repository
public interface TransactionAuditRepository extends JpaRepository<TransactionAudit, Long> {

}
